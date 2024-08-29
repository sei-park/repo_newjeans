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
	
	@RequestMapping(value="/xdm/v1/infra/restaurant/restaurantInformatoin")
	public String restaurantInformatoin(Model model) {
		
		List<RestaurantDto> rest = restaurantService.restaurantList();
		model.addAttribute("restlist", rest);
		
//		for(RestaurantDto restdto : rest) {
//			System.out.println(restdto.getBrand() + " | " + restdto.getRestaurantName() + " | " + restdto.getBusinessHoursStart()
//			+ " | " + restdto.getBusinessHoursEnd() + " | " + restdto.getTel() + "  | " + restdto.getInternetAddress()
//			+ " | " + restdto.getParkingNy() + " | " + restdto.getBookNy() + " | " + restdto.getCorkageNy()
//			+ " | " + restdto.getAbout() + " | " + restdto.getRegDate() + " | " + restdto.getRevDate());
//		}
		
		return "/xdm/v1/infra/restaurant/restaurantInformatoin";
	}

}
