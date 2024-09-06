package com.ador.infra.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {
	
	// select
	public List<CodeDto> codeSelectList();
	
	// codegroup - code select 
	public List<CodeDto> selectListCode();
	
	// insert 
	public int codeInsert(CodeDto codeDto);
	
	// selectone 
	public CodeDto codeSelectOne(CodeDto codeDto);
						
	
}
