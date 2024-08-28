package com.ador.infra.educationclass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EducationController {
	
	@Autowired
	EducationService educationService;
	
	@RequestMapping(value="/xdm/v1/infra/education/educationclass")
	public String educationclass() {
		
		List<EducationDto> eduClass = educationService.classList();
		
		for(EducationDto dto : eduClass) {
			System.out.println(dto.getSeq() + " | " + dto.getEducationType() + " | " + dto.getEducationName()+ " | " 
					+ dto.getEducationExpenses() + " | " + dto.getTeacher() + dto.getCourseRegStart()
					+ "| " + dto.getCourseRegEnd() + " | " + dto.getStudyStart() + " | " + dto.getStudtEnd()
					+ " | " + dto.getEducationPlace() + " | " + dto.getEducationContent() + " | " 
					+ dto.getRegDate() + " | " + dto.getRevDate());
		}
		
		return "/xdm/v1/infra/education/educationclass";
	}
	 

}
