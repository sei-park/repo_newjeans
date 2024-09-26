package com.ador.infra.hotel;

import com.ador.common.constants.Constants;

public class HotelVo {
	
	private Integer shDelNy;
	private String shDateStart;
	private String shDateEnd;
	private Integer shOptionDate;
	private Integer shOption;
	private String shValue;
	private Integer shStar;
	private Integer shRestaurant;
	private Integer shSpa;
	private Integer shFitnessCenter;
	private Integer shPool;
	private Integer shlounge;
	private Integer shStockRoom;
	private Integer shParking;
	private Integer shShuttleBus;
	private Integer shBreakfast;
	private Integer shRoomService;
	private Integer shElse;
	
	// paging 
	private int thisPage = 1;									// 현재 페이지
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW;		// 화면에 보여줄 데이터 줄 개수
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW;		// 화면에 보여줄 페이징 번호 개수

	private int totalRows;										// 전체 데이터 개수
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
	public String getShDateStart() {
		return shDateStart;
	}
	public void setShDateStart(String shDateStart) {
		this.shDateStart = shDateStart;
	}
	public String getShDateEnd() {
		return shDateEnd;
	}
	public void setShDateEnd(String shDateEnd) {
		this.shDateEnd = shDateEnd;
	}
	public Integer getShOptionDate() {
		return shOptionDate;
	}
	public void setShOptionDate(Integer shOptionDate) {
		this.shOptionDate = shOptionDate;
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
	public Integer getShStar() {
		return shStar;
	}
	public void setShStar(Integer shStar) {
		this.shStar = shStar;
	}
	public Integer getShRestaurant() {
		return shRestaurant;
	}
	public void setShRestaurant(Integer shRestaurant) {
		this.shRestaurant = shRestaurant;
	}
	public Integer getShSpa() {
		return shSpa;
	}
	public void setShSpa(Integer shSpa) {
		this.shSpa = shSpa;
	}
	public Integer getShFitnessCenter() {
		return shFitnessCenter;
	}
	public void setShFitnessCenter(Integer shFitnessCenter) {
		this.shFitnessCenter = shFitnessCenter;
	}
	public Integer getShPool() {
		return shPool;
	}
	public void setShPool(Integer shPool) {
		this.shPool = shPool;
	}
	public Integer getShlounge() {
		return shlounge;
	}
	public void setShlounge(Integer shlounge) {
		this.shlounge = shlounge;
	}
	public Integer getShStockRoom() {
		return shStockRoom;
	}
	public void setShStockRoom(Integer shStockRoom) {
		this.shStockRoom = shStockRoom;
	}
	public Integer getShParking() {
		return shParking;
	}
	public void setShParking(Integer shParking) {
		this.shParking = shParking;
	}
	public Integer getShShuttleBus() {
		return shShuttleBus;
	}
	public void setShShuttleBus(Integer shShuttleBus) {
		this.shShuttleBus = shShuttleBus;
	}
	public Integer getShBreakfast() {
		return shBreakfast;
	}
	public void setShBreakfast(Integer shBreakfast) {
		this.shBreakfast = shBreakfast;
	}
	public Integer getShRoomService() {
		return shRoomService;
	}
	public void setShRoomService(Integer shRoomService) {
		this.shRoomService = shRoomService;
	}
	public Integer getShElse() {
		return shElse;
	}
	public void setShElse(Integer shElse) {
		this.shElse = shElse;
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
	
	//////////////////////////////////////////////////////
	
	
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
		
		// 출력 
		System.out.println("thispage : " +  getThisPage());
		System.out.println("rowNumToShow : " + getRowNumToShow());
		System.out.println("pageNumToShow : " + getPageNumToShow());
		System.out.println("totalRows : " + getTotalRows());
		System.out.println("totalPages : " + getTotalPages());
		System.out.println("startPage : " + getStartPage());
		System.out.println("endPage : " + getEndPage());
		System.out.println("startRnumForMysql : " + getStartRnumForMysql());
	
	}
	
	
	
	
	

}  
  