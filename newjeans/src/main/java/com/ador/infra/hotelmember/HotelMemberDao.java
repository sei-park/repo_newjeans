package com.ador.infra.hotelmember;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface HotelMemberDao {
	
	public List<HotelMemberDto> memberSelectList();
	
	

}
 