package com.green.admin.restaurant.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.green.admin.restaurant.vo.AdminRestaurantVo;

public interface AdminRestaurantDao {

	List<AdminRestaurantVo> restaurantList();
	
	void deleteRestaurant(String brand_name);
	
	void restaurantUpdate(AdminRestaurantVo restaurantVo);
	
	AdminRestaurantVo restaurantView(int restaurant_idx);
	
	List<AdminRestaurantVo> restaurantMap();
	
	
}
