package com.ador.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	
	@Autowired
	CodeGroupDao codeGroupDao;
	
	public List<CodeGroupDto> selectList() {
		List<CodeGroupDto> codegroups = codeGroupDao.selectList();
		return codegroups;
	}
	
	// 줄여서 쓰는 방법 
//	public List<CodeGroupDto> selectList() {
//		return codeGroupDao.selectList();
//	}

}
