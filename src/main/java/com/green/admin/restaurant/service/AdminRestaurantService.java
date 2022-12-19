package com.green.admin.restaurant.service;

import java.util.List;

import com.green.admin.restaurant.vo.AdminRestaurantVo;

public interface AdminRestaurantService {

	List<AdminRestaurantVo> restaurantList();
	
	void deleteRestaurant(String brand_name);
	
	void restaurantUpdate(AdminRestaurantVo restaurantVo);
	
	AdminRestaurantVo restaurantView(int restaurant_idx);
	
	List<AdminRestaurantVo> restaurantMap();
}
