package com.ador.infra.usrMember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ador.infra.hotelmember.HotelMemberDto;
import com.ador.infra.hotelmember.HotelMemberService;
import com.ador.infra.hotelmember.HotelMemberVo;

@RestController
@RequestMapping(value="/rest/usrMember")
public class MemberRestController {
	
	@Autowired
	HotelMemberService hotelMemberService;
	
//	@RequestMapping(value = "", method = RequestMethod.GET) 예전 방식
	@GetMapping("")
	public List<HotelMemberDto> memberSelectList(HotelMemberVo hotelMemberVo) throws Exception {
		List<HotelMemberDto> list = hotelMemberService.memberSelectList(hotelMemberVo);
		System.out.println(list+"@@@@@@@@@@@@@");
		return list;
	}
	
	@GetMapping("/{htmSeq}")
	public HotelMemberDto memberSelectOne(HotelMemberDto hotelMemberDto) throws Exception {
		HotelMemberDto item = hotelMemberService.memberSelectOne(hotelMemberDto);
		return item;
	}
	
	       
	

}
