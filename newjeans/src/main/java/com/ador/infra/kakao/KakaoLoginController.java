package com.ador.infra.kakao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

@Controller
public class KakaoLoginController {
	
	// KakaoLoginService 에서 사용자 정보를 가져오고 KakaoLoginController 에서 이를 처리함
	// 카카오 로그인 요청을 처리하고 콜백을 통해 사용자 정보를 받아 세션에 저장
	
	@Autowired
	private KakaoLoginService kakaoLoginService;
	
	
	// 로그인 요청 처리 : 사용자를 카카오 로그인 페이지로 리다이렉트
	@RequestMapping(value="/kakaoUrl", method=RequestMethod.GET)
    public String KakaoRedirect(@RequestParam(value = "state", required = false) String state, HttpSession session) {
		
	    if (state != null) {
		        session.setAttribute("kakao_redirect", state);  // 세션에 저장
		}   
		
        String redirectUri = "http://localhost:8080/auth/login/kakao"; // 카카오 로그인 후 리다이렉트될 URI
        String clientId = "c8323bd1164b06cbdaa6e19f1382b07e"; // 카카오 애플리케이션의 REST API
        
        return "redirect:https://kauth.kakao.com/oauth/authorize?client_id=" + clientId
                + "&redirect_uri=" + redirectUri 
                + "&response_type=code" // OAuth 2.0 인증 코드 방식을 사용
                + (state != null ? "&state=" + state : "");  // 요청 시 전달된 상태 정보를 그대로 전달
    }
    
	
	// 로그인 콜백 처리
	// 카카오로부터 받은 인증 코드를 사용하여 액세스 토큰을 요청하고 이를 통해 사용자 정보를 가져와 세션에 저장
    @RequestMapping(value="/auth/login/kakao", method=RequestMethod.GET)
    public String kakaoCallback(@RequestParam("code") String code,
            @RequestParam(value = "state", required = false) String state,
            HttpSession session) {
    	
    	
        try {
            // 1. Access Token 요청
            OkHttpClient client = new OkHttpClient();
            RequestBody body = new FormBody.Builder()
                    .add("grant_type", "authorization_code")
                    .add("client_id", "c8323bd1164b06cbdaa6e19f1382b07e")
                    .add("redirect_uri", "http://localhost:8080/auth/login/kakao")
                    .add("code", code) // code  
                    .build();

            Request request = new Request.Builder()
                    .url("https://kauth.kakao.com/oauth/token")
                    .post(body)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .build();

            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            
            System.out.println("카카오 access_token 응답: " + responseBody);
            
            JSONObject json = new JSONObject(responseBody);
            String accessToken = json.getString("access_token");

            // 2. Service 호출해서 사용자 정보 가져오기
            KakaoUserDto userDto = kakaoLoginService.getUserInfo(accessToken);
            
            // 3. 세션에 사용자 정보 저장
            session.setAttribute("kakaoUser", userDto);
            session.setAttribute("sessSeqUsr", userDto.getId()); // 인터셉터 방지
            session.setAttribute("sessNameUsr", userDto.getNickname()); // 사용자 닉네임
            session.setAttribute("sessEmailUsr", userDto.getEmail()); // 사용자 이메일   
            
            System.out.println("카카오 로그인 완료: " + userDto.toString());
            
            System.out.println("카카오 아이디: " + userDto.getId());
            System.out.println("카카오 닉네임: " + userDto.getNickname());
            System.out.println("카카오 이메일: " + userDto.getEmail());      
            
            // 4. 리다이렉트 처리 
            String redirectUrl = (state != null) ? state : "/v1/infra/usrmember/usrIndex";
           
            return "redirect:" + redirectUrl;

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error"; // 실패 시 에러 페이지로
        } 

    }



} // End
