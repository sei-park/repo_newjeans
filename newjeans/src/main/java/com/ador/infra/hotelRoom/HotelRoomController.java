package com.ador.infra.hotelRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ador.infra.hotel.HotelDto;

@Controller
public class HotelRoomController {
	
	@Autowired
	HotelRoomService hotelRoomService;
	
	// selectList
	@RequestMapping(value="/xdm/v1/infra/hotelRoom/hotelRoomList")
	public String hotelRoomList(@ModelAttribute("vo") HotelRoomVo hotelRoomVo, Model model) { 
		
		hotelRoomVo.setParamsPaging(hotelRoomService.selectOneCount(hotelRoomVo));
		
		if(hotelRoomVo.getTotalRows() > 0) {
			model.addAttribute("hotelRoomList", hotelRoomService.selectRoomList(hotelRoomVo));
		}
		
		return "/xdm/v1/infra/hotelRoom/hotelRoomList";
	}
	
	@RequestMapping(value="/xdm/v1/infra/hotelRoom/hotelRoomForm")
	public String hotelRoomForm() {
		
		return "/xdm/v1/infra/hotelRoom/hotelRoomForm";
	}
	
	// insert
	@RequestMapping(value="/xdm/v1/infra/hotelRoom/hotelRoomInst")
	public String hotelRoomInst(HotelRoomDto hotelRoomDto) {
		
		hotelRoomService.selectRoomInsert(hotelRoomDto);
		
		return "redirect:/xdm/v1/infra/hotelRoom/hotelRoomList";
	}
	
	// selectOne
	@RequestMapping(value="/xdm/v1/infra/hotelRoom/hotelRoomMForm")
	public String hotelRoomMForm(HotelRoomDto hotelRoomDto, Model model) {
		
		model.addAttribute("hotelRoomItem", hotelRoomService.selectRoomSelectOne(hotelRoomDto));
		return "/xdm/v1/infra/hotelRoom/hotelRoomMForm";
	}
	
	// update
	@RequestMapping(value="/xdm/v1/infra/hotelRoom/hotelRoomUpdt") 
	public String hotelRoomUpdt(HotelRoomDto hotelRoomDto) {
		
		hotelRoomService.selectRoomUpdate(hotelRoomDto);
		return "redirect:/xdm/v1/infra/hotelRoom/hotelRoomList";
	}
	
	// 호텔 상세페이지 hotelRoomDetails
//	@RequestMapping(value="/v1/infra/usrmember/hotelRoomDetails")
//	public String usrHotelDetails(HotelRoomDto hotelRoomDto, Model model) { 
//		
//		model.addAttribute("hotelRoomItem", hotelRoomService.selectRoomSelectOne(hotelRoomDto));
//		return "/usr/v1/infra/usrmember/hotelRoomDetails";   
//	}

	 
 
	

}  
