package com.ador.infra.kakaopay;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ador.infra.hotel.HotelDto;
import com.ador.infra.hotel.HotelService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class KakaoPayController {
	
	@Autowired
	KakaoPayService kakaoPayService;
	
	@Autowired
	HotelService hotelService;
	
	
	 /**    
     * 결제 요청 (결제창 이동)
     */
	@RequestMapping("/kakaoPay")
	public String kakaoPayReady(HttpSession session, @RequestParam("htbseq") String htbseq) {
		
	    HotelDto tmp = new HotelDto();
	    tmp.setHtbseq(htbseq);
	    
	    // DB에서 결제에 필요한 전체 정보 조회
	    HotelDto full = hotelService.paymentSelectOne(tmp);  // DB에서 완전한 데이터 가져오기

	    System.out.println("총 결제 금액 (controller): " + full.getHtbTotalPrice());
	    
	    // 세션에 결제 정보 저장
	    session.setAttribute("bookingItem", full);  
	    
	    // 결제 준비 요청 후 결제 URL 반환
	    KakaoReadyResponse kakaoReady = kakaoPayService.kakaoPayReady(full);
	     
	    // 사용자 브라우저를 결제창 URL로 리다이렉트
	    return "redirect:" + kakaoReady.getNext_redirect_pc_url();
	}


    
    /**
     * 결제 성공 콜백 처리
     */
    @GetMapping("/kakaoPay/success")
    public String afterPayRequest(@RequestParam("pg_token") String pgToken, HttpSession session) {
    	
        HotelDto bookingItem = (HotelDto) session.getAttribute("bookingItem");

        if (bookingItem == null) {
            return "error";
        }
        
        // 결제 승인 요청
        KakaoApproveResponse kakaoApprove = kakaoPayService.approveResponse(pgToken, bookingItem);

        // 결제 상태 업데이트 후 DB 저장
        bookingItem.setBookingStatus(1);
        hotelService.insertBooking(bookingItem); 
        
        // 세션에서 결제 정보 제거
        session.removeAttribute("bookingItem");
        
		return "redirect:/v1/infra/usrmember/paymentComplete";
    }

   
  
    /**
     * 결제 진행 중 취소
     */
    @GetMapping("/cancel")
    public void cancel() {

        throw new BusinessLogicException(ExceptionCode.PAY_CANCEL);
    }

    
    /**
     * 결제 실패
     */
    @GetMapping("/fail")
    public void fail() {

        throw new BusinessLogicException(ExceptionCode.PAY_FAILED);
    }
    
    
    // http://localhost:8080/payment/ready
    

}
