package com.ador.infra.usrMember;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class usrMemberController {
	
    // signup 
	@RequestMapping(value="/v1/infra/usrmember/usrSignup")
	public String usrSignup() {
		return "/usr/v1/infra/usrmember/usrSignup";
	}
	
	

}
 