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
	public String hotelXdmList(HotelVo hotelVo, Model model) {
		
		// getshDateStart()에 "00:00:00"을 넣고 setShDateStart에서 보여줌 
		hotelVo.setShDateStart(hotelVo.getShDateStart() + " 00:00:00"); 
		hotelVo.setShDateEnd(hotelVo.getShDateEnd() + " 23:59:59");
		
		model.addAttribute("hotelList", hotelService.hotelList(hotelVo));
		return "/xdm/v1/infra/hotel/hotelXdmList";  
	}
	
	@RequestMapping(value="/xdm/v1/infra/hotel/hotelXdmForm")
	public String hotelXdmForm() {
		return "/xdm/v1/infra/hotel/hotelXdmForm";
	}
	
	// insert 
	@RequestMapping(value="/xdm/v1/infra/hotel/hotelXdmInst")
	public String hotelXdmInst(HotelDto hotelDto) {
		
		hotelService.hotelInsert(hotelDto);
		return "redirect:/xdm/v1/infra/hotel/hotelXdmList";
	}
	
	// selectOne
	@RequestMapping(value="/xdm/v1/infra/hotel/hotelXdmMForm")
	public String hotelXdmMForm(HotelDto hotelDto, Model model) {
		
		model.addAttribute("hotelItem", hotelService.hotelSelectOne(hotelDto));
		return "/xdm/v1/infra/hotel/hotelXdmMForm";
	}
	
	// update
	@RequestMapping(value="/xdm/v1/infra/hotel/hotelXdmUpdt")
	public String hotelXdmUpdt(HotelDto hotelDto) {
		
		hotelService.hotelUpdate(hotelDto);
		return "redirect:/xdm/v1/infra/hotel/hotelXdmList";
	}
	
	// update delete
	@RequestMapping(value="/xdm/v1/infra/hotel/hotelXdmUdel")
	public String hotelXdmUdel(HotelDto hotelDto) {
		
		hotelService.uelete(hotelDto);
		return "redirect:/xdm/v1/infra/hotel/hotelXdmList";
	}
	
	// delete
	@RequestMapping(value="/xdm/v1/infra/hotel/hotelXdmDel")
	public String hotelXdmDel(HotelDto hotelDto) {
		
		hotelService.delete(hotelDto);
		return "redirect:/xdm/v1/infra/hotel/hotelXdmList";
	}
	
	
	
	
	
}
