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
    
	// selectList
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmList")
	public String hotelMemberXdmList(Model model) {
		
		model.addAttribute("memberList", hotelMemberService.memberSelectList());
		return "/xdm/v1/infra/hotelmember/hotelMemberXdmList";
	}
	
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmForm")
	public String hotelMemberXdmForm() {
		return "/xdm/v1/infra/hotelmember/hotelMemberXdmForm";
	}
	
	// insert
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmInst")
	public String hotelMemberXdmInst(HotelMemberDto hotelMemberDto) {
		
		hotelMemberService.memberInsert(hotelMemberDto);
		return "redirect:/xdm/v1/infra/hotelmember/hotelMemberXdmList";
	} 
	
	// selectOne 
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmMForm")
	public String codeGroupXdmMForm(HotelMemberDto hotelMemberDto, Model model) {
		
		model.addAttribute("memberItem", hotelMemberService.memberSelectOne(hotelMemberDto));
		return "/xdm/v1/infra/hotelmember/hotelMemberXdmMForm";
	}
	
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmUpdt")
	public String hotelMemberXdmUpdt(HotelMemberDto hotelMemberDto) {
		
		hotelMemberService.memberUpdate(hotelMemberDto);
		return "/xdm/v1/infra/hotelmember/hotelMemberXdmMForm";
	}
	
	
	
	
}
  