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
	
    private RestTemplate restTemplate = new RestTemplate(); // HTTP 요청을 보내기 위한 Spring 클래스
    private KakaoReadyResponse kakaoReady; // 결제 준비 응답 객체를 저장
    
    // 카카오페이 요청에 필요한 헤더 정보 구성 메서드
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + payProperties.getAdminKey()); // 인증 키 설정
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); // 요청 타입
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); // 응답 타입
        return headers;
    }
    
    
    /**
     * 결제 준비 요청 (결제창 URL 생성)
     */
    public KakaoReadyResponse kakaoPayReady(HotelDto bookingItem) {
    	
    	System.out.println("[Service] 총 결제 금액 : " + bookingItem.getHtbTotalPrice());
    	
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + payProperties.getAdminKey());
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        
        // 파라미터 생성
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", payProperties.getCid()); // 가맹점 코드
        parameters.add("partner_order_id", "ORDER_ID"); // 주문번호 (고정값, 추후 수정 가능)     
        parameters.add("partner_user_id", "USER_ID"); // 사용자 ID (고정값, 추후 수정 가능)
        parameters.add("item_name", "결제 금액"); // 상품명
        parameters.add("quantity", "1");
        
        // 총 결제 금액 지정, 없으면 기본값 사용
        Integer totalPrice = bookingItem.getHtbTotalPrice();
        if (totalPrice == null) {
            totalPrice = 1000; // 기본값
        }
        
        parameters.add("total_amount", String.valueOf(totalPrice));
        parameters.add("vat_amount", "200");
        parameters.add("tax_free_amount", "0");
        
        // 결제 성공/실패/취소 시 이동할 UR
        parameters.add("approval_url", "http://localhost:8080/v1/infra/usrmember/paymentComplete");
        parameters.add("cancel_url", "http://localhost:8080/payment/cancel");
        parameters.add("fail_url", "http://localhost:8080/payment/fail");
        
        // 요청 생성
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, getHeaders());
        
        // 카카오페이 API 요청
        return restTemplate.postForObject(
            "https://kapi.kakao.com/v1/payment/ready",
            requestEntity,
            KakaoReadyResponse.class
        );
    }
    
    
           
    
    /**
     * 결제 승인 요청
     */
    public KakaoApproveResponse approveResponse(String pgToken, HotelDto bookingItem) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", payProperties.getCid()); 
        parameters.put("tid", kakaoReady.getTid()); // 결제 준비 시 받은 거래 ID
        parameters.put("partner_order_id", "ORDER_ID"); // 고정값
        parameters.put("partner_user_id", "USER_ID"); // 고정값
        parameters.put("pg_token", pgToken); // 결제 성공 시 반환된 토큰

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
        
        // 결제 승인 요청
        return restTemplate.postForObject(
            "https://kapi.kakao.com/v1/payment/approve",
            requestEntity,
            KakaoApproveResponse.class
        );
    }



}
