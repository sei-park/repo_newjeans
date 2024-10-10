package com.ador.infra.usrProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ador.infra.hotel.HotelDto;
import com.ador.infra.hotel.HotelService;
import com.ador.infra.hotel.HotelVo;

@Controller
public class usrProductController {
	
	@Autowired
	HotelService hotelService;
	
	@RequestMapping(value="/v1/infra/usrmember/usrHotelList")  
	public String usrHotelList(HotelDto hotelDto, Model model) {
		
		model.addAttribute("hotelItem", hotelService.hotelSelectOne(hotelDto));
		return "/usr/v1/infra/usrmember/usrHotelList"; 
	}    
	

	
		  

}
