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
	
	public int insert(CodeGroupDto codeGroupDto) { 
		int result = codeGroupDao.insert(codeGroupDto); // Dao에서 int로 받았기 때문에 int로 해야 함 
		return result;
	}
	
	// 줄여서 쓰는 방법  
//	public int insert(CodeGroupDto codeGroupDto) {
//		return codeGroupDao.insert(codeGroupDto);
//	}
	
	// 줄여서 쓰는 방법 
//	public List<CodeGroupDto> selectList() {
//		return codeGroupDao.selectList();
//	}

}
