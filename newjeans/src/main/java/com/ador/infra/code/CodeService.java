package com.ador.infra.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ador.infra.codegroup.CodeGroupDao;

@Service
public class CodeService {
	
	@Autowired
	CodeDao dao;
	
	public void selectList( ) {
		dao.selectList();
	}

}
