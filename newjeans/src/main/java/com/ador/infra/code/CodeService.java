package com.ador.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codeDao;
    
	// select
	public List<CodeDto> codeSelectList() {
		return codeDao.codeSelectList();
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

} 
