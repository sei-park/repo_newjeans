package com.ador.infra.educationclass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EducationController {
	
	@Autowired
	EducationService educationService;
	
	// 리스트
	@RequestMapping(value="/xdm/v1/infra/education/educationList")
	public String educationclass(Model model) {
		  
		List<EducationDto> eduClass = educationService.classList();
		model.addAttribute("eduClasslist", eduClass);
		
		return "/xdm/v1/infra/education/educationList";
	}
	
	// 폼
	@RequestMapping(value="/xdm/v1/infra/education/educationForm")
	public String educationForm( ) {
		return "/xdm/v1/infra/education/educationForm";
	}
	

	@RequestMapping(value="/xdm/v1/infra/education/educationXdmInst")
	public String educationXdmInst(EducationDto educationDto) {
		
		System.out.println(educationDto.getEducationName());
		
		educationService.classInsert(educationDto);
	
		return "redirect:/xdm/v1/infra/education/educationList";
	}
	
	// ------------------------------------------------------
	@RequestMapping("/xdm/v1/infra/education/educationMForm")
	public String educationMForm(EducationDto educationDto, Model model) {
		EducationDto dto = educationService.classSelectOne(educationDto);
		model.addAttribute("classitem", dto);
		return "/xdm/v1/infra/education/educationMForm";
	}


}
