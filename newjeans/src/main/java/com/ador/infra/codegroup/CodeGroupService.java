package com.ador.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	
	@Autowired
	CodeGroupDao codeGroupDao;
	
	// select
	public List<CodeGroupDto> selectList(CodeGroupVo codeGroupVo) {
		List<CodeGroupDto> codegroups = codeGroupDao.selectList(codeGroupVo);
		return codegroups;
	}
	
	// insert 
	public int insert(CodeGroupDto codeGroupDto) { 
		int result = codeGroupDao.insert(codeGroupDto); // Dao에서 int로 받았기 때문에 int로 해야 함 
		return result;
	}
	
	// selectone 
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto) {
		CodeGroupDto dto = codeGroupDao.selectOne(codeGroupDto); // 함수 사용 
		return dto;
	}
	
	// update 
	public int update(CodeGroupDto codeGroupDto) {
		return codeGroupDao.update(codeGroupDto);
	}
	
	// update ifcgDelNy
	public int uelete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.uelete(codeGroupDto);
	}
	
	// delete
	public int delete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.delete(codeGroupDto);
	}
	
	// paging 
	public int selectOneCount(CodeGroupVo codeGroupVo) { 
	    return codeGroupDao.selectOneCount(codeGroupVo); 
	}

	// 줄여서 쓰는 방법 
//	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto) {
//		return codeGroupDao.selectOne(codeGroupDto);
//	}
//	
	
	// 줄여서 쓰는 방법  
//	public int insert(CodeGroupDto codeGroupDto) {
//		return codeGroupDao.insert(codeGroupDto);
//	}
	
	// 줄여서 쓰는 방법 
//	public List<CodeGroupDto> selectList() {
//		return codeGroupDao.selectList();
//	}

}
