package com.ador.infra.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {
	
	public List<CodeGroupDto> selectList();
	
	public int insert(CodeGroupDto codeGroupDto); // int 인 이유 : 데이터가 몇 건이 처리됐는지 확인 

}
