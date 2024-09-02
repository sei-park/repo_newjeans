package com.ador.infra.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	// 리스트
	@RequestMapping(value="/xdm/v1/infra/restaurant/restaurantList")
	public String restaurantInformatoin(Model model) {
		
		List<RestaurantDto> rest = restaurantService.restaurantList();
		model.addAttribute("restlist", rest);
		
//		for(RestaurantDto restdto : rest) {
//			System.out.println(restdto.getBrand() + " | " + restdto.getRestaurantName() + " | " + restdto.getBusinessHoursStart()
//			+ " | " + restdto.getBusinessHoursEnd() + " | " + restdto.getTel() + "  | " + restdto.getInternetAddress()
//			+ " | " + restdto.getParkingNy() + " | " + restdto.getBookNy() + " | " + restdto.getCorkageNy()
//			+ " | " + restdto.getAbout() + " | " + restdto.getRegDate() + " | " + restdto.getRevDate());
//		}
		
		return "/xdm/v1/infra/restaurant/restaurantList";
	} 
	
	// 폼
	@RequestMapping(value="/xdm/v1/infra/restaurant/restaurantForm")
	public String restaurantForm() {		
		return "/xdm/v1/infra/restaurant/restaurantForm";
	}
	
	@RequestMapping(value="/xdm/v1/infra/restaurant/restaurantXdmInst")
	public String membersXdmInst(RestaurantDto restaurantDto) {
		
		System.out.println(restaurantDto.getBrand());
		
		restaurantService.resInsert(restaurantDto);
		
		return "redirect:/xdm/v1/infra/restaurant/restaurantList";
	} 
	
	// -------------------------------------------------------------------
    
	// M폼
	@RequestMapping(value="/xdm/v1/infra/restaurant/restaurantMForm")
	public String restaurantMForm() {
		return "/xdm/v1/infra/restaurant/restaurantMForm";
	}

}
