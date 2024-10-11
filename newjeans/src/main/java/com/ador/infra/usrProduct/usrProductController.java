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
	
	@RequestMapping(value="/v1/infra/usrmember/usrHotelList")  
	public String usrHotelList(@ModelAttribute("vo") HotelVo hotelVo, Model model) {
		
		hotelVo.setParamsPaging(hotelService.selectOneCount(hotelVo));
		
		if(hotelVo.getTotalRows() > 0) {
			model.addAttribute("hotelList", hotelService.hotelList(hotelVo));
		}
		
		return "/usr/v1/infra/usrmember/usrHotelList"; 
	}    
	    

	  
		  

}
