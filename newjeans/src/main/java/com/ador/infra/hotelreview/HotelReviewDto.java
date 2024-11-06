package com.ador.infra.hotelreview;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HotelReviewDto {
	
	private String htreseq;
	private Integer htrestars; 
	private String htrecomments;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date htreRegDate;
	private String hotel_seq;
	private String hotelmember_htmSeq;
	private String htmSeq;
	private String htmId; 
	private String htmEmail;
	private String htseq;
	private String htName;
	//--     
	public String getHtreseq() {
		return htreseq;
	}
	public void setHtreseq(String htreseq) {
		this.htreseq = htreseq;
	}
	public Integer getHtrestars() {
		return htrestars;
	}
	public void setHtrestars(Integer htrestars) {
		this.htrestars = htrestars;
	}
	public String getHtrecomments() {
		return htrecomments;
	}
	public void setHtrecomments(String htrecomments) {
		this.htrecomments = htrecomments;
	}
	public Date getHtreRegDate() {
		return htreRegDate;
	}
	public void setHtreRegDate(Date htreRegDate) {
		this.htreRegDate = htreRegDate;
	}
	public String getHotel_seq() {
		return hotel_seq;
	}
	public void setHotel_seq(String hotel_seq) {
		this.hotel_seq = hotel_seq;
	}
	public String getHotelmember_htmSeq() {
		return hotelmember_htmSeq;
	}
	public void setHotelmember_htmSeq(String hotelmember_htmSeq) {
		this.hotelmember_htmSeq = hotelmember_htmSeq;
	}
	public String getHtmSeq() {
		return htmSeq;
	}
	public void setHtmSeq(String htmSeq) {
		this.htmSeq = htmSeq;
	}
	public String getHtmId() {
		return htmId;
	}
	public void setHtmId(String htmId) {
		this.htmId = htmId;
	}
	public String getHtmEmail() {
		return htmEmail;
	}
	public void setHtmEmail(String htmEmail) {
		this.htmEmail = htmEmail;
	}
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
    
	
	
	

}
