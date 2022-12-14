package com.green.restaurant.owner.dao;

import java.util.HashMap;
import java.util.List;

import com.green.restaurant.owner.vo.RestaurantMenuFileJoinVo;
import com.green.restaurant.owner.vo.RestaurantVo;
import com.green.restaurant.user.vo.UserVo;

public interface OwnerDao {
	void insertRestaurant(HashMap<String, Object> map);

	List<RestaurantVo> selectMyRestaurantList(UserVo userVo);

	List<RestaurantMenuFileJoinVo> selectMyRestaurantInfo(int restaurant_idx);

	void updateRestaurant(HashMap<String, Object> map);

	
}
