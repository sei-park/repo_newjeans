package com.ador.infra.hotel;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface HotelDao {
	
	// selectList
	public List<HotelDto> hotelList(HotelVo hotelVo);
	
	// insert
	public int hotelInsert(HotelDto hotelDto);
	
	// selectOne
	public HotelDto hotelSelectOne(HotelDto hotelDto);
	
	// update
	public int hotelUpdate(HotelDto hotelDto);
	
	// update delete 
	public int uelete(HotelDto hotelDto);
	
	// delete
	public int delete(HotelDto hotelDto);
	
	// paging 
	public int selectOneCount(HotelVo hotelVo);
	

		
	
}
