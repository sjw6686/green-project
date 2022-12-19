package com.green.admin.restaurant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.admin.restaurant.dao.AdminRestaurantDao;
import com.green.admin.restaurant.service.AdminRestaurantService;
import com.green.admin.restaurant.vo.AdminRestaurantVo;

@Service("adminrestaurantService")
public class AdminRestaurantServiceImpl implements AdminRestaurantService{
	
	@Autowired
	private AdminRestaurantDao restaurantdao;

	@Override
	public List<AdminRestaurantVo> restaurantList() {
		
		List<AdminRestaurantVo> restaurantList = restaurantdao.restaurantList();
		
		return restaurantList;
	}

	@Override
	public void deleteRestaurant(String brand_name) {
		
		restaurantdao.deleteRestaurant(brand_name);
		
	}

	@Override
	public void restaurantUpdate(AdminRestaurantVo restaurantVo) {

		restaurantdao.restaurantUpdate(restaurantVo);
		
	}

	@Override
	public AdminRestaurantVo restaurantView(int restaurant_idx) {
		
		AdminRestaurantVo restaurantVo = restaurantdao.restaurantView(restaurant_idx);
		
		return restaurantVo;
	}

	@Override
	public List<AdminRestaurantVo> restaurantMap() {
		
		
		
		System.out.println("serviceImpl>>>>>>>>>>>>>>>>>>>>>>>>>>>>>restaurant: " + this.restaurantdao.restaurantMap());
		
		return this.restaurantdao.restaurantMap();
	}


}
