package com.ador.infra.educationclass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {
	
	@Autowired
	EducationDao educationDao;
	
	public List<EducationDto> classList() {
		List<EducationDto> eduClass = educationDao.classList();
		return eduClass;
	}
	
	public int classInsert(EducationDto educationDto) {
		int result = educationDao.classInsert(educationDto);
		return result;
	}
}
