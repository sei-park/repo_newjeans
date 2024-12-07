package com.ador.infra.hotelRoom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelRoomService {
	
	@Autowired
	HotelRoomDao hotelRoomDao;
	
	// selectList
	public List<HotelRoomDto> selectRoomList(HotelRoomVo hotelRoomVo) {
		return hotelRoomDao.selectRoomList(hotelRoomVo);
	}
	
	// insert
	public int selectRoomInsert(HotelRoomDto hotelRoomDto) {
		return hotelRoomDao.selectRoomInsert(hotelRoomDto);
	}
	
	// selectOne
	public HotelRoomDto selectRoomSelectOne(HotelRoomDto hotelRoomDto) {
		return hotelRoomDao.selectRoomSelectOne(hotelRoomDto);
	}
	
	// update
	public int selectRoomUpdate(HotelRoomDto hotelRoomDto) {
		return hotelRoomDao.selectRoomUpdate(hotelRoomDto);
	}
	
	// paging
	public int selectOneCount(HotelRoomVo hotelRoomVo) {
		return hotelRoomDao.selectOneCount(hotelRoomVo);
	}

}
