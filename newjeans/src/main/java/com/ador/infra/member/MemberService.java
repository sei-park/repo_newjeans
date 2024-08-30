package com.ador.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public List<MemberDto> memberList() {
		List<MemberDto> members = memberDao.memberList();
		return members;
	}
	
	public int insert(MemberDto memberDto) {
		return memberDao.insert(memberDto);
	}
 
}
