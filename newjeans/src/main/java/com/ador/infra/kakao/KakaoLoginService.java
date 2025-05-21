package com.ador.infra.kakao;

import org.springframework.stereotype.Service;
import org.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class KakaoLoginService {
	
	// 카카오 로그인 후 사용자 정보를 가져옴
	// 카카오 API를 통해 사용자 정보를 요청하고, 이를 KakaoUserDto 객체로 반환
	
	public KakaoUserDto getUserInfo(String accessToken) {
        KakaoUserDto dto = null;

        try {
        	// 카카오 API에 요청을 보내기 위한 HTTP 클라이언트를 생성
            OkHttpClient client = new OkHttpClient();
            // 카카오 사용자 정보 API에 GET 요청을 생성. 이때, Authorization 헤더에 액세스 토큰을 포함시켜 인증
            Request request = new Request.Builder() 
                    .url("https://kapi.kakao.com/v2/user/me")
                    .get()
                    .addHeader("Authorization", "Bearer " + accessToken)
                    .build();
            
            // 요청을 실행하고 응답 본문을 문자열로 변환
            Response response = client.newCall(request).execute(); 
            String body = response.body().string();
            
            // 응답 JSON에서 kakao_account와 profile 객체를 추출
            JSONObject jsonObject = new JSONObject(body);
            JSONObject kakaoAccount = jsonObject.getJSONObject("kakao_account"); 
            JSONObject profile = kakaoAccount.getJSONObject("profile");
            
            // 사용자의 ID, 닉네임, 이메일을 추출. 이메일의 경우 존재 여부를 확인 후 추출
            String id = jsonObject.get("id").toString();
            String nickname = profile.getString("nickname");
            String email = kakaoAccount.has("email") ? kakaoAccount.getString("email") : "";
            
            // 추출한 정보를 기반으로 KakaoUserDto 객체를 생성하여 반환
            dto = new KakaoUserDto(id, nickname, email);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dto;
    }
	
	

}
