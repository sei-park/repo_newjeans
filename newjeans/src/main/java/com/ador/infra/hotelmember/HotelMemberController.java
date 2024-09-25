package com.ador.infra.hotelmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelMemberController {
	
	@Autowired
	HotelMemberService hotelMemberService;
    
	// selectList
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmList")
	public String hotelMemberXdmList(@ModelAttribute("vo") HotelMemberVo hotelMemberVo, Model model) {
		
		// getshDateStart()에 "00:00:00"을 넣고 setShDateStart에서 보여줌 
		hotelMemberVo.setShDateStart(hotelMemberVo.getShDateStart() + " 00:00:00"); 
		hotelMemberVo.setShDateEnd(hotelMemberVo.getShDateEnd() + " 23:59:59");
		
		hotelMemberVo.setParamsPaging(hotelMemberService.selectOneCount(hotelMemberVo));
		
		if(hotelMemberVo.getTotalRows() > 0) {
			model.addAttribute("memberList", hotelMemberService.memberSelectList(hotelMemberVo));
		}
		
				
//		model.addAttribute("memberList", hotelMemberService.memberSelectList(hotelMemberVo));
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
	
	// update 
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmUpdt")
	public String hotelMemberXdmUpdt(HotelMemberDto hotelMemberDto) {
		
		hotelMemberService.memberUpdate(hotelMemberDto);
		return "redirect:/xdm/v1/infra/hotelmember/hotelMemberXdmList";
	}
	
	// update delete
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmUedl")
	public String hotelMemberXdmUedl(HotelMemberDto hotelMemberDto) {
		
		hotelMemberService.uelete(hotelMemberDto);
		return "redirect:/xdm/v1/infra/hotelmember/hotelMemberXdmList";
	}
	
	// delete
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmDel")
	public String hotelMemberXdmDel(HotelMemberDto hotelMemberDto) {
		
		hotelMemberService.delete(hotelMemberDto);
	    return "redirect:/xdm/v1/infra/hotelmember/hotelMemberXdmList";
	}
	
	
	
}
  