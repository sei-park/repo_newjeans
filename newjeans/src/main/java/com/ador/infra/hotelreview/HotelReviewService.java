package com.ador.infra.hotelreview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelReviewService { 
	
	@Autowired
	HotelReviewDao hotelReviewDao;
	
	// selectList
	public List<HotelReviewDto> hotelReviewList(HotelReviewDto hotelReviewDto) {
		return hotelReviewDao.hotelReviewList(hotelReviewDto);
	}
	
	// insert
	public int hotelReviewInsert(HotelReviewDto hotelReviewDto) {
		return hotelReviewDao.hotelReviewInsert(hotelReviewDto);
	}
	
	// 최신 리뷰 조회 메서드
//	public HotelReviewDto getLatestReviewByUser(String htrId, String hotelSeq) {
//	    return hotelReviewDao.findLatestReviewByUser(htrId, hotelSeq);
//	}
	
          
}
