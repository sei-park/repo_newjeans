package com.ador.infra.hotelmember;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ador.common.constants.Constants;
import com.ador.common.util.UtilDateTime;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;


@Controller
public class HotelMemberController {
	
	@Autowired
	HotelMemberService hotelMemberService;
    
	// selectList
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmList")
	public String hotelMemberXdmList(@ModelAttribute("vo") HotelMemberVo hotelMemberVo, Model model) {
		
		// getshDateStart()에 "00:00:00"을 넣고 setShDateStart에서 보여줌 
//		hotelMemberVo.setShDateStart(hotelMemberVo.getShDateStart() + " 00:00:00"); 
//		hotelMemberVo.setShDateEnd(hotelMemberVo.getShDateEnd() + " 23:59:59");
		
		/* 초기값 세팅이 없는 경우 사용 */
		// shDateStart 값이 null 이거나 비어 있을 경우 UtilDateTime 클래스를 실행 
		hotelMemberVo.setShDateStart(hotelMemberVo.getShDateStart() == null || hotelMemberVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(hotelMemberVo.getShDateStart()));
		// shDateEnd 값이 null 이거나 비어 있을 경우 UtilDateTime 클래스를 실행 
		hotelMemberVo.setShDateEnd(hotelMemberVo.getShDateEnd() == null || hotelMemberVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(hotelMemberVo.getShDateEnd()));
		
		hotelMemberVo.setParamsPaging(hotelMemberService.selectOneCount(hotelMemberVo));
		
		if(hotelMemberVo.getTotalRows() > 0) {
			model.addAttribute("memberList", hotelMemberService.memberSelectList(hotelMemberVo));
		}
				
		return "/xdm/v1/infra/hotelmember/hotelMemberXdmList";
	}
	
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmForm")
	public String hotelMemberXdmForm() {
		return "/xdm/v1/infra/hotelmember/hotelMemberXdmForm";
	}
	
	// insert
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmInst")
	public String hotelMemberXdmInst(HotelMemberDto hotelMemberDto) {
		
		hotelMemberService.memberInsert(hotelMemberDto);
		return "redirect:/xdm/v1/infra/hotelmember/hotelMemberXdmList";
	} 
	
	// selectOne 
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmMForm")
	public String codeGroupXdmMForm(HotelMemberDto hotelMemberDto, Model model) {
		
		model.addAttribute("memberItem", hotelMemberService.memberSelectOne(hotelMemberDto));
		return "/xdm/v1/infra/hotelmember/hotelMemberXdmMForm";
	}
	
	// update 
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmUpdt")
	public String hotelMemberXdmUpdt(HotelMemberDto hotelMemberDto) {
		
		hotelMemberService.memberUpdate(hotelMemberDto);
		return "redirect:/xdm/v1/infra/hotelmember/hotelMemberXdmList";
	}
	     
	// update delete
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmUedl")
	public String hotelMemberXdmUedl(HotelMemberDto hotelMemberDto) {
		
		hotelMemberService.uelete(hotelMemberDto);
		return "redirect:/xdm/v1/infra/hotelmember/hotelMemberXdmList";
	}
	
	// delete
	@RequestMapping(value="/xdm/v1/infra/hotelmember/hotelMemberXdmDel")
	public String hotelMemberXdmDel(HotelMemberDto hotelMemberDto) {
		
		hotelMemberService.delete(hotelMemberDto);
	    return "redirect:/xdm/v1/infra/hotelmember/hotelMemberXdmList";
	}
	
	// signin
	@RequestMapping(value="/xdm/v1/infra/hotelmember/signin")
	public String signin(HotelMemberDto hotelMemberDto) {
		
		hotelMemberService.selectOneLogin(hotelMemberDto);
		return "/xdm/v1/infra/hotelmember/signin";	 
	} 
	
	// login(로그인 처리)
	@ResponseBody // ajax 어노테이션
	@RequestMapping(value="/xdm/v1/infra/hotelmember/signinXdmProc") // 로그인 처리 페이지 
	public Map<String, Object> signinXdmProc(HotelMemberDto hotelMemberDto, HttpSession httpSession) {
		Map<String, Object> returnMap = new HashMap<String, Object>(); // 결과를 담기 위한 맵 생성 
		
		// 데이터가 있는지 확인하기 위해서는 객체 자체를 사용해야 함 
		// 객체가 비어 있다고 가정했을 때 rtMember.getHtmId() 사용 불가
		// 객체 내에 있는 함수를 사용하는 것이 아니라 객체 자체를 사용해야 함 
		HotelMemberDto rtMember = hotelMemberService.selectOneLogin(hotelMemberDto); // 로그인 정보를 가져옴 
		 	
		if(rtMember != null) { // 로그인 정보가 있을 때 
			HotelMemberDto rtMemberSession = hotelMemberService.selectOneLogin(hotelMemberDto); // 세션을 생성
			if(rtMemberSession != null) { // 세션 정보가 있을 때 
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqXdm", rtMemberSession.getHtmSeq()); // seq 정보를 가져옴 
				httpSession.setAttribute("sessIdXdm", rtMemberSession.getHtmId()); // 아이디 정보를 가져옴
				httpSession.setAttribute("sessNameXdm", rtMemberSession.getHtmUserName()); // 이름 정보를 가져옴 
				httpSession.setAttribute("sessEmailXdm", rtMemberSession.getHtmEmail()); // 이메일 정보를 가져옴
				httpSession.setAttribute("sessGradeXdm", rtMemberSession.getHtmGrade()); // 등급 정보를 가져옴
				 
				returnMap.put("rt", "success"); // 로그인 성공 
				  
				// console
				System.out.println("sessSeqXdm: " + httpSession.getAttribute("sessSeqXdm"));
				System.out.println("sessIdXdm: " + httpSession.getAttribute("sessIdXdm"));
				System.out.println("sessNameXdm: " + httpSession.getAttribute("sessNameXdm"));
				System.out.println("sessEmailXdm: " + httpSession.getAttribute("sessEmailXdm")); 
				
				System.out.println("세션 유효 시간 " + httpSession.getMaxInactiveInterval() + "초");
				
			}
		} else {
			returnMap.put("rt", "fail"); // 로그인 실패 
		}
		return returnMap;   
 	} 
	
	// mainpage 
	@RequestMapping(value="/xdm/v1/infra/hotelmember/mainPage")
	public String mainPage() {
		return "/xdm/v1/infra/hotelmember/mainPage";
	}        
     
	// logout
	@ResponseBody         
	@RequestMapping(value="/xdm/v1/infra/hotelmember/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//httpSession.invalidate(); //세션 전체 삭제
//		httpSession.setAttribute("sessSeqXdm", null);
//		httpSession.setAttribute("sessIdXdm", null);
//		httpSession.setAttribute("sessNameXdm", null);    
//		httpSession.setAttribute("sessEmailXdm", null);
		
		httpSession.removeAttribute("sessSeqXdm");
		httpSession.removeAttribute("sessIdXdm");
		httpSession.removeAttribute("sessNameXdm");
		httpSession.removeAttribute("sessEmailXdm");
		
		// 세션 쿠키 삭제
	    Cookie cookie = new Cookie("JSESSIONID", null); // 세션 쿠키 이름 JSESSIONID
	    cookie.setPath("/"); // 애플리케이션 전체에서 유효하도록 설정
	    cookie.setMaxAge(0); // 쿠키의 유효기간을 0으로 설정하여 삭제
	    
		returnMap.put("rt", "success");
		return returnMap; 
	}
	
	
	
	
	
     
 
	
	
}
  