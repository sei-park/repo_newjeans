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
	
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmList")
	public String codeXdmList(Model model) { 
		
		List<CodeDto> codes = codeService.codeSelectList();
		model.addAttribute("codelist", codes);
		
		return "/xdm/v1/infra/code/codeXdmList";
	}

}
