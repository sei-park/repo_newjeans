package com.ador.infra.hotelRoom;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomDao {
	
	// selectList
	public List<HotelRoomDto> selectRoomList();
	
	// insert
	public int selectRoomInsert(HotelRoomDto hotelRoomDto);
	
	// selectOne
	public HotelRoomDto selectRoomSelectOne(HotelRoomDto hotelRoomDto);
	
	// update
	public int selectRoomUpdate(HotelRoomDto hotelRoomDto);
}
