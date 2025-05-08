package com.ador.infra.kakao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ador.infra.hotelmember.HotelMemberService;

import jakarta.servlet.http.HttpSession;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

public class KakaoLoginController {
	
	@Autowired
	HotelMemberService hotelMemberService;
	
	private static final Logger Log = LoggerFactory.getLogger(KakaoLoginController.class);
	
	@RequestMapping(value="/kakaoUrl", method=RequestMethod.GET)
	public String Kakao(Model model, HttpSession session) {
		  
		System.out.println("카카오 로그인 확인");
		
		Log.info("kakaoLogin 호출");
		String redirect_uri = "http://localhost:8080/auth/login/kakao";
		String rest_api = "c8323bd1164b06cbdaa6e19f1382b07e";
		String response_type = "code";
		
		return "redirect:https://kauth.kakao.com/oauth/authorize?client_id=" + rest_api
		        + "&redirect_uri=" + redirect_uri + "&response_type=" + response_type;
	}
	
	@RequestMapping(value="/auth/login/kakao", method=RequestMethod.GET)
	public String kakaoCallback(String code, HttpSession session) {
	    Log.info("카카오 인가 코드 받음: " + code);

	    // 1. 토큰 요청 파라미터 설정
	    String tokenUrl = "https://kauth.kakao.com/oauth/token";
	    String grantType = "authorization_code";
	    String clientId = "c8323bd1164b06cbdaa6e19f1382b07e";
	    String redirectUri = "http://localhost:8080/auth/login/kakao";

	    // 2. HTTP 요청 보내기
	    try {
	        // OkHttp, RestTemplate, WebClient 등 사용 가능. 예시: OkHttp
	    	OkHttpClient client = new OkHttpClient();
	        RequestBody body = new FormBody.Builder()
	            .add("grant_type", grantType)
	            .add("client_id", clientId)
	            .add("redirect_uri", redirectUri)
	            .add("code", code)
	            .build();

	        Request request = new Request.Builder()
	            .url(tokenUrl)
	            .post(body)
	            .header("Content-Type", "application/x-www-form-urlencoded")
	            .build();

	        Response response = client.newCall(request).execute();
	        String responseBody = response.body().string();
	        System.out.println("토큰 응답: " + responseBody);

	        // JSON 파싱 후 access_token 추출
	        // access_token을 세션에 저장하거나 사용자 정보 요청에 사용

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "redirect:/usr/v1/infra/usrmember/usrIndex"; // 로그인 후 이동할 페이지
	}
	
	// 사용자 정보 요청
	public Map<String, Object> getKakaoUserInfo(String accessToken) {
	    Map<String, Object> userInfo = new HashMap<>();
	    
	    try {
	        OkHttpClient client = new OkHttpClient();

	        Request request = new Request.Builder()
	                .url("https://kapi.kakao.com/v2/user/me")
	                .get()
	                .addHeader("Authorization", "Bearer " + accessToken)
	                .build();

	        Response response = client.newCall(request).execute();
	        String body = response.body().string();
	        
	        // JSON 파싱 (Jackson 또는 org.json 사용 가능)
	        JSONObject jsonObject = new JSONObject(body);
	        JSONObject kakaoAccount = jsonObject.getJSONObject("kakao_account");
	        JSONObject profile = kakaoAccount.getJSONObject("profile");

	        String id = jsonObject.get("id").toString();
	        String nickname = profile.getString("nickname");
	        String email = kakaoAccount.has("email") ? kakaoAccount.getString("email") : "";

	        userInfo.put("id", id);
	        userInfo.put("nickname", nickname);
	        userInfo.put("email", email);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return userInfo;
	}



}
