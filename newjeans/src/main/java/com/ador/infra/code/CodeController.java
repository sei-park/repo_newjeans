package com.ador.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	
	// select
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmList") 
	public String codeXdmList(Model model) { 
		
		List<CodeDto> codes = codeService.codeSelectList();
		model.addAttribute("codelist", codes);
		
		return "/xdm/v1/infra/code/codeXdmList";
	}
	
	// codegroup - code 연결 
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmForm")
	public String codeXdmForm(Model model) {
		
		List<CodeDto> codeGroups = codeService.selectListCode();
		model.addAttribute("listCodeGroup", codeGroups);
		
		return "/xdm/v1/infra/code/codeXdmForm";
	}
	
	// insert 
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		
		codeService.codeInsert(codeDto);
		System.out.println(codeDto.getCodegroup_ifcgSeq());
		
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	} 
	
	// selectOne
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmMForm")
	public String codeXdmMForm(CodeDto codeDto, Model model) {
		
		List<CodeDto> codeGroups = codeService.selectListCode();
		model.addAttribute("listCodeGroup", codeGroups);  
		
		model.addAttribute("codeItem", codeService.codeSelectOne(codeDto));
		return "/xdm/v1/infra/code/codeXdmMForm";
	}
	
	// update
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmUpdt")
	public String codeXdmUpdt(CodeDto codeDto) {
		
		codeService.codeUpdate(codeDto);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
		
	}
	
	
	


}
