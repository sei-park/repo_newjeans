package com.ador.infra.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	// selectList
	@RequestMapping(value="/xdm/v1/infra/hotel/hotelXdmList")
	public String hotelXdmList(Model model) {
		
		model.addAttribute("hotelList", hotelService.hotelList());
		return "/xdm/v1/infra/hotel/hotelXdmList";  
	}
	
	// insert 
	@RequestMapping(value="/xdm/v1/infra/hotel/hotelXdmForm")
	public String hotelXdmForm() {
		return "/xdm/v1/infra/hotel/hotelXdmForm";
	}
	
	@RequestMapping(value="/xdm/v1/infra/hotel/hotelXdmInst")
	public String hotelXdmInst(HotelDto hotelDto) {
		
		hotelService.hotelInsert(hotelDto);
		return "redirect:/xdm/v1/infra/hotel/hotelXdmList";
	}
}
