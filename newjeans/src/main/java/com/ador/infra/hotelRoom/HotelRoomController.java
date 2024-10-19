package com.ador.infra.hotelRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelRoomController {
	
	@Autowired
	HotelRoomService hotelRoomService;
	
	@RequestMapping(value="/xdm/v1/infra/hotelRoom/hotelRoomList")
	public String hotelRoomList() {
		return "/xdm/v1/infra/hotelRoom/hotelRoomList";
	}
	
 
	

}  
