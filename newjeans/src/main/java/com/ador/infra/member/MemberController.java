package com.ador.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	 
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/xdm/v1/infra/members/member")
	public String member(Model model) {
		
		List<MemberDto> members = memberService.memberList();
		model.addAttribute("memberlist", members);
		
//		for(MemberDto dto : members) {
//			System.out.println(dto.getSeq() + " | " + dto.getAdminNy() + " | " + dto.getName() 
//			+ " | " + dto.getId() + " | " + dto.getPassword() + " | " + dto.getGender() + " | "
//			+ dto.getBirth() + " | " + dto.getEmail() + " | " + dto.getNumber() + " | " 
//			+ dto.getDesc() + " | " + dto.getRegisterDate() + " | " + dto.getReviseDate());
//			
//		}
		
		return "/xdm/v1/infra/members/member";
	}

}
