package com.ador.infra.hotelmember;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface HotelMemberDao {
	
	// selectList
	public List<HotelMemberDto> memberSelectList(HotelMemberVo hotelMemberVo);
	
	// insert 
	public int memberInsert(HotelMemberDto hotelMemberDto);
	
	// selectOne
	public HotelMemberDto memberSelectOne(HotelMemberDto hotelMemberDto);
	
	// update 
	public int memberUpdate(HotelMemberDto hotelMemberDto);
	
	// update delete
	public int uelete(HotelMemberDto hotelMemberDto);
	 
	// delete
	public int delete(HotelMemberDto hotelMemberDto);
	
	// paging 
	public int selectOneCount(HotelMemberVo hotelMemberVo);
	
	// login
	public HotelMemberDto selectOneLogin(HotelMemberDto hotelMemberDto);
     
	
}
 