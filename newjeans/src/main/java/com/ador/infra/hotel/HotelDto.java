package com.ador.infra.hotel;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

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
	private Integer htrRoomPrice;
	private String htrStay;
	private String bedoption;
	private Integer aircondNy;
	private Integer bathNy;
	private Integer tvNy;
	private Integer wifiNy;
	private Integer coffeeNy;
	private String hotel_seq;
	
	// S3 
	private MultipartFile uploadFile;
	private MultipartFile[] uploadFiles;
	private Integer htuseq;
	private Integer htutype;
	private Integer htudefaultNy;
	private Integer htusort;
	private String htupath;
	private String htuoriginalName;
	private String htuuuidName;
	private String htuext;
	private long htusize;
	private Integer htudelNy;
	private Integer htupseq;
	private String hturegIp;
	private Integer hturegSeq;
	private Integer hturegDeviceCd;
	private Date hturegDateTime;
	private Date hturegDateTimeSvr;
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
	public Integer getHtrRoomPrice() {
		return htrRoomPrice;
	}
	public void setHtrRoomPrice(Integer htrRoomPrice) {
		this.htrRoomPrice = htrRoomPrice;
	}
	public String getHtrStay() {
		return htrStay;
	}
	public void setHtrStay(String htrStay) {
		this.htrStay = htrStay;
	}
	public String getBedoption() {
		return bedoption;
	}
	public void setBedoption(String bedoption) {
		this.bedoption = bedoption;
	}
	public Integer getAircondNy() {
		return aircondNy;
	}
	public void setAircondNy(Integer aircondNy) {
		this.aircondNy = aircondNy;
	}
	public Integer getBathNy() {
		return bathNy;
	}
	public void setBathNy(Integer bathNy) {
		this.bathNy = bathNy;
	}
	public Integer getTvNy() {
		return tvNy;
	}
	public void setTvNy(Integer tvNy) {
		this.tvNy = tvNy;
	}
	public Integer getWifiNy() {
		return wifiNy;
	}
	public void setWifiNy(Integer wifiNy) {
		this.wifiNy = wifiNy;
	}
	public Integer getCoffeeNy() {
		return coffeeNy;
	}
	public void setCoffeeNy(Integer coffeeNy) {
		this.coffeeNy = coffeeNy;
	}
	public String getHotel_seq() {
		return hotel_seq;
	}
	public void setHotel_seq(String hotel_seq) {
		this.hotel_seq = hotel_seq;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	public Integer getHtuseq() {
		return htuseq;
	}
	public void setHtuseq(Integer htuseq) {
		this.htuseq = htuseq;
	}
	public Integer getHtutype() {
		return htutype;
	}
	public void setHtutype(Integer htutype) {
		this.htutype = htutype;
	}
	public Integer getHtudefaultNy() {
		return htudefaultNy;
	}
	public void setHtudefaultNy(Integer htudefaultNy) {
		this.htudefaultNy = htudefaultNy;
	}
	public Integer getHtusort() {
		return htusort;
	}
	public void setHtusort(Integer htusort) {
		this.htusort = htusort;
	}
	public String getHtupath() {
		return htupath;
	}
	public void setHtupath(String htupath) {
		this.htupath = htupath;
	}
	public String getHtuoriginalName() {
		return htuoriginalName;
	}
	public void setHtuoriginalName(String htuoriginalName) {
		this.htuoriginalName = htuoriginalName;
	}
	public String getHtuuuidName() {
		return htuuuidName;
	}
	public void setHtuuuidName(String htuuuidName) {
		this.htuuuidName = htuuuidName;
	}
	public String getHtuext() {
		return htuext;
	}
	public void setHtuext(String htuext) {
		this.htuext = htuext;
	}
	public long getHtusize() {
		return htusize;
	}
	public void setHtusize(long htusize) {
		this.htusize = htusize;
	}
	public Integer getHtudelNy() {
		return htudelNy;
	}
	public void setHtudelNy(Integer htudelNy) {
		this.htudelNy = htudelNy;
	}
	public Integer getHtupseq() {
		return htupseq;
	}
	public void setHtupseq(Integer htupseq) {
		this.htupseq = htupseq;
	}
	public String getHturegIp() {
		return hturegIp;
	}
	public void setHturegIp(String hturegIp) {
		this.hturegIp = hturegIp;
	}
	public Integer getHturegSeq() {
		return hturegSeq;
	}
	public void setHturegSeq(Integer hturegSeq) {
		this.hturegSeq = hturegSeq;
	}
	public Integer getHturegDeviceCd() {
		return hturegDeviceCd;
	}
	public void setHturegDeviceCd(Integer hturegDeviceCd) {
		this.hturegDeviceCd = hturegDeviceCd;
	}
	public Date getHturegDateTime() {
		return hturegDateTime;
	}
	public void setHturegDateTime(Date hturegDateTime) {
		this.hturegDateTime = hturegDateTime;
	}
	public Date getHturegDateTimeSvr() {
		return hturegDateTimeSvr;
	}
	public void setHturegDateTimeSvr(Date hturegDateTimeSvr) {
		this.hturegDateTimeSvr = hturegDateTimeSvr;
	}
	
	
	
	
	
	

	
    
	


}
