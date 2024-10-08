package com.ador.infra.codegroup;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CodeGroupDto {
	
	private String ifcgSeq;
	private String ifcgName;
	private Integer ifcgUseNy;
	private Integer ifcgOrder;
	private Integer ifcgDelNy;
	private String ifcgDesc;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date regDateTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date regDateTimeRevise;
	
	// count 데이터 추가(쿼리에서 만들어진 변수명 추가해줘야 함)
	// 쿼리에서 만들어진 변수명에는 변수명 앞에 x를 써주는게 편함 
	private Integer count;
	
	//-----
	public String getIfcgSeq() {
		return ifcgSeq;
	}
	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	public Integer getIfcgUseNy() {
		return ifcgUseNy;
	}
	public void setIfcgUseNy(Integer ifcgUseNy) {
		this.ifcgUseNy = ifcgUseNy;
	}
	public Integer getIfcgOrder() {
		return ifcgOrder;
	}
	public void setIfcgOrder(Integer ifcgOrder) {
		this.ifcgOrder = ifcgOrder;
	}
	public Integer getIfcgDelNy() {
		return ifcgDelNy;
	}
	public void setIfcgDelNy(Integer ifcgDelNy) {
		this.ifcgDelNy = ifcgDelNy;
	}
	public String getIfcgDesc() {
		return ifcgDesc;
	}
	public void setIfcgDesc(String ifcgDesc) {
		this.ifcgDesc = ifcgDesc;
	}
	public Date getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(Date regDateTime) {
		this.regDateTime = regDateTime;
	}
	public Date getRegDateTimeRevise() {
		return regDateTimeRevise;
	}
	public void setRegDateTimeRevise(Date regDateTimeRevise) {
		this.regDateTimeRevise = regDateTimeRevise;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
}

