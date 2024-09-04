package com.ador.infra.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {
	
	// select
	public List<CodeGroupDto> selectList();
	
	// insert 
	public int insert(CodeGroupDto codeGroupDto); // int 인 이유 : 데이터가 몇 건이 처리됐는지 확인
	
	// selectone
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto); // CodeGroupDto 한 건을 뽑음 
	
	// update
	public int update(CodeGroupDto codeGroupDto);
	
	


}
