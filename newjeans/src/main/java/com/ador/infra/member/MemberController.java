package com.ador.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ador.infra.codegroup.CodeGroupDto;

@Controller
public class MemberController {
	 
	@Autowired
	MemberService memberService;
	
	// 리스트
	@RequestMapping(value="/xdm/v1/infra/members/membersList")
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
		
		return "/xdm/v1/infra/members/membersList";
	}
	
	// 폼  
	@RequestMapping(value="/xdm/v1/infra/members/membersForm")
	public String codeGroupXdmForm() {	
		
		return "/xdm/v1/infra/members/membersForm";
	}
	
	@RequestMapping(value="/xdm/v1/infra/members/membersXdmInst")
	public String membersXdmInst(MemberDto memberDto) {
		
		System.out.println(memberDto.getName());
		
		memberService.membersInsert(memberDto);
			
		return "redirect:/xdm/v1/infra/members/membersList";
	}
	
	// -------------------------------------------------------
	// M폼
	@RequestMapping(value="/xdm/v1/infra/members/membersMForm")
	public String membersMForm() {
		return "/xdm/v1/infra/members/membersMForm";
	}


}
