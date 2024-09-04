package com.ador.infra.educationclass;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository 
public interface EducationDao {
	
	public List<EducationDto> classList();
	
	public int classInsert(EducationDto educationDto);
	
	public EducationDto classSelectOne(EducationDto educationDto);
	
	public int classUpdate(EducationDto educationDto);
	

}
