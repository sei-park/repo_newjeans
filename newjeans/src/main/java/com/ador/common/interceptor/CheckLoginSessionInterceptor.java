package com.ador.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ador.common.constants.Constants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 인터페이스를 구현하는 클래스 
// HandlerInterceptor : 특정한 URI 호출을 '가로채는' 역할, 이를 이용하여 기존 컨트롤러의 로직을 수정하지 않고도, 사전이나 사후 제어가 가능      
public class CheckLoginSessionInterceptor implements HandlerInterceptor {
	
	// 로그인 여부를 체크해서 로그인이 되었을 때만 페이지에 접근 허용   
	@Override
	// HandlerInterceptor에서 제공하는 매서드 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		
     System.out.println("로그인 확인, htmSeq : " + request.getSession().getAttribute("sessSeqXdm"));

		if (request.getSession().getAttribute("sessSeqXdm") != null) { // 로그인이 되어 있을 때 
			// by pass
		} else { // 그게 아니라면 
			response.sendRedirect(Constants.URL_LOGINFORM); // 로그인 페이지 경로로 이동      
	        return false; // 함수를 빠져나감
		}
		 
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	    

}
