package com.ador.infra.hotelreview;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface HotelReviewDao {
	
	// selectList
	public List<HotelReviewDto> hotelReviewList(HotelReviewDto hotelReviewDto);
	    
	// insert
	public int hotelReviewInsert(HotelReviewDto hotelReviewDto);
	
	// 최신 리뷰 조회 메서드
//	public HotelReviewDto findLatestReviewByUser(String htrId, String hotelSeq);
}
