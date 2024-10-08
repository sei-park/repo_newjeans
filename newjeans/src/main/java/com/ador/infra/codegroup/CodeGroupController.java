package com.ador.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ador.common.util.UtilDateTime;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	//////////select ////////// 
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo codeGroupVo, Model model) {
		
		// 스프링에서 만든는 클래스는 모두 선언 클래스
	    // Controller 에서 받은 객체를 html 에 넘기기 위해서는 Model 객체 사용해야 함 
		
		// getshDateStart()에 "00:00:00"을 넣고 setShDateStart에서 보여줌 
//		codeGroupVo.setShDateStart(codeGroupVo.getShDateStart() + " 00:00:00"); 
//		codeGroupVo.setShDateEnd(codeGroupVo.getShDateEnd() + " 23:59:59");
	
		/* 초기값 세팅이 없는 경우 사용 */
		// shDateStart 값이 null 이거나 비어 있을 경우 UtilDateTime 클래스를 실행 
		codeGroupVo.setShDateStart(codeGroupVo.getShDateStart() == null || codeGroupVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(codeGroupVo.getShDateStart()));
		// shDateEnd 값이 null 이거나 비어 있을 경우 UtilDateTime 클래스를 실행 
		codeGroupVo.setShDateEnd(codeGroupVo.getShDateEnd() == null || codeGroupVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(codeGroupVo.getShDateEnd()));
		
		// List<CodeGroupDto> codegroups = codeGroupService.selectList(codeGroupVo);
		
		codeGroupVo.setParamsPaging(codeGroupService.selectOneCount(codeGroupVo));
		
		if(codeGroupVo.getTotalRows() > 0) {
			model.addAttribute("list", codeGroupService.selectList(codeGroupVo));
		//	model.addAttribute("vo", codeGroupVo); 
		}
		
		System.out.println("현재 페이지 : " + codeGroupVo.getThisPage());
		System.out.println(codeGroupVo.getShDateStart());
															 
		return "/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	
	// 폼  
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		return "/xdm/v1/infra/codegroup/codeGroupXdmForm";
	}
	
	////////// insert ////////// 
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
		 
		System.out.println("IfcgName = " + codeGroupDto.getIfcgName());
		
		codeGroupService.insert(codeGroupDto);
		
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	////////// selectOne  ////////// 
	// M폼 축약형
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmMForm")
	public String codeGroupXdmMForm(CodeGroupDto codeGroupDto, Model model) {
		
		model.addAttribute("item" , codeGroupService.selectOne(codeGroupDto)); // "변수명", 객체
		return "/xdm/v1/infra/codegroup/codeGroupXdmMForm";
	}
	
	////////// update  ////////// 
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmUpdt")
	public String codeGroupXdmUpdt(CodeGroupDto codeGroupDto) {
		
		codeGroupService.update(codeGroupDto);
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	// update ifcgDelNy(삭제여부 1로 변경)
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmMUdel")
	public String codeGroupXdmMUdel(CodeGroupDto codeGroupDto) {
		
	  codeGroupService.uelete(codeGroupDto);
      return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	
	// delete (아예 삭제하기)
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmMDel")
	public String codeGroupXdmMForm(CodeGroupDto codeGroupDto) {
		
		codeGroupService.delete(codeGroupDto);
		System.out.println(codeGroupDto.getIfcgName());
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	

	// M폼  
//	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmMForm")
//	public String codeGroupXdmMForm(CodeGroupDto codeGroupDto, Model model) {
//		
//		CodeGroupDto dto = codeGroupService.selectOne(codeGroupDto);
//		
//		model.addAttribute("item" ,dto); // "변수명", 객체
//		
//		return "/xdm/v1/infra/codegroup/codeGroupXdmMForm";
//	}
	 
	@RequestMapping(value="/xdm/v1/infra/codegroup/test")
	public String test() {
		return "/xdm/v1/infra/codegroup/test";
	}
	
	
	

}
