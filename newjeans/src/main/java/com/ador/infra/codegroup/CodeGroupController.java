package com.ador.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList() {
		
		List<CodeGroupDto> codegroups = codeGroupService.selectList();
		
		System.out.println(codegroups.size());
		
		return "/xdm/v1/infra/codegroup/codeGroupXdmList";
	}

}
