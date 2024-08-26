package com.ador.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {
	
	
	// CodeGroupService codeGroupService = new CodeGroupService
	@Autowired
	CodeGroupService service;
	   
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList() {
		
		// service에 있는 함수를 호출 
		service.selectList();
		return "/xdm/v1/infra/codegroup/codeGroupXdmList";
	}

} 
  