package com.ador.infra.hotelRoom;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class HotelRoomDto {
	
	// hotelRoom
	private String htrseq;
	private String htrRoomName;
	private String htrRoomPrice;
	private String htrStay;
    private String bedoption;
    private Integer aircondNy;
    private Integer bathNy;
    private Integer tvNy;
    private Integer wifiNy;
    private Integer coffeeNy;
    private Integer htrDelNy;
    private String hotel_seq;
    
    // 호텔
    private String htseq;
    private String htName;
    
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
	private String htupseq;
	private String hturegIp;
	private String hturegSeq;
	private Integer hturegDeviceCd;
	private Date hturegDateTime;
	private Date hturegDateTimeSvr;
	

    //--
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
	public Integer getHtrDelNy() {
		return htrDelNy;
	}
	public void setHtrDelNy(Integer htrDelNy) {
		this.htrDelNy = htrDelNy;
	}
	public String getHotel_seq() {
		return hotel_seq;
	}
	public void setHotel_seq(String hotel_seq) {
		this.hotel_seq = hotel_seq;
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
	public String getHtupseq() {
		return htupseq;
	}
	public void setHtupseq(String htupseq) {
		this.htupseq = htupseq;
	}
	public String getHturegIp() {
		return hturegIp;
	}
	public void setHturegIp(String hturegIp) {
		this.hturegIp = hturegIp;
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
	public String getHturegSeq() {
		return hturegSeq;
	}
	public void setHturegSeq(String hturegSeq) {
		this.hturegSeq = hturegSeq;
	}

	
	
	
	
    
	

}
