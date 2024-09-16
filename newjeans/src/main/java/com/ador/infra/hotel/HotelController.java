package com.ador.infra.hotel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelController {
	
	@RequestMapping(value="/xdm/v1/infra/hotel/hotelXdmList")
	public String hotelXdmList() {
		
		return "/xdm/v1/infra/hotel/hotelXdmList";
	}

}
