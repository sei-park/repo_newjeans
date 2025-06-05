package com.ador.infra.kakaopay;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.ador.infra.hotel.HotelDto;

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


//    private HttpHeaders getHeaders() {
//        HttpHeaders headers = new HttpHeaders();
//        String auth = "KakaoAK " + payProperties.getAdminKey();
//        headers.set("Authorization", auth);
//        headers.set("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//        headers.set("Accept", "application/json");
//        return headers; 
//    }
    
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + payProperties.getAdminKey());
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }
    
    /**
     * 결제 완료 요청
     */
    public KakaoReadyResponse kakaoPayReady(HotelDto bookingItem) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + payProperties.getAdminKey());
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    	
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", payProperties.getCid());
        parameters.add("partner_order_id", "ORDER_ID");
        parameters.add("partner_user_id", "USER_ID");
        parameters.add("item_name", "ITEM_NAME");
        parameters.add("quantity", "1");
        parameters.add("total_amount", "2200");
        parameters.add("vat_amount", "200");
        parameters.add("tax_free_amount", "0");
        parameters.add("approval_url", "http://localhost:8080/v1/infra/usrmember/paymentComplete");
        parameters.add("cancel_url", "http://localhost:8080/payment/cancel");
        parameters.add("fail_url", "http://localhost:8080/payment/fail");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, getHeaders());

        return restTemplate.postForObject(
            "https://kapi.kakao.com/v1/payment/ready",
            requestEntity,
            KakaoReadyResponse.class
        );
    }
    
    
    
    
    /**
     * 결제 완료 승인
     */
//    public KakaoApproveResponse approveResponse (String pgToken){
//    
//        // 카카오 요청
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("cid", payProperties.getCid());
//        parameters.put("tid", kakaoReady.getTid());
//        parameters.put("partner_order_id", "ORDER_ID");
//        parameters.put("partner_user_id", "USER_ID");
//        parameters.put("pg_token", pgToken);
//
//        // 파라미터, 헤더
//        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
//        System.out.println();
//        System.out.println();
//        System.out.println(requestEntity);
//        System.out.println();
//        System.out.println();
//
//        // 외부에 보낼 url
//        RestTemplate restTemplate = new RestTemplate();
//
//        KakaoApproveResponse approveResponse = restTemplate.postForObject(
//                //"https://open-api.kakaopay.com/online/v1/payment/approve",
//        		"https://kapi.kakao.com/v1/payment/approve",
//                requestEntity,
//                KakaoApproveResponse.class);
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println(approveResponse);
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        return approveResponse;
//    }
    
    
    public KakaoApproveResponse approveResponse(String pgToken, HotelDto bookingItem) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", payProperties.getCid());
        parameters.put("tid", kakaoReady.getTid());
        parameters.put("partner_order_id", "ORDER_ID"); // 나중에 bookingItem에서 가져와도 됨
        parameters.put("partner_user_id", "USER_ID");
        parameters.put("pg_token", pgToken);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        return restTemplate.postForObject(
            "https://kapi.kakao.com/v1/payment/approve",
            requestEntity,
            KakaoApproveResponse.class
        );
    }



}
