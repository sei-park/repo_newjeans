package com.ador.infra.member;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	
	public List<MemberDto> memberList();
	
	public int membersInsert(MemberDto memberDto);
	
	public MemberDto memberSelectOne(MemberDto memberDto);

}
