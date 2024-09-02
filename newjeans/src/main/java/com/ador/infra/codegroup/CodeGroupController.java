package com.ador.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
    // 리스트
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList(Model model) {
		
		// 스프링에서 만든는 클래스는 모두 선언 클래스
	    // Controller 에서 받은 객체를 html 에 넘기기 위해서는 Model 객체 사용해야 함 
		List<CodeGroupDto> codegroups = codeGroupService.selectList();
													
		model.addAttribute("list", codegroups); // list : html 에서 쓰일 변수명		
	   //model.addAttribute("list", codeGroupService.selectList());
		  
	   //System.out.println(codegroups.size()); 
		
		return "/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	
	// 폼  
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {		
		return "/xdm/v1/infra/codegroup/codeGroupXdmForm";
	}
	
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
		 
		System.out.println(codeGroupDto.getIfcgName());
		
		codeGroupService.insert(codeGroupDto); 
		
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	// ---------------------------------------------------------------
	
	// M폼  
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmMForm")
	public String codeGroupXdmMForm() {
		return "/xdm/v1/infra/codegroup/codeGroupXdmMForm";
	}

}
