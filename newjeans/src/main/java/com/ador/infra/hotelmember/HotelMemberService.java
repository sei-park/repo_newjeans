package com.ador.infra.hotelmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelMemberService {
	
	@Autowired
	HotelMemberDao hotelMemberDao;
	
//	public List<HotelMemberDto> memberSelectList() {
//		List<HotelMemberDto> members = hotelMemberDao.memberSelectList();
//		return members;
//	}
	
	// selectList
	public List<HotelMemberDto> memberSelectList() {
		return hotelMemberDao.memberSelectList();
	}
	
	// insert 
	public int memberInsert(HotelMemberDto hotelMemberDto) {
		return hotelMemberDao.memberInsert(hotelMemberDto);
	}
	
	// selectOne
	public HotelMemberDto memberSelectOne(HotelMemberDto hotelMemberDto) {
		return hotelMemberDao.memberSelectOne(hotelMemberDto);
	}
	
	// update
	public int memberUpdate(HotelMemberDto hotelMemberDto) {
		return hotelMemberDao.memberUpdate(hotelMemberDto);
	}
 
}
