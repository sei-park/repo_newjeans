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
	private String htNotice;
	private String htMap;
	private Integer htInclusionItems;
	private Integer htNameSearch;
	private Integer htPriceSearch;
	private Integer htStarSearch;
	private Integer htClassSearch;
	private Integer htRestaurantNy;
	private Integer htSpaNy;
	private Integer htFitnessCenterNy;
	private Integer htPoolNy;
	private Integer htloungeNy;
	private Integer htStockRoomNy;
	private Integer htParkingNy;
	private Integer htShuttleBusNy;
	private Integer htBreakfastNy;
	private Integer htRoomServiceNy;
	private Integer htElseNy;
	
	// 호텔 룸
	private String htrseq;
	private String htrRoomName;
	private String htrRoomCondition;
	private String htrRoomPrice;
	private String htrStay;
	private String hotel_seq;
	
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
	public String getHtNotice() {
		return htNotice;
	}
	public void setHtNotice(String htNotice) {
		this.htNotice = htNotice;
	}
	public String getHtMap() {
		return htMap;
	}
	public void setHtMap(String htMap) {
		this.htMap = htMap;
	}
	public Integer getHtInclusionItems() {
		return htInclusionItems;
	}
	public void setHtInclusionItems(Integer htInclusionItems) {
		this.htInclusionItems = htInclusionItems;
	}
	public Integer getHtNameSearch() {
		return htNameSearch;
	}
	public void setHtNameSearch(Integer htNameSearch) {
		this.htNameSearch = htNameSearch;
	}
	public Integer getHtPriceSearch() {
		return htPriceSearch;
	}
	public void setHtPriceSearch(Integer htPriceSearch) {
		this.htPriceSearch = htPriceSearch;
	}
	public Integer getHtStarSearch() {
		return htStarSearch;
	}
	public void setHtStarSearch(Integer htStarSearch) {
		this.htStarSearch = htStarSearch;
	}
	public Integer getHtClassSearch() {
		return htClassSearch;
	}
	public void setHtClassSearch(Integer htClassSearch) {
		this.htClassSearch = htClassSearch;
	}
	public Integer getHtRestaurantNy() {
		return htRestaurantNy;
	}
	public void setHtRestaurantNy(Integer htRestaurantNy) {
		this.htRestaurantNy = htRestaurantNy;
	}
	public Integer getHtSpaNy() {
		return htSpaNy;
	}
	public void setHtSpaNy(Integer htSpaNy) {
		this.htSpaNy = htSpaNy;
	}
	public Integer getHtFitnessCenterNy() {
		return htFitnessCenterNy;
	}
	public void setHtFitnessCenterNy(Integer htFitnessCenterNy) {
		this.htFitnessCenterNy = htFitnessCenterNy;
	}
	public Integer getHtPoolNy() {
		return htPoolNy;
	}
	public void setHtPoolNy(Integer htPoolNy) {
		this.htPoolNy = htPoolNy;
	}
	public Integer getHtloungeNy() {
		return htloungeNy;
	}
	public void setHtloungeNy(Integer htloungeNy) {
		this.htloungeNy = htloungeNy;
	}
	public Integer getHtStockRoomNy() {
		return htStockRoomNy;
	}
	public void setHtStockRoomNy(Integer htStockRoomNy) {
		this.htStockRoomNy = htStockRoomNy;
	}
	public Integer getHtParkingNy() {
		return htParkingNy;
	}
	public void setHtParkingNy(Integer htParkingNy) {
		this.htParkingNy = htParkingNy;
	}
	public Integer getHtShuttleBusNy() {
		return htShuttleBusNy;
	}
	public void setHtShuttleBusNy(Integer htShuttleBusNy) {
		this.htShuttleBusNy = htShuttleBusNy;
	}
	public Integer getHtBreakfastNy() {
		return htBreakfastNy;
	}
	public void setHtBreakfastNy(Integer htBreakfastNy) {
		this.htBreakfastNy = htBreakfastNy;
	}
	public Integer getHtRoomServiceNy() {
		return htRoomServiceNy;
	}
	public void setHtRoomServiceNy(Integer htRoomServiceNy) {
		this.htRoomServiceNy = htRoomServiceNy;
	}
	public Integer getHtElseNy() {
		return htElseNy;
	}
	public void setHtElseNy(Integer htElseNy) {
		this.htElseNy = htElseNy;
	}
	public String getHtrseq() {
		return htrseq;
	}
	public void setHtrseq(String htrseq) {
		this.htrseq = htrseq;
	}
	public String getHtrRoomName() {
		return htrRoomName;
	}
	public void setHtrRoomName(String htrRoomName) {
		this.htrRoomName = htrRoomName;
	}
	public String getHtrRoomCondition() {
		return htrRoomCondition;
	}
	public void setHtrRoomCondition(String htrRoomCondition) {
		this.htrRoomCondition = htrRoomCondition;
	}
	public String getHtrRoomPrice() {
		return htrRoomPrice;
	}
	public void setHtrRoomPrice(String htrRoomPrice) {
		this.htrRoomPrice = htrRoomPrice;
	}
	public String getHtrStay() {
		return htrStay;
	}
	public void setHtrStay(String htrStay) {
		this.htrStay = htrStay;
	}
	public String getHotel_seq() {
		return hotel_seq;
	}
	public void setHotel_seq(String hotel_seq) {
		this.hotel_seq = hotel_seq;
	}
	
	

	
	
	
	
	
	
	
	
	
	


}
