package com.ador.infra.usrProduct;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ador.infra.hotel.HotelDto;
import com.ador.infra.hotel.HotelService;
import com.ador.infra.hotel.HotelVo;
import com.ador.infra.hotelmember.HotelMemberService;
import com.ador.infra.hotelreview.HotelReviewDto;
import com.ador.infra.hotelreview.HotelReviewService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class usrProductController {     
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	HotelReviewService hotelReviewService;
	
	@Autowired
	HotelMemberService hotelMemberService;
	
	            
	// 호텔 리스트
	@RequestMapping(value="/v1/infra/usrmember/usrHotelList")  
	public String usrHotelList(@ModelAttribute("vo") HotelVo hotelVo, Model model) {
		
		hotelVo.setParamsPaging(hotelService.selectOneCount(hotelVo));
		  
		if(hotelVo.getTotalRows() > 0) {
			model.addAttribute("hotelList", hotelService.hotelList(hotelVo));
		}  
		
		// 별점으로 검색하기 (확인)
		if(hotelVo.getStarsArr() != null) {
			if(hotelVo.getStarsArr().length > 0) {
				for(int i = 0; i < hotelVo.getStarsArr().length; i++) { 
					System.out.println("별점 체크 : " + hotelVo.getStarsArr()[i] + "점");
				}
			} 
		}
		
		return "usr/v1/infra/usrmember/usrHotelList"; 
	}   
	 
	// 호텔 상세페이지 
	@RequestMapping(value="/v1/infra/usrmember/usrHotelDetails")
	public String usrHotelDetails(@ModelAttribute("vo") HotelDto hotelDto, HotelReviewDto hotelReviewDto, Model model) {
		
		model.addAttribute("hotelRoomItem", hotelService.hotelSelectOne(hotelDto)); // selectOne
		model.addAttribute("hotelDetailList", hotelService.hotelDetailList(hotelDto)); // 호텔 상세 list
		model.addAttribute("hotelReviewList", hotelReviewService.hotelReviewList(hotelReviewDto)); // 호텔 리뷰 list
		return "usr/v1/infra/usrmember/usrHotelDetails"; 
	}
	                            
	// insert
	@RequestMapping(value="/v1/infra/usrmember/usrHotelDetailsInst")
	public String usrHotelDetailsInst(HotelReviewDto hotelReviewDto) {

		hotelReviewService.hotelReviewInsert(hotelReviewDto);
		return "redirect:/usr/v1/infra/usrmember/usrHotelDetails";
	}
	 
	
	// 상세페이지에서 예약 정보 insert
	// 호텔 예약 정보 처리, 사용자 세션 정보를 활용해서 예약 데이터 저장
	@RequestMapping(value="/v1/infra/usrmember/usrHotelBookingInst")
	public String usrHotelBookingInst(HotelDto hotelDto,@RequestParam("menuSeqs") List<String> menuSeqs, HttpSession httpSession) {
		
		
		// 세션에서 sessSeqUsr 값 가져오기
	    String sessSeqUsr = (String) httpSession.getAttribute("sessSeqUsr"); 
	    
//	    if(sessSeqUsr == null) {
//	        // 세션에 사용자 정보가 없으면 로그인 페이지로 리다이렉트
//	        return "redirect:/v1/infra/usrmember/usrSignin";
//	    } 
//	
//	    // 로그인이 된 경우: 세션 정보를 활용해 예약 처리
//	    hotelDto.setHotelmember_htmSeq(sessSeqUsr);
//	    hotelDto.setMenuSeqs(menuSeqs); // HotelDto에 menuSeqs 필드 설정
//	    
//	    // 예약 삽입 처리
//	    hotelService.hotelBookingInsert(hotelDto);
//	    hotelService.hotelBookingMenuInsert(hotelDto);
	  
	    
	    if (sessSeqUsr != null) {
			// hotelMember_htmSeq로 사용되는 값 설정
	    	hotelDto.setHotelMember_htmSeq(sessSeqUsr);
			
			// menuSeqs 값을 hotelDto에 설정
	    	hotelDto.setMenuSeqs(menuSeqs);	// shopDto에 menuSeqs 필드 추가
			
			// totalPrice 값 설정 (자동으로 폼에서 전달된 값이 hotelDto로 바인딩됨)
			System.out.println("총 금액: " + hotelDto.getHtbTotalPrice()); // 확인용 출력
			
			// 실제 BookingInsert와 관련된 서비스 호출
			hotelService.hotelBookingInsert(hotelDto);
			hotelService.hotelBookingMenuInsert(hotelDto);
			
			// htbseq 값을 결제페이지로 리다이렉션 
			return "redirect:/usr/v1/infra/usrmember/usrHotelBooking?htbseq=" + hotelDto.getHtbseq();
			
		} else {
			// 세션에 사용자 정보가 없으면 처리
			return "redirect:/usr/v1/infra/usrmember/usrSignin"; // 로그인 페이지로 리디렉션
		}
	      
	}
	
	// 호텔 결제 페이지
	@RequestMapping(value="/v1/infra/usrmember/usrHotelBooking")
	public String usrHotelBooking(HotelDto hotelDto, @RequestParam("htbseq") String htbseq, Model model) {
			
		model.addAttribute("bookingItem", hotelService.paymentSelectOne(hotelDto)); // 결제 정보 출력
		model.addAttribute("bookingMenuList", hotelService.paymentSelectList(hotelDto)); // hotelRoom 정보 출력
		model.addAttribute("hotelItem", hotelService.paymentHotelSelectOne(hotelDto)); // hotel 정보 출력 
		return "usr/v1/infra/usrmember/usrHotelBooking";
	}
	
	// 결제 정보 업데이트
	@RequestMapping(value="/v1/infra/usrmember/usrHotelBookingUpdt")
	public String usrHotelBookingUpdt(HotelDto hotelDto) {
		
		hotelService.bookingUpdate(hotelDto);
		return "usr/v1/infra/usrmember/paymentComplete";
	}  
	 
	// 결제 완료
	@RequestMapping(value="/v1/infra/usrmember/paymentComplete")
	public String paymentComplete() {
		return "usr/v1/infra/usrmember/paymentComplete";
	}
	
	// 예약 내역 
	@RequestMapping(value="/v1/infra/usrmember/usrHotelBookingHistory")
	public String usrHotelBookingHistory(@ModelAttribute("vo") HotelVo hotelVo, Model model, HttpSession httpSession) { 
		
		// 세션에서 sessSeqUsr 값 가져오기
	    String sessSeqUsr = (String) httpSession.getAttribute("sessSeqUsr");
	    
	    // hotelVo에 htmseq를 set
	    hotelVo.setHtmSeq(sessSeqUsr);
	    
	    // 로그인 여부 확인
	    if (sessSeqUsr == null) {
	        // 세션에 사용자 정보가 없으면 로그인 페이지로 리다이렉트   
	        return "redirect:/usr/v1/infra/usrmember/usrIndex";
	    }  
	    
	    // 사용자 ID를 기반으로 예약 내역 조회
	    //List<HotelDto> bookingHistoryList = hotelService.bookingHistorySelectList(hotelVo);

	    // 조회한 데이터를 모델에 추가
	    //model.addAttribute("bookingHistoryList", bookingHistoryList);
	    
	    hotelVo.setParamsPaging(hotelService.bookingHistorySelectOneCount(hotelVo));
	    
	    if(hotelVo.getTotalRows() > 0) {
	    	model.addAttribute("bookingHistoryList", hotelService.bookingHistorySelectList(hotelVo));
		} 
		
		//model.addAttribute("bookingHistoryList", hotelService.bookingHistorySelectList());
		return "usr/v1/infra/usrmember/usrHotelBookingHistory";
	} 
	 
	
   

		  

}
