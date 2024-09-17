package com.ador.infra.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
	
	@Autowired
	HotelDao hotelDao;
	
	// selectList
	public List<HotelDto> hotelList() {
		return hotelDao.hotelList();
	}
	
	// insert 
	public int hotelInsert(HotelDto hotelDto) {
		return hotelDao.hotelInsert(hotelDto);
	}

}
