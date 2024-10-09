package com.ador.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ador.common.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer {  
	
	// WebMvcConfigurer : 스프링 프레임워크에서 제공하는 인터페이스
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {  
		registry.addInterceptor(new CheckLoginSessionInterceptor()) // 인터셉터 연결 
//				.order(1) 인터셉트의 호출 순서를 지정. 낮을 수록 먼저 호출  
				.addPathPatterns("/xdm/v1/infra/**") // 인터셉터를 적용할 패턴 지정   
				.excludePathPatterns( // 인터셉터에서 제외할 패턴 지정(예외 처리)  
   					    "/resources/**", 
//						"/xdm/v1/**", // resources 하위 폴더
						"/xdm/v1/infra/hotelmember/signin", // 로그인 페이지 제외 
						"/xdm/v1/infra/hotelmember/signinXdmProc" // 로그인 처리 페이지 제외
				);       
	}   
	      
}



