package com.ador.infra.restaurant;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao {
	
	public List<RestaurantDto> restaurantList();
	
	public int resInsert(RestaurantDto restaurantDto);

}
