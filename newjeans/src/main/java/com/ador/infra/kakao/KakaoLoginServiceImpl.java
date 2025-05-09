//package com.ador.infra.kakao;
//
//import org.json.JSONObject;
//import org.springframework.stereotype.Service;
//
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//@Service
//public class KakaoLoginServiceImpl implements KakaoLoginService {
//	
//	    @Override
//	    public KakaoUserDto getUserInfo(String accessToken) {
//	        KakaoUserDto dto = null;
//
//	        try {
//	            OkHttpClient client = new OkHttpClient();
//	            Request request = new Request.Builder()
//	                    .url("https://kapi.kakao.com/v2/user/me")
//	                    .get()
//	                    .addHeader("Authorization", "Bearer " + accessToken)
//	                    .build();
//
//	            Response response = client.newCall(request).execute();
//	            String body = response.body().string();
//
//	            JSONObject jsonObject = new JSONObject(body);
//	            JSONObject kakaoAccount = jsonObject.getJSONObject("kakao_account");
//	            JSONObject profile = kakaoAccount.getJSONObject("profile");
//
//	            String id = jsonObject.get("id").toString();
//	            String nickname = profile.getString("nickname");
//	            String email = kakaoAccount.has("email") ? kakaoAccount.getString("email") : "";
//
//	            dto = new KakaoUserDto(id, nickname, email);
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//
//	        return dto;
//	    }
//
//}
