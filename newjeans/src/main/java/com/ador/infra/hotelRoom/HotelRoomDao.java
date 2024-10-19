package com.ador.infra.hotelRoom;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomDao {
	
	public List<HotelRoomDto> selectRoomList();

}
