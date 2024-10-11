package com.ador.infra.usrMember;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ador.common.constants.Constants;
import com.ador.infra.hotelmember.HotelMemberDto;
import com.ador.infra.hotelmember.HotelMemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class usrMemberController { 
	
	@Autowired
	HotelMemberService hotelMemberService;
	
	// index(사용자 메인페이지)  
	@RequestMapping(value="/v1/infra/usrmember/usrIndex")
	public String usrIndex() {
		return "/usr/v1/infra/usrmember/usrIndex";
	}
	
    // signup 
	@RequestMapping(value="/v1/infra/usrmember/usrSignup")
	public String usrSignup() {
		return "/usr/v1/infra/usrmember/usrSignup";
	}
	
	// signin 
	@RequestMapping(value="/v1/infra/usrmember/usrSignin")
	public String usrSignin() {
		return "/usr/v1/infra/usrmember/usrSignin";
	} 
	
	// 로그인 처리 
	@ResponseBody 
	@RequestMapping(value="/v1/infra/usrmember/usrSigninProc") // 로그인 처리 페이지 
	public Map<String, Object> usrSigninProc(HotelMemberDto hotelMemberDto, HttpSession httpSession) {
		Map<String, Object> returnMap = new HashMap<String, Object>(); // 결과를 담기 위한 맵 생성 
		
		HotelMemberDto rtMember = hotelMemberService.selectOneLogin(hotelMemberDto); // 로그인 정보를 가져옴 
		 	
		if(rtMember != null) { // 로그인 정보가 있을 때 
			HotelMemberDto rtMemberSession = hotelMemberService.selectOneLogin(hotelMemberDto); // 세션을 생성
			if(rtMemberSession != null) { // 세션 정보가 있을 때 
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqUsr", rtMemberSession.getHtmSeq()); // seq 정보를 가져옴 
				httpSession.setAttribute("sessIdUsr", rtMemberSession.getHtmId()); // 아이디 정보를 가져옴
				httpSession.setAttribute("sessNameUsr", rtMemberSession.getHtmUserName()); // 이름 정보를 가져옴
				httpSession.setAttribute("sessEmailUsr", rtMemberSession.getHtmEmail()); // 이메일 정보를 가져옴 
				
				returnMap.put("rt", "success"); // 로그인 성공   
				
				// console
				System.out.println("sessSeqUsr: " + httpSession.getAttribute("sessSeqUsr"));
				System.out.println("sessIdUsr: " + httpSession.getAttribute("sessIdUsr"));
				System.out.println("sessNameUsr: " + httpSession.getAttribute("sessNameUsr"));
				System.out.println("sessEmailUsr: " + httpSession.getAttribute("sessEmailUsr"));
			}
		} else {
			returnMap.put("rt", "fail"); // 로그인 실패 
		}
		return returnMap;   
 	} 
	
	// logout
	@ResponseBody         
	@RequestMapping(value="/v1/infra/usrmember/usrSignoutProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//httpSession.invalidate(); // 세션 전체 삭제  
		httpSession.setAttribute("sessSeqUsr", null);
		returnMap.put("rt", "success");
		return returnMap;    
	}
	
	
	               
	

}  
 