package com.ador.infra.kakaopay;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kakaopay")
public class KakaoPayProperties {
	
	private String adminKey; // Admin Key
	private String cid;
	//--
	public String getAdminKey() {
		return adminKey;
	}
	public void setAdminKey(String adminKey) {
		this.adminKey = adminKey;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	

}
