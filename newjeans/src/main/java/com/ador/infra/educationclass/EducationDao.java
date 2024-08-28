package com.ador.infra.educationclass;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository 
public interface EducationDao {
	
	public List<EducationDto> classList();

}
