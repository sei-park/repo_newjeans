package com.ador.infra.restaurant;

import java.util.Date;

public class RestaurantDto {
	
	private String seq;
	private String brand;
	private String restaurantName;
	private Date businessHoursStart;
	private Date businessHoursEnd;
	private String tel;
	private String internetAddress;
	private Integer parkingNy;
	private Integer bookNy;
	private Integer corkageNy;
	private String about;
	private Date regDate;
	private Date revDate;
	//-----
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Date getBusinessHoursStart() {
		return businessHoursStart;
	}
	public void setBusinessHoursStart(Date businessHoursStart) {
		this.businessHoursStart = businessHoursStart;
	}
	public Date getBusinessHoursEnd() {
		return businessHoursEnd;
	}
	public void setBusinessHoursEnd(Date businessHoursEnd) {
		this.businessHoursEnd = businessHoursEnd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getInternetAddress() {
		return internetAddress;
	}
	public void setInternetAddress(String internetAddress) {
		this.internetAddress = internetAddress;
	}
	public Integer getParkingNy() {
		return parkingNy;
	}
	public void setParkingNy(Integer parkingNy) {
		this.parkingNy = parkingNy;
	}
	public Integer getBookNy() {
		return bookNy;
	}
	public void setBookNy(Integer bookNy) {
		this.bookNy = bookNy;
	}
	public Integer getCorkageNy() {
		return corkageNy;
	}
	public void setCorkageNy(Integer corkageNy) {
		this.corkageNy = corkageNy;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getRevDate() {
		return revDate;
	}
	public void setRevDate(Date revDate) {
		this.revDate = revDate;
	}
	
	
	
	
    
}
