//package com.ador.infra.kakaopay;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.RequiredArgsConstructor;
//
//
//@RestController
//@RequestMapping("/payment")
//@RequiredArgsConstructor
//public class KakaoPayController {
//	
//	@Autowired
//	KakaoPayService kakaoPayService;
//	
//	@PostMapping("/ready")
//	public ResponseEntity<KakaoReadyResponse> readyToKakaoPay() {
//	    KakaoReadyResponse response = kakaoPayService.kakaoPayReady();
//	    return ResponseEntity.ok(response);
//	}
//
//	@GetMapping("/cancel")
//	public void cancel() {
//	    throw new BusinessLogicException(ExceptionCode.PAY_CANCEL);
//	}
//
//	@GetMapping("/fail")
//	public void fail() {
//	    throw new BusinessLogicException(ExceptionCode.PAY_FAILED);
//	}
//
//  
//
//}
