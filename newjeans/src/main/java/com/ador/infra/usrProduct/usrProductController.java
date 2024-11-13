package com.ador.infra.usrProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ador.infra.hotel.HotelDto;
import com.ador.infra.hotel.HotelService;
import com.ador.infra.hotel.HotelVo;
import com.ador.infra.hotelreview.HotelReviewDto;
import com.ador.infra.hotelreview.HotelReviewService;

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
		
		// 별점으로 검색하기 
		if(hotelVo.getStarsArr() != null) {
			if(hotelVo.getStarsArr().length > 0) {
				for(int i = 0; i < hotelVo.getStarsArr().length; i++) { 
					System.out.println("별점 체크 : " + hotelVo.getStarsArr()[i]);
				}
			}
		}
		
		
		return "/usr/v1/infra/usrmember/usrHotelList"; 
	}   
	 
	// 호텔 상세페이지 
	@RequestMapping(value="/v1/infra/usrmember/usrHotelDetails")
	public String usrHotelDetails(@ModelAttribute("vo") HotelDto hotelDto, HotelReviewDto hotelReviewDto, Model model) {
		
		model.addAttribute("hotelRoomItem", hotelService.hotelSelectOne(hotelDto)); // selectOne
		model.addAttribute("hotelDetailList", hotelService.hotelDetailList(hotelDto)); // 호텔 상세 list
		model.addAttribute("hotelReviewList", hotelReviewService.hotelReviewList(hotelReviewDto)); // 호텔 리뷰 list
		return "/usr/v1/infra/usrmember/usrHotelDetails"; 
	}
	                            
	// insert
	@RequestMapping(value="/v1/infra/usrmember/usrHotelDetailsInst")
	public String usrHotelDetailsInst(HotelReviewDto hotelReviewDto) {

		hotelReviewService.hotelReviewInsert(hotelReviewDto);
		return "redirect:/usr/v1/infra/usrmember/usrHotelDetails";
	}
	    
	
	         
	
	
	 
	 
	     
	                       
	    

	    
		  

}
