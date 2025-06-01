package com.ador.infra.kakaopay;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class KakaoPayService {
	
	@Autowired
	private KakaoPayProperties payProperties;
	
    private RestTemplate restTemplate = new RestTemplate();
    private KakaoReadyResponse kakaoReady;


    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String auth = "KakaoAK " + payProperties.getSecretKey();
        headers.set("Authorization", auth);
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");
        return headers; 
    }
    
    /**   
     * 결제 완료 요청
     */
    public KakaoReadyResponse kakaoPayReady() {
    	
    	System.out.println("카카오페이 요청시작");
    	System.out.println("Authorization: KakaoAK " + payProperties.getSecretKey());
    	System.out.println("URL: https://kapi.kakao.com/v1/payment/ready");
    	
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("cid", payProperties.getCid());
        parameters.put("partner_order_id", "ORDER_ID"); // 실제 주문 번호로 교체
        parameters.put("partner_user_id", "USER_ID");   // 실제 사용자 ID로 교체
        parameters.put("item_name", "ITEM_NAME");       // 실제 상품명으로 교체
        parameters.put("quantity", "1");                 // 수량, 숫자는 문자열로 전달
        parameters.put("total_amount", "2200");          // 총 금액, 숫자는 문자열로 전달
        parameters.put("vat_amount", "200");             // 부가세, 숫자는 문자열로 전달
        parameters.put("tax_free_amount", "0");          // 비과세 금액, 숫자는 문자열로 전달
        parameters.put("approval_url", "Web에서 등록한 URL/success");
        parameters.put("fail_url", "Web에서 등록한 URL/fail");
        parameters.put("cancel_url", "Web에서 등록한 URL/cancel");

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());


        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        kakaoReady = restTemplate.postForObject(
                //"https://open-api.kakaopay.com/online/v1/payment/ready",
        		"https://kapi.kakao.com/v1/payment/ready",
                requestEntity,
                KakaoReadyResponse.class
                );
        
        return kakaoReady;
    }
    
    /**
     * 결제 완료 승인
     */
    public KakaoApproveResponse approveResponse (String pgToken){
    
        // 카카오 요청
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", payProperties.getCid());
        parameters.put("tid", kakaoReady.getTid());
        parameters.put("partner_order_id", "ORDER_ID");
        parameters.put("partner_user_id", "USER_ID");
        parameters.put("pg_token", pgToken);

        // 파라미터, 헤더
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
        System.out.println();
        System.out.println();
        System.out.println(requestEntity);
        System.out.println();
        System.out.println();

        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        KakaoApproveResponse approveResponse = restTemplate.postForObject(
                "https://open-api.kakaopay.com/online/v1/payment/approve",
                requestEntity,
                KakaoApproveResponse.class);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(approveResponse);
        System.out.println();
        System.out.println();
        System.out.println();
        return approveResponse;
    }

}
