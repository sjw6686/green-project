package com.green.restaurant.owner.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.green.restaurant.owner.vo.RestaurantMenuFileJoinVo;
import com.green.restaurant.owner.vo.RestaurantVo;
import com.green.restaurant.user.vo.UserVo;

public interface OwnerService {
	void enrollRestorant(HashMap<String, Object> map, HttpServletRequest request);

	List<RestaurantVo> myRestaurantList(UserVo userVo);

	List<RestaurantMenuFileJoinVo> getMyRestaurantInfo(int restaurant_idx);

	void updateRestaurant(HashMap<String, Object> map);

}
