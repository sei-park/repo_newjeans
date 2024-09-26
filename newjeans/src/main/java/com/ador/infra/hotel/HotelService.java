package com.ador.infra.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
	
	@Autowired
	HotelDao hotelDao;
	
	// selectList
	public List<HotelDto> hotelList(HotelVo hotelVo) {
		return hotelDao.hotelList(hotelVo);
	}
	
	// insert 
	public int hotelInsert(HotelDto hotelDto) {
		return hotelDao.hotelInsert(hotelDto);
	}
	
	// selectOne
	public HotelDto hotelSelectOne(HotelDto hotelDto) {
		return hotelDao.hotelSelectOne(hotelDto);
	}
	
	// update
	public int hotelUpdate(HotelDto hotelDto) {
		return hotelDao.hotelUpdate(hotelDto);
	}
	
	// update delete 
	public int uelete(HotelDto hotelDto) {
		return hotelDao.uelete(hotelDto);
	}
	
	// delete
	public int delete(HotelDto hotelDto) {
		return hotelDao.delete(hotelDto);
	}
	
	// paging
	public int selectOneCount(HotelVo hotelVo) {
		return hotelDao.selectOneCount(hotelVo);
	}
	
}
