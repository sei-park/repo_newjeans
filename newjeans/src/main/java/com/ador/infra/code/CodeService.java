package com.ador.infra.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

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
	
	// 특정 함수를 구동시키는 어노테이션 
    @PostConstruct 
    // selectListCachedCodeArrayList() 매서드는 CodeDto 객체들의 리스트를 가져와서 cachedCodeArrayList에 저장함 
	public void selectListCachedCodeArrayList() {
    	// codeDao.selectListCachedCodeArrayList()는 Dao 매서드를 호출해서 CodeDto 리스트를 반환 
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) codeDao.selectListCachedCodeArrayList(); 
		CodeDto.cachedCodeArrayList.clear(); // 이전에 저장된 데이터를 모두 제거 
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb); // 새로운 데이터를 가져와서 cachedCodeArrayList에 추가함 
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}
    
    // 데이터 삭제
    public static void clear() {
		CodeDto.cachedCodeArrayList.clear();
	}
	
	
    // codegroup의 seq 번호를 받고 해당하는 code의 내용을 List로 출력 
	public static List<CodeDto> selectListCachedCode(String codegroup_ifcgSeq) {
//		System.out.println("codegroup_ifcgSeq : " + codegroup_ifcgSeq);
		List<CodeDto> rt = new ArrayList<CodeDto>();
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCodegroup_ifcgSeq().equals(codegroup_ifcgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}

	// code의 seq를 받아서 문자열로 출력 
	public static String selectOneCachedCode(int code) {
//		System.out.println("code : " + code);
		String rt = "";
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getIfcdSeq().equals(Integer.toString(code))) {
				rt = codeRow.getIfcdName();
			} else {
				// by pass
			}
		} 
		return rt;
	}


} 
