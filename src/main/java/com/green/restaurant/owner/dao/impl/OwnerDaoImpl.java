package com.green.restaurant.owner.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.owner.dao.OwnerDao;
import com.green.restaurant.owner.vo.OwnerBoardVo;
import com.green.restaurant.owner.vo.OwnerCategoryVo;
import com.green.restaurant.owner.vo.OwnerCommentVo;
import com.green.restaurant.owner.vo.OwnerMenuFileJoinVo;
import com.green.restaurant.owner.vo.OwnerRestaurantMenuFileJoinVo;
import com.green.restaurant.owner.vo.OwnerRestaurantVo;
import com.green.restaurant.pds.vo.FilesVo;
import com.green.restaurant.user.vo.OwnerUserVo;

@Repository("ownerDao")
public class OwnerDaoImpl implements OwnerDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertRestaurant(HashMap<String, Object> map) {

		System.out.println("ownerDao.insertRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>restaurantVo: " + map);
		
		List<FilesVo> filesList = (List<FilesVo>) map.get("filesList");
		System.out.println("ownerDao.insertRestaurant>>>>>>>>>>>>>>>>filesList: " + filesList.size());
		if(filesList.size() > 0) {	
			int nextRes_idx = this.sqlSession.selectOne("Restaurant.SelectNextResaurantIdx");
			
			map.put("nextRes_idx", nextRes_idx);
			System.out.println("ownerDao.insertRestaurantInIf>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>after map.put(nextRes_idx): " + map.toString());
			this.sqlSession.insert("Pds.RestaurantFileInsert", map);	//파일정보 저장
			System.out.println("ownerDao.insertRestaurantInIf>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>after file insert");
		
		}
			this.sqlSession.insert("Owner.EnrollRestaurant", map);	//파일정보 없으면 그냥 저장
	}

	@Override
	public List<OwnerRestaurantVo> selectMyRestaurantList(OwnerUserVo userVo) {
		List<OwnerRestaurantVo> myRestaurantList = this.sqlSession.selectList("Owner.MyRestaurantList", userVo.getOwnerIdx());
		return myRestaurantList;
	}

	@Override
	public List<OwnerRestaurantMenuFileJoinVo> selectMyRestaurantInfo(int restaurant_idx) {
		System.out.println("ownerDao.selectMyRestaurantAllInfo>>>>>>>>>>>>>>>>>>>restaurant_idx: " + restaurant_idx);
		List<OwnerRestaurantMenuFileJoinVo> restaurantInfo = this.sqlSession.selectList("Owner.GetMyRestaurantInfo", restaurant_idx);
		System.out.println("ownerDao.selectMyRestaurantAllInfo>>>>>>>>>>>>>>>>>>>restaurantInfo: " + restaurantInfo.toString());
		return restaurantInfo;
	}

	@Override
	public void updateRestaurant(HashMap<String, Object> map) {
		System.out.println("ownerDao>>>>>>>>>>>>>>>>>>>updateRestaurant: " + map);
		//this.sqlSession.update("Owner.UpdateRestaurant", map);
	}

	@Override
	public List<OwnerBoardVo> selectReviewList(int restaurant_idx) {
		System.out.println("ownerDao.getBoardInfo>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>restaurant_idx: " + restaurant_idx);
		List<OwnerBoardVo> boardInfo = this.sqlSession.selectList("Owner.GetReviewList", restaurant_idx);
		System.out.println("ownerDao.getBoardInfo>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>boardInfo: " + boardInfo);
		return boardInfo;
	}

	@Override
	public List<OwnerCommentVo> selectReviewCommentList(int board_idx) {
		System.out.println("OwnerService.reviewComment>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>board_idx: " + board_idx);
		List<OwnerCommentVo> reviewCommentList = this.sqlSession.selectList("Owner.getReviewCommentList", board_idx);
		System.out.println("OwnerService.selectReviewCommentList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>reviewCommentList: " + reviewCommentList.toString());
		return reviewCommentList;
	}

	@Override
	public OwnerBoardVo selectReview(int board_idx) {
		System.out.println("OwnerDao.selectReview>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>board_idx: " + board_idx);
		OwnerBoardVo ownerBoardVo = this.sqlSession.selectOne("Owner.getReview", board_idx);
		System.out.println("OwnerDao.selectReview>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>boardVo: " + ownerBoardVo.toString());
		return ownerBoardVo;
	}

	@Override
	public List<OwnerCategoryVo> selectCategoryList() {
		List<OwnerCategoryVo> categoryList = this.sqlSession.selectList("Owner.getCategoryList");
		System.out.println("OwnerDao.selectCategoryList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>categoryList: " + categoryList.toString());
		return categoryList;
	}

	@Override
	public int selectRestaurantIdx(Integer ownerIdx) {
		System.out.println("OwnerDao.selectRestaurantIdx>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ownerIdx: " + ownerIdx);
		int restaurant_idx = this.sqlSession.selectOne("Owner.getRestaurantIdx", ownerIdx);
		System.out.println("OwnerDao.selectRestaurantIdx>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ownerIdx: " + restaurant_idx);
		return restaurant_idx;
	}

	@Override
	public List<OwnerMenuFileJoinVo> selectMenuList(HashMap<String, Object> map) {
		System.out.println("OwnerDao.selectMenuList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		List<OwnerMenuFileJoinVo> menuList = this.sqlSession.selectList("Owner.getMenuList", map);
		System.out.println("OwnerDao.selectMenuList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>menuList: " + menuList.toString());
		return menuList;
	}

	@Override
	public void insertMenu(HashMap<String, Object> map) {
		System.out.println("OwnerDao.insertMenu>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		this.sqlSession.insert("Owner.EnrollMenu", map);
		
		List<FilesVo> filesList = (List<FilesVo>) map.get("filesList");
		System.out.println("ownerDao.insertMenu>>>>>>>>>>>>>>>>filesList: " + filesList.size());
		if(filesList.size() > 0) {				
			System.out.println("ownerDao.insertMenu>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>in if");
			this.sqlSession.insert("Pds.MenuFileInsert", map);	//파일정보 저장
			System.out.println("ownerDao.insertRestaurantInIf>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>after file insert");
		
		}
				
	}


}
