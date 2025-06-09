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
     * 결제요청
     */
//    @PostMapping("/ready")
//    public KakaoReadyResponse readyToKakaoPay() {
//
//        return kakaoPayService.kakaoPayReady();
//    }
    
    
//    @PostMapping("/kakaoPay/ready")
//    public void kakaoPayReady(@RequestParam("htbseq") String htbseq, HttpServletResponse response) throws IOException {
//        HotelDto hotelDto = new HotelDto();
//        hotelDto.setHtbseq(htbseq);
//
//        // 예약 정보 조회 (금액, 객실명 등)
//        HotelDto bookingItem = hotelService.paymentSelectOne(hotelDto);
//
//        // 결제 요청 (카카오페이 결제 준비)
//        KakaoReadyResponse kakaoReady = kakaoPayService.kakaoPayReady(bookingItem);
//
//        // 카카오페이 결제 URL로 리다이렉트
//        response.sendRedirect(kakaoReady.getNext_redirect_pc_url());
//    }
    
    
    // 세션에 저장
//    @RequestMapping("/kakaoPay")
//    public String kakaoPayReady(HttpSession session, HotelDto bookingItem) {
//    	
//    	 //DB에서 bookingItem을 다시 조회해서 완전한 정보 확보
//        HotelDto fullBookingItem = hotelService.paymentSelectOne(bookingItem);
//
//        System.out.println("카카오페이 요청 직전 총 결제 금액: " + fullBookingItem.getHtbTotalPrice());
//    	
//        session.setAttribute("bookingItem", bookingItem); // 결제에 필요한 정보 세션에 저장
//        KakaoReadyResponse kakaoReady = kakaoPayService.kakaoPayReady(bookingItem);
//        return "redirect:" + kakaoReady.getNext_redirect_pc_url();
//        
//    }
	
	@RequestMapping("/kakaoPay")
	public String kakaoPayReady(HttpSession session, @RequestParam("htbseq") String htbseq) {
	    HotelDto tmp = new HotelDto();
	    tmp.setHtbseq(htbseq);
	    HotelDto full = hotelService.paymentSelectOne(tmp);  // DB에서 완전한 데이터 가져오기

	    System.out.println("총 결제 금액 (controller): " + full.getHtbTotalPrice());

	    session.setAttribute("bookingItem", full);  // 세션에 저장
	    KakaoReadyResponse kakaoReady = kakaoPayService.kakaoPayReady(full);
	    return "redirect:" + kakaoReady.getNext_redirect_pc_url();
	}

	
	

    
    /**
     * 결제성공
     */
    @GetMapping("/kakaoPay/success")
    public String afterPayRequest(@RequestParam("pg_token") String pgToken, HttpSession session) {
        HotelDto bookingItem = (HotelDto) session.getAttribute("bookingItem");

        if (bookingItem == null) {
            return "error";
        }
        
        KakaoApproveResponse kakaoApprove = kakaoPayService.approveResponse(pgToken, bookingItem);

        // 결제 상태 저장 (1: 결제완료)
        bookingItem.setBookingStatus(1);
        hotelService.insertBooking(bookingItem); 

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
     * 결제실패
     */
    @GetMapping("/fail")
    public void fail() {

        throw new BusinessLogicException(ExceptionCode.PAY_FAILED);
    }
    
    
    // http://localhost:8080/payment/ready
    

}
