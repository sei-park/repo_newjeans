package com.ador.infra.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ador.infra.codegroup.CodeGroupService;

@Controller
public class CodeController {
	
	@Autowired
	CodeGroupService service;
	
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmform")
	public String codeXdmList() {
		return "/xdm/v1/infra/codegroup/codeGroupXdmform";
	}
 
}
