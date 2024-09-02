package com.ador.infra.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantDao restaurantDao;
	
	public List<RestaurantDto> restaurantList() {
		List<RestaurantDto> rest = restaurantDao.restaurantList();
		return rest;
	}
	
	public int resInsert(RestaurantDto restaurantDto) {
		int result = restaurantDao.resInsert(restaurantDto);
		return result;
	}

}
