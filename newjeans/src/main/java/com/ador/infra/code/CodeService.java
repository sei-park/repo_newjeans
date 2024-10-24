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
	public static String selectOneCachedCode(int code) { // selectOneCachedCode 라는 정적 매서드를 정의 
		// 입력 인수로 정수형 code를 받음, 반환값은 문자열(String)
//		System.out.println("code : " + code);
		// rt라는 이름의 빈 문자열을 초기값으로 하는 변수를 선언, 최종적으로 반환될 값 
		String rt = "";
		// 	CodeDto.cachedCodeArrayList를 반복해서 codeRow라는 변수에 리스트의 각 요소를 하나씩 대입하면서 반복문을 실행 
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			// codeRow 객체의 getIfcdSeq() 메서드를 호출하여 해당 객체의 IfcdSeq 값을 가져옴
			// 그 값이 입력으로 받은 code와 동일한지 비교, 이때 code는 정수이기 때문에 Integer.toString(code)를 사용하여 문자열로 변환 후 비교
			if (codeRow.getIfcdSeq().equals(Integer.toString(code))) {
				// 만약 조건이 참(true)이라면, codeRow의 getIfcdName() 메서드를 호출하여 IfcdName 값을 반환받아 rt에 저장
				rt = codeRow.getIfcdName();
			} else {
				// by pass
			}
		} 
		return rt;
	}


} 
