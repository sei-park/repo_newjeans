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
import com.ador.infra.hotelreview.HotelReviewDto;
import com.ador.infra.hotelreview.HotelReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class usrProductController {     
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	HotelReviewService hotelReviewService;             
	
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
	 
	// 호텔 결제 페이지
	@RequestMapping(value="/usr/v1/infra/usrmember/usrHotelBooking")
	public String usrHotelBooking() {
		return "usr/v1/infra/usrmember/usrHotelBooking";
	}
	
	// 상세페이지에서 예약 정보 insert
	@RequestMapping(value="/usr/v1/infra/usrmember/usrHotelBookingInst")
	public String usrHotelBookingInst(HotelDto hotelDto,@RequestParam("menuSeqs") List<String> menuSeqs, HttpSession httpSession) {
		
		// 세션에서 sessSeqXdm 값 가져오기
	    String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm"); 
	    
	    if (sessSeqXdm != null) {
			// B_user_usrSeq로 사용되는 값 설정
	    	hotelDto.setHotelmember_htmSeq(sessSeqXdm);
			
			// menuSeqs 값을 shopDto에 설정
	    	hotelDto.setMenuSeqs(menuSeqs);	// shopDto에 menuSeqs 필드 추가
			
			// boTotalPrice 값 설정 (자동으로 폼에서 전달된 값이 ShopDto로 바인딩됨)
			System.out.println("총 금액: " + hotelDto.getHtbTotalPrice()); // 확인용 출력
			
			// 실제 shopBookingInsert와 관련된 서비스 호출
			hotelService.hotelBookingInsert(hotelDto);
			hotelService.hotelBookingMenuInsert(hotelDto);
		} else {
			// 세션에 사용자 정보가 없으면 처리
			return "redirect:/usr/v1/infra/usrmember/usrHotelList"; // 로그인 페이지로 리디렉션
		}
	    
	    return "usr/v1/infra/usrmember/usrHotelBooking";

	}


	         
	
	
	  
	 
	     
	                       
	    

	    
		  

}
