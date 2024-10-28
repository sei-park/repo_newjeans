package com.ador.infra.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {            
	
	@Autowired
	private JavaMailSender javaMailSender;   
	  
	   public void sendMailSimple() {
		    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		    simpleMailMessage.setTo("tpdlqkr@naver.com"); // 받는 사람
		    simpleMailMessage.setSubject("안녕하세요"); // 제목
//		         simpleMailMessage.setFrom("wjsgusfhr324@gmail.com"); // 보내는 사람은 수정 불가
		    simpleMailMessage.setText("안녕하세요\n\n 잘지내고 계시죠"); // 내용

		    javaMailSender.send(simpleMailMessage); // 메일 전송(send 함수로 내용 캡슐화)

		}

	
	
	

	
	
	
	
	
	

}
