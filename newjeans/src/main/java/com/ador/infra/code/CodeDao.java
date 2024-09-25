package com.ador.infra.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {
	
	// select
	public List<CodeDto> codeSelectList(CodeVo codeVo);
	 
	// codegroup - code select 연결
	public List<CodeDto> selectListCode();
	
	// insert 
	public int codeInsert(CodeDto codeDto);
	
	// selectone 
	public CodeDto codeSelectOne(CodeDto codeDto);
	
	// update
	public int codeUpdate(CodeDto codeDto);
	
	// update ifcdDelNy
	public int uelete(CodeDto codeDto);
	
	// delete
	public int delete(CodeDto codeDto);
	
	// paging 
	public int selectOneCount(CodeVo codeVo);
	
	public List<CodeDto> selectListCachedCodeArrayList();
						
	
}
