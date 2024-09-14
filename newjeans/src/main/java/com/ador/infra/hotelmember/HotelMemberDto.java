package com.ador.infra.hotelmember;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HotelMemberDto {
	
	private String htmSeq;
	private String htmUserName;
	private Integer htmGender;
	private String htmBirth;
	private String htmId;
	private String htmPassword;
	private String htmPhoneNumber;
	private String htmEmail;
	private String htmAddress;
	private String htmDetailedAddress;
	private String htmZipCode;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date htmRegDate;
	private Integer htmGrade;
	private Integer htmRegAgreeContentNy;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date htmEditMemberDate;
	private Integer htmDelNy;
    //--
	public String getHtmSeq() {
		return htmSeq;
	}
	public void setHtmSeq(String htmSeq) {
		this.htmSeq = htmSeq;
	}
	public String getHtmUserName() {
		return htmUserName;
	}
	public void setHtmUserName(String htmUserName) {
		this.htmUserName = htmUserName;
	}
	public Integer getHtmGender() {
		return htmGender;
	}
	public void setHtmGender(Integer htmGender) {
		this.htmGender = htmGender;
	}
	public String getHtmBirth() {
		return htmBirth;
	}
	public void setHtmBirth(String htmBirth) {
		this.htmBirth = htmBirth;
	}
	public String getHtmId() {
		return htmId;
	}
	public void setHtmId(String htmId) {
		this.htmId = htmId;
	}
	public String getHtmPassword() {
		return htmPassword;
	}
	public void setHtmPassword(String htmPassword) {
		this.htmPassword = htmPassword;
	}
	public String getHtmPhoneNumber() {
		return htmPhoneNumber;
	}
	public void setHtmPhoneNumber(String htmPhoneNumber) {
		this.htmPhoneNumber = htmPhoneNumber;
	}
	public String getHtmEmail() {
		return htmEmail;
	}
	public void setHtmEmail(String htmEmail) {
		this.htmEmail = htmEmail;
	}
	public String getHtmAddress() {
		return htmAddress;
	}
	public void setHtmAddress(String htmAddress) {
		this.htmAddress = htmAddress;
	}
	public String getHtmDetailedAddress() {
		return htmDetailedAddress;
	}
	public void setHtmDetailedAddress(String htmDetailedAddress) {
		this.htmDetailedAddress = htmDetailedAddress;
	}
	public String getHtmZipCode() {
		return htmZipCode;
	}
	public void setHtmZipCode(String htmZipCode) {
		this.htmZipCode = htmZipCode;
	}
	public Date getHtmRegDate() {
		return htmRegDate;
	}
	public void setHtmRegDate(Date htmRegDate) {
		this.htmRegDate = htmRegDate;
	}
	public Integer getHtmGrade() {
		return htmGrade;
	}
	public void setHtmGrade(Integer htmGrade) {
		this.htmGrade = htmGrade;
	}
	public Integer getHtmRegAgreeContentNy() {
		return htmRegAgreeContentNy;
	}
	public void setHtmRegAgreeContentNy(Integer htmRegAgreeContentNy) {
		this.htmRegAgreeContentNy = htmRegAgreeContentNy;
	}
	public Date getHtmEditMemberDate() {
		return htmEditMemberDate;
	}
	public void setHtmEditMemberDate(Date htmEditMemberDate) {
		this.htmEditMemberDate = htmEditMemberDate;
	}
	public Integer getHtmDelNy() {
		return htmDelNy;
	}
	public void setHtmDelNy(Integer htmDelNy) {
		this.htmDelNy = htmDelNy;
	}
	
	
	
	
	
}
