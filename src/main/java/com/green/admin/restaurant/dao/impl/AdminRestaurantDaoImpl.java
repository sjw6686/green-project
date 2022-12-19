package com.green.admin.restaurant.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.admin.restaurant.dao.AdminRestaurantDao;
import com.green.admin.restaurant.vo.AdminRestaurantVo;

@Repository("adminrestaurantDao")
public class AdminRestaurantDaoImpl implements AdminRestaurantDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<AdminRestaurantVo> restaurantList() {
		
		List<AdminRestaurantVo> restaurantList = sqlSession.selectList("AdminRestaurant.RestaurantList");
		
		return restaurantList;
	}

	@Override
	public void deleteRestaurant(String brand_name) {
		
		sqlSession.delete("AdminRestaurant.DeleteRestaurant", brand_name);
		
	}

	@Override
	public void restaurantUpdate(AdminRestaurantVo restaurantVo) {
		
		sqlSession.update("AdminRestaurant.RestaurantUpdate", restaurantVo);
		
	}

	@Override
	public AdminRestaurantVo restaurantView(int restaurant_idx) {
		
		AdminRestaurantVo restaurantVo = sqlSession.selectOne("AdminRestaurant.RestaurantView", restaurant_idx);
		
		return restaurantVo;
	}

	@Override
	public List<AdminRestaurantVo> restaurantMap() {
		
		
		
		System.out.println("daoImpl>>>>>>>>>>>>>>>>>>>>>>>>>>>>>restaurant: " + this.sqlSession.selectList("Restaurant.restaurantMap"));
		
		return this.sqlSession.selectList("AdminRestaurant.restaurantMap");
	}


}
