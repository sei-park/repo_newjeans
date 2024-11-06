package com.ador.infra.hotelRoom;

import com.ador.common.constants.Constants;

public class HotelRoomVo {
	
	// search
	private Integer shDelNy;
	private Integer shaircondNy;
	private Integer shbathNy;
	private Integer shtvNy;
	private Integer shwifiNy;
	private Integer shcoffeeNy;
	private Integer shOption;
	private String shValue;
	
	// paging 
	private int thisPage = 1;									// 현재 페이지
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW;		// 화면에 보여줄 데이터 줄 갯수
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW;		// 화면에 보여줄 페이징 번호 갯수

	private int totalRows;										// 전체 데이터 갯수
	private int totalPages;										// 전체 페이지 번호
	private int startPage;										// 시작 페이지 번호
    private int endPage;										// 마지막 페이지 번호

	private int startRnumForMysql = 0;							// 쿼리 시작 row
	//--
	public Integer getShDelNy() {
		return shDelNy;
	}
	public void setShDelNy(Integer shDelNy) {
		this.shDelNy = shDelNy;
	}
	public Integer getShaircondNy() {
		return shaircondNy;
	}
	public void setShaircondNy(Integer shaircondNy) {
		this.shaircondNy = shaircondNy;
	}
	public Integer getShbathNy() {
		return shbathNy;
	}
	public void setShbathNy(Integer shbathNy) {
		this.shbathNy = shbathNy;
	}
	public Integer getShtvNy() {
		return shtvNy;
	}
	public void setShtvNy(Integer shtvNy) {
		this.shtvNy = shtvNy;
	}
	public Integer getShwifiNy() {
		return shwifiNy;
	}
	public void setShwifiNy(Integer shwifiNy) {
		this.shwifiNy = shwifiNy;
	}
	public Integer getShcoffeeNy() {
		return shcoffeeNy;
	}
	public void setShcoffeeNy(Integer shcoffeeNy) {
		this.shcoffeeNy = shcoffeeNy;
	}
	public Integer getShOption() {
		return shOption;
	}
	public void setShOption(Integer shOption) {
		this.shOption = shOption;
	}
	public String getShValue() {
		return shValue;
	}
	public void setShValue(String shValue) {
		this.shValue = shValue;
	}
	public int getThisPage() {
		return thisPage;
	}
	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}
	public int getRowNumToShow() {
		return rowNumToShow;
	}
	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}
	public int getPageNumToShow() {
		return pageNumToShow;
	}
	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartRnumForMysql() {
		return startRnumForMysql;
	}
	public void setStartRnumForMysql(int startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}
	
	/////////////////////////////////////////////////////////////////////
	
	
	public void setParamsPaging(int totalRows) {

		setTotalRows(totalRows);

		if (getTotalRows() == 0) { // 입력 받은 전체 데이터 개수가 0일때 
			setTotalPages(1); // 전체 페이지 번호는 1
		} else { // 그게 아니라면 
			setTotalPages(getTotalRows() / getRowNumToShow()); // (전체 페이지 번호) = (전체 데이터 개수) / (화면에 보여줄 데이터 줄 개수)
		}

		if (getTotalRows() % getRowNumToShow() > 0) { // (전체 데이터 개수) % (화면에 보여줄 데이터 줄 개수) 가 0보다 크면  
			setTotalPages(getTotalPages() + 1); // (전체 페이지 번호) = (전체 페이지 번호 + 1)
		}

		if (getTotalPages() < getThisPage()) { // (전체 페이지 번호) < (현재 페이지 번호) 일때 
			setThisPage(getTotalPages()); // (현재 페이지 번호) 는 (전페 페이지 번호)	
		}
		
		// (시작 페이지 번호) = (현제 페이지 번호 - 1) / (회면에 보여줄 페이징 번호 개수) * (회면에 보여줄 페이징 번호 개수 + 1)
		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1); 
		
		// (마지막 페이지 번호) = (시작 페이지 번호) + (화면에 보여줄 페이징 번호 개수) - 1
		setEndPage(getStartPage() + getPageNumToShow() - 1);

		if (getEndPage() > getTotalPages()) { // (마지막 페이지 번호) > (전체 페이지 번호) 일때 
			setEndPage(getTotalPages()); // (마지막 페이지 번호) = (전체 페이지 번호)
		}
		
		if (thisPage == 1) { // (현재 페이지가) 1일때 
			setStartRnumForMysql(0); // 쿼리 시작 row는 0
		} else {  // 그게 아니라면 
			setStartRnumForMysql((getRowNumToShow() * (getThisPage()-1))); 
			// (쿼리 시작 row) = (화면에 보여줄  데이터 개수) * (현재 페이지) - 1
		}
		
	
	}
	
	
	

}
