package com.ador.infra.hotel;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HotelDto {
	
	private String htseq;
	private String htName;
	private String htAddress;
	private Integer htcountry;
	private String htDesc;
	private Integer htDelNy;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date htRegDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date htReviseDate;
	//--
	public String getHtseq() {
		return htseq;
	}
	public void setHtseq(String htseq) {
		this.htseq = htseq;
	}
	public String getHtName() {
		return htName;
	}
	public void setHtName(String htName) {
		this.htName = htName;
	}
	public String getHtAddress() {
		return htAddress;
	}
	public void setHtAddress(String htAddress) {
		this.htAddress = htAddress;
	}
	public Integer getHtcountry() {
		return htcountry;
	}
	public void setHtcountry(Integer htcountry) {
		this.htcountry = htcountry;
	}
	public String getHtDesc() {
		return htDesc;
	}
	public void setHtDesc(String htDesc) {
		this.htDesc = htDesc;
	}
	public Integer getHtDelNy() {
		return htDelNy;
	}
	public void setHtDelNy(Integer htDelNy) {
		this.htDelNy = htDelNy;
	}
	public Date getHtRegDate() {
		return htRegDate;
	}
	public void setHtRegDate(Date htRegDate) {
		this.htRegDate = htRegDate;
	}
	public Date getHtReviseDate() {
		return htReviseDate;
	}
	public void setHtReviseDate(Date htReviseDate) {
		this.htReviseDate = htReviseDate;
	}
	
	
	
	
	


}
