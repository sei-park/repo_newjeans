package com.ador.infra.hotelmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelMemberController {
	
	@Autowired
	HotelMemberService hotelMemberService;
		
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmList")
	public String hotelMemberXdmList(Model model) {
		
		model.addAttribute("memberList", hotelMemberService.memberSelectList());
		return "/xdm/v1/infra/hotelmember/hotelMemberXdmList";
	}
	
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmForm")
	public String hotelMemberXdmForm() {
		return "/xdm/v1/infra/hotelmember/hotelMemberXdmForm";
	}

}
  