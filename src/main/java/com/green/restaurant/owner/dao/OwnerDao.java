package com.green.restaurant.owner.dao;

import java.util.HashMap;
import java.util.List;

import com.green.restaurant.owner.vo.OwnerBoardVo;
import com.green.restaurant.owner.vo.OwnerCategoryVo;
import com.green.restaurant.owner.vo.OwnerCommentVo;
import com.green.restaurant.owner.vo.OwnerMenuFileJoinVo;
import com.green.restaurant.owner.vo.OwnerRestaurantMenuFileJoinVo;
import com.green.restaurant.owner.vo.OwnerRestaurantVo;
import com.green.restaurant.user.vo.OwnerUserVo;

public interface OwnerDao {
	void insertRestaurant(HashMap<String, Object> map);

	List<OwnerRestaurantVo> selectMyRestaurantList(OwnerUserVo userVo);

	List<OwnerRestaurantMenuFileJoinVo> selectMyRestaurantInfo(int restaurant_idx);

	void updateRestaurant(HashMap<String, Object> map);

	List<OwnerBoardVo> selectReviewList(int restaurant_idx);

	List<OwnerCommentVo> selectReviewCommentList(int board_idx);

	OwnerBoardVo selectReview(int board_idx);

	List<OwnerCategoryVo> selectCategoryList();

	int selectRestaurantIdx(Integer ownerIdx);

	List<OwnerMenuFileJoinVo> selectMenuList(HashMap<String, Object> map);

	void insertMenu(HashMap<String, Object> map);

	void insertOwnerInfo(HashMap<String, Object> map);

	
}
