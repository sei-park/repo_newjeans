package com.ador.infra.usrProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ador.infra.hotel.HotelDto;
import com.ador.infra.hotel.HotelService;
import com.ador.infra.hotel.HotelVo;

@Controller
public class usrProductController {     
	
	@Autowired
	HotelService hotelService;
	
	// 호텔 리스트
	@RequestMapping(value="/v1/infra/usrmember/usrHotelList")  
	public String usrHotelList(@ModelAttribute("vo") HotelVo hotelVo, Model model) {
		
		hotelVo.setParamsPaging(hotelService.selectOneCount(hotelVo));
		
		if(hotelVo.getTotalRows() > 0) {
			model.addAttribute("hotelList", hotelService.hotelList(hotelVo));
		}
		
		return "/usr/v1/infra/usrmember/usrHotelList"; 
	}   
	
	// 호텔 상세페이지 usrHotelDetails
	@RequestMapping(value="/v1/infra/usrmember/usrHotelDetails")
	public String usrHotelDetails(HotelDto hotelDto, Model model) {
		
		model.addAttribute("hotelRoomItem", hotelService.hotelSelectOne(hotelDto));
		return "/usr/v1/infra/usrmember/usrHotelDetails"; 
	}
	
	
	     
	                       
	    

	  
		  

}
