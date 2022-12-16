package com.green.restaurant.owner.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.green.restaurant.owner.vo.OwnerBoardVo;
import com.green.restaurant.owner.vo.OwnerCategoryVo;
import com.green.restaurant.owner.vo.OwnerCommentVo;
import com.green.restaurant.owner.vo.OwnerMenuFileJoinVo;
import com.green.restaurant.owner.vo.OwnerRestaurantMenuFileJoinVo;
import com.green.restaurant.owner.vo.OwnerRestaurantVo;
import com.green.restaurant.user.vo.OwnerUserVo;

public interface OwnerService {
	void enrollRestorant(HashMap<String, Object> map, HttpServletRequest request);

	List<OwnerRestaurantVo> myRestaurantList(OwnerUserVo userVo);

	List<OwnerRestaurantMenuFileJoinVo> getMyRestaurantInfo(int restaurant_idx);

	void updateRestaurant(HashMap<String, Object> map);

	List<OwnerBoardVo> getReviewList(int restaurant_idx);

	List<OwnerCommentVo> getReviewCommentList(int board_idx);

	OwnerBoardVo getReview(int board_idx);

	List<OwnerCategoryVo> getCategoryList();

	int getRestaurantIdx(Integer ownerIdx);

	List<OwnerMenuFileJoinVo> getMenuList(HashMap<String, Object> map);

	void enrollMenu(HashMap<String, Object> map, HttpServletRequest request);

	void requestUpdate(HashMap<String, Object> map);


}
