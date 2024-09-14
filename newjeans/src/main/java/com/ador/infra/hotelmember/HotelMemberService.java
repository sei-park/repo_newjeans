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
	
	public List<HotelMemberDto> memberSelectList() {
		return hotelMemberDao.memberSelectList();
	}
	
 
}
