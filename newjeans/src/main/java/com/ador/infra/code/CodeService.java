package com.ador.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codeDao;
    
	// select
	public List<CodeDto> codeSelectList(CodeVo codeVo) {
		return codeDao.codeSelectList(codeVo);
	}
	
	// codegroup - code select 
	public List<CodeDto> selectListCode() {
		return codeDao.selectListCode();
	}
	
	// insert 
	public int codeInsert(CodeDto codeDto) {
		return codeDao.codeInsert(codeDto);
	}
	
	// selectOne
	public CodeDto codeSelectOne(CodeDto codeDto) {
		return codeDao.codeSelectOne(codeDto);
	}
	
	// update 
	public int codeUpdate(CodeDto codeDto) {
		return codeDao.codeUpdate(codeDto);
	}
	
	// update ifcdDelNy
	public int uelete(CodeDto codeDto) {
		return codeDao.uelete(codeDto);
	}
	
	// delete
	public int delete(CodeDto codeDto) {
		return codeDao.delete(codeDto);
	}
	
	// paging 
	public int selectOneCount(CodeVo codeVo) {
		return codeDao.selectOneCount(codeVo);
	}
	


} 
