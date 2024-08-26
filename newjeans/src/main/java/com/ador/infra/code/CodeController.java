package com.ador.infra.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ador.infra.codegroup.CodeGroupService;

@Controller
public class CodeController {
	
	@Autowired
	CodeService service;
	
	@RequestMapping(value="/xdm/v1/infra/code/codeGroupXdmList")
	public String codeXdmList() {
		return "/xdm/v1/infra/codegroup/codeXdmList";
	}
 
}
