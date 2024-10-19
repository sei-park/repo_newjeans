package com.ador.infra.hotelRoom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelRoomService {
	
	@Autowired
	HotelRoomDao hotelRoomDao;
	
	public List<HotelRoomDto> selectRoomList() {
		return hotelRoomDao.selectRoomList();
	}

}
