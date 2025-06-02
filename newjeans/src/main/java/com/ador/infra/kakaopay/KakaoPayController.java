package com.ador.infra.kakaopay;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController	
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
    
    
    @PostMapping("/kakaoPay/ready")
    public void kakaoPayReady(@RequestParam("htbseq") String htbseq, HttpServletResponse response) throws IOException {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setHtbseq(htbseq);

        // 예약 정보 조회 (금액, 객실명 등)
        HotelDto bookingItem = hotelService.paymentSelectOne(hotelDto);

        // 결제 요청 (카카오페이 결제 준비)
        KakaoReadyResponse kakaoReady = kakaoPayService.kakaoPayReady(bookingItem);

        // 카카오페이 결제 URL로 리다이렉트
        response.sendRedirect(kakaoReady.getNext_redirect_pc_url());
    }
    
    
    // 세션에 저장
    @PostMapping("/kakaoPay")
    public String kakaoPay(HttpSession session, HotelDto bookingItem) {
        KakaoReadyResponse kakaoReady = kakaoPayService.kakaoPayReady(bookingItem);

        // 예약번호와 tid를 Map으로 세션에 저장
        Map<String, String> kakaoTidMap = (Map<String, String>) session.getAttribute("kakaoTidMap");
        if (kakaoTidMap == null) {
            kakaoTidMap = new HashMap<>();
        }
        kakaoTidMap.put(bookingItem.getHtbseq(), kakaoReady.getTid());
        session.setAttribute("kakaoTidMap", kakaoTidMap);

        return "redirect:" + kakaoReady.getNext_redirect_pc_url();
    }

    
    /**
     * 결제성공
     */
//    @PostMapping ("/success")
//    public ResponseEntity<KakaoApproveResponse> afterPayRequest(@RequestParam("pg_token") String pgToken) {
//
//        KakaoApproveResponse kakaoApprove = kakaoPayService.approveResponse(pgToken);
//
//        return new ResponseEntity<>(kakaoApprove, HttpStatus.OK);
//    }
    
   
//    @GetMapping("/kakaoPay/success")
//    public String afterPayRequest(@RequestParam("pg_token") String pgToken, Model model) {
//        KakaoApproveResponse approve = kakaoPayService.approveResponse(pgToken);
//        
//        // 결제 완료 후 예약 내역으로 이동
//        model.addAttribute("approve", approve);
//        return "redirect:/v1/infra/usrmember/usrHotelBookingList";
//    }
    
  

    
    
    
	
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
