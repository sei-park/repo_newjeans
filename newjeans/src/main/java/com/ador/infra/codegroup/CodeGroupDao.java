package com.ador.infra.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {
	
	// selectList
	public List<CodeGroupDto> selectList(CodeGroupVo codeGroupVo);
	
	// insert 
	public int insert(CodeGroupDto codeGroupDto); // int 인 이유 : 데이터가 몇 건이 처리됐는지 확인
	
	// selectone
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto); // CodeGroupDto 한 건을 뽑음 
	
	// update
	public int update(CodeGroupDto codeGroupDto);
	
	// update ifcgDelNy
	public int uelete(CodeGroupDto codeGroupDto);
	
	// delete
	public int delete(CodeGroupDto codeGroupDto);
	
	// paging
	public int selectOneCount(CodeGroupVo codeGroupVo);
	
	
}
