package com.ador.infra.hotelmember;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoAuthService {
	
	 	@Value("${kakao.client-id}")
	    private String clientId;

	    @Value("${kakao.redirect-uri}")
	    private String redirectUri;

	    public KakaoTokenResponse getAccessToken(String code) throws IOException {
	        String reqUrl = "https://kauth.kakao.com/oauth/token";

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

	        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	        params.add("grant_type", "authorization_code"); 
	        params.add("client_id", clientId);
	        params.add("redirect_uri", redirectUri);
	        params.add("code", code);

	        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<KakaoTokenResponse> response = restTemplate.postForEntity(
	            reqUrl, request, KakaoTokenResponse.class
	        );

	        return response.getBody();
	    }

}
