package com.ador.infra.usrProduct;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ador.infra.hotel.HotelDto;
import com.ador.infra.hotel.HotelService;
import com.ador.infra.hotel.HotelVo;
import com.ador.infra.hotelmember.HotelMemberService;
import com.ador.infra.hotelreview.HotelReviewDto;
import com.ador.infra.hotelreview.HotelReviewService;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import jakarta.servlet.http.HttpSession;

@Controller
public class usrProductController {     
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	HotelReviewService hotelReviewService;
	
	@Autowired
	HotelMemberService hotelMemberService;
	
	// 호텔 메인 페이지
	@RequestMapping(value="/v1/infra/usrmember/usrIndex")
	public String usrIndex(HotelDto hotelDto, Model model) {
		
		model.addAttribute("bestHotelList", hotelService.bestHotelList(hotelDto));
		return "usr/v1/infra/usrmember/usrIndex";
	}
	            
	// 호텔 리스트
	@RequestMapping(value="/v1/infra/usrmember/usrHotelList")  
	public String usr(@ModelAttribute("vo") HotelVo hotelVo, Model model) {
		
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
		
//		 List<HotelDto> hotelDetailList = hotelService.hotelDetailList(hotelDto);
//		    
//		    // 이미지 리스트 생성
//		    for (HotelDto detail : hotelDetailList) {
//		        List<String> images = new ArrayList<>();
//		        if (detail.getSubImg02() != null) images.add(detail.getSubImg02());
//		        if (detail.getSubImg03() != null) images.add(detail.getSubImg03());
//		        if (detail.getSubImg04() != null) images.add(detail.getSubImg04());
//		        detail.setImages(images); // HotelDto에 추가된 images 필드
//		        
//		    }
		
		model.addAttribute("hotelRoomItem", hotelService.hotelSelectOne(hotelDto)); // selectOne
		model.addAttribute("hotelDetailList", hotelService.hotelDetailList(hotelDto)); // 호텔 상세 list
		model.addAttribute("hotelReviewList", hotelReviewService.hotelReviewList(hotelReviewDto)); // 호텔 리뷰 list
		return "usr/v1/infra/usrmember/usrHotelDetails"; 
	}
	
	// 리뷰 댓글 insert
	@ResponseBody
	@RequestMapping(value="/v1/infra/usrmember/usrHotelDetailsInst", method = RequestMethod.POST)
	public Map<String, Object> usrHotelDetailsInst(@RequestParam("htseq") String htseq, HotelReviewDto hotelReviewDto, HttpSession httpSession) { 
		Map<String, Object> response = new HashMap<String, Object>();
		
		// 세션에서 sessSeqUsr 값 가져오기
	    String sessSeqUsr = (String) httpSession.getAttribute("sessSeqUsr");
	    String sessIdUsr = (String) httpSession.getAttribute("sessIdUsr");
	    
	    hotelReviewDto.setHotelmember_htmSeq(sessSeqUsr);
	    hotelReviewDto.setHotel_seq(htseq);
	    
	    hotelReviewDto.setHtrId(sessIdUsr); // 리뷰 아이디
	    //hotelReviewDto.setHtmId(sessIdUsr);
	   
		
	    int result = hotelReviewService.hotelReviewInsert(hotelReviewDto);
	    
	    if (result > 0) {
	    	response.put("success", true); 
	    	response.put("htrecomments", hotelReviewDto.getHtrecomments());
	    	response.put("htrestars", hotelReviewDto.getHtrestars());
	    	response.put("htrId", hotelReviewDto.getHtrId());
	    	response.put("htreRegDate", hotelReviewDto.getHtreRegDate());
	     } else {
	        System.out.println("댓글 등록 실패");
	     }
	    
	    
	    return response;  
		
	}
	 
	
	// 상세페이지에서 예약 정보 insert
	// 호텔 예약 정보 처리, 사용자 세션 정보를 활용해서 예약 데이터 저장
	@RequestMapping(value="/v1/infra/usrmember/usrHotelBookingInst")
	public String usrHotelBookingInst(HotelDto hotelDto, @RequestParam("menuSeqs") List<String> menuSeqs, HttpSession httpSession) {
		
		
		// 세션에서 sessSeqUsr 값 가져오기
	    String sessSeqUsr = (String) httpSession.getAttribute("sessSeqUsr"); 
	    
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
			return "redirect:/v1/infra/usrmember/usrHotelBooking?htbseq=" + hotelDto.getHtbseq();
			
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
		
		System.out.println("호텔 룸 결제 페이지 확인");
		HotelDto bookingItem = hotelService.paymentSelectOne(hotelDto);
		System.out.println("총 결제 금액 : " + bookingItem.getHtbTotalPrice());    
		  
		return "usr/v1/infra/usrmember/usrHotelBooking";
	}	
	
	// 결제 정보 업데이트
	@RequestMapping(value="/v1/infra/usrmember/usrHotelBookingUpdt")
	public String usrHotelBookingUpdt(HotelDto hotelDto) {
		
		System.out.println("호텔 결제 정보 Controller");
		
		hotelService.bookingUpdate(hotelDto);
		return "usr/v1/infra/usrmember/paymentComplete";
	}  
	 
	// 결제 완료
	@RequestMapping(value="/v1/infra/usrmember/paymentComplete")
	public String paymentComplete() {
		return "usr/v1/infra/usrmember/paymentComplete";
	}
	
	// 예약 내역 
	@RequestMapping(value="/usr/v1/infra/usrmember/usrHotelBookingHistory")
	public String usrHotelBookingHistory(@ModelAttribute("vo") HotelVo hotelVo, Model model, HttpSession httpSession) { 
		
		// 세션에서 sessSeqUsr 값 가져오기
	    String sessSeqUsr = (String) httpSession.getAttribute("sessSeqUsr"); // 사용자 seq
	    
	    // hotelVo에 htmseq를 set
	    hotelVo.setHtmSeq(sessSeqUsr);
	    
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
	
	// 예약 내역 상세 페이지
	@RequestMapping(value="/v1/infra/usrmember/usrHotelBookingHistoryDetails")
	public String usrHotelBookingHistoryDetails(HotelDto hotelDto, Model model) {	
		
		model.addAttribute("bookingHistoryDetailsList", hotelService.bookingHistoryDetailsSelectList(hotelDto));
		return "usr/v1/infra/usrmember/usrHotelBookingHistoryDetails";
	}
	  
	
   

		  

}
