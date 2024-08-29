package com.ador.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codeDao;
	
	public List<CodeDto> codeSelectList() {
		List<CodeDto> codes = codeDao.codeSelectList();
		return codes;
	}

}
