package com.ador.infra.codegroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ador.common.util.UtilDateTime;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	//////////select ////////// 
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo codeGroupVo, Model model) throws IOException {
		
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
		
		// 공공데이터 Rest API
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=QFtzt2u6PfM5Vgzgr8u1mT0JF6lhaPHx3gOFYYAo4eGjDGhiQn2u9kl5u0WNm%2B309%2FYaexPy0h4Em2N%2FfkWWuA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) default : xml*/
        urlBuilder.append("&" + URLEncoder.encode("YYYY","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*년도*/
        urlBuilder.append("&" + URLEncoder.encode("MM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*실적월*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
       // System.out.println(sb.toString());
        
    	ObjectMapper objectMapper = new ObjectMapper();   
		JsonNode node = objectMapper.readTree(sb.toString());
		
//		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
//		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
//		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("body").get("items").get(0).get("KIT_PROD_QTY").asText());
		
		return "xdm/v1/infra/codegroup/codeGroupXdmList";
	} 
	
	
	// 폼  
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		return "xdm/v1/infra/codegroup/codeGroupXdmForm";
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
		return "xdm/v1/infra/codegroup/codeGroupXdmMForm";
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
		return "xdm/v1/infra/codegroup/test";
	}
	
	
	

}
