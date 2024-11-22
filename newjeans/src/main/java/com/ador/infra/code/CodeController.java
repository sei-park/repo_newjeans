package com.ador.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ador.common.util.UtilDateTime;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	
	// select
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmList") 
	public String codeXdmList(@ModelAttribute("vo") CodeVo codeVo, Model model) { 
		
		// getshDateStart()에 "00:00:00"을 넣고 setShDateStart에서 보여줌 
//		codeVo.setShDateStart(codeVo.getShDateStart() + " 00:00:00"); 
//		codeVo.setShDateEnd(codeVo.getShDateEnd() + " 23:59:59");
		
		/* 초기값 세팅이 없는 경우 사용 */
		// shDateStart 값이 null 이거나 비어 있을 경우 UtilDateTime 클래스를 실행 
		codeVo.setShDateStart(codeVo.getShDateStart() == null || codeVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(codeVo.getShDateStart()));
		// shDateEnd 값이 null 이거나 비어 있을 경우 UtilDateTime 클래스를 실행 
		codeVo.setShDateEnd(codeVo.getShDateEnd() == null || codeVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(codeVo.getShDateEnd()));
		
		codeVo.setParamsPaging(codeService.selectOneCount(codeVo));
		
		if(codeVo.getTotalRows() > 0) {
			model.addAttribute("codelist", codeService.codeSelectList(codeVo));
		}
		
//		List<CodeDto> codes = codeService.codeSelectList(codeVo);
//		model.addAttribute("codelist", codes);
		
		return "xdm/v1/infra/code/codeXdmList";
	}
	
	// codegroup - code 연결 
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmForm")
	public String codeXdmForm(Model model) {
		
		List<CodeDto> codeGroups = codeService.selectListCode();
		model.addAttribute("listCodeGroup", codeGroups);
		
		return "xdm/v1/infra/code/codeXdmForm";
	}
	
	// insert 
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		
		codeService.codeInsert(codeDto);
		System.out.println(codeDto.getCodegroup_ifcgSeq());
		
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	} 
	
	// selectOne
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmMForm")
	public String codeXdmMForm(CodeDto codeDto, Model model) {
		
		List<CodeDto> codeGroups = codeService.selectListCode();
		model.addAttribute("listCodeGroup", codeGroups);  
		
		model.addAttribute("codeItem", codeService.codeSelectOne(codeDto));
		return "xdm/v1/infra/code/codeXdmMForm";
	}
	
	// update
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmUpdt")
	public String codeXdmUpdt(CodeDto codeDto) {
		
		codeService.codeUpdate(codeDto);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
		
	}
	
	// update ifcdDelNy(삭제여부 1로 변경)
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmMUDel")
	public String codeXdmMUDel(CodeDto codeDto) {
		
		codeService.uelete(codeDto);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}
	
	// delete
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmMDel")
	public String codeXdmMDel(CodeDto codeDto) {
		
		codeService.delete(codeDto);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}
	
	
	


}
