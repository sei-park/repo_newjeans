package com.ador.infra.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@RequestMapping(value="/xdm/v1/infra/restaurant/restaurantInformatoin")
	public String restaurantInformatoin() {
		
		List<RestaurantDto> rest = restaurantService.restaurantList();
		
		return "/xdm/v1/infra/restaurant/restaurantInformatoin";
	}

}
