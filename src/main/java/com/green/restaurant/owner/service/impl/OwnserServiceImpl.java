package com.green.restaurant.owner.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.owner.dao.OwnerDao;
import com.green.restaurant.owner.service.OwnerService;
import com.green.restaurant.owner.vo.OwnerBoardVo;
import com.green.restaurant.owner.vo.OwnerCategoryVo;
import com.green.restaurant.owner.vo.OwnerCommentVo;
import com.green.restaurant.owner.vo.OwnerMenuFileJoinVo;
import com.green.restaurant.owner.vo.OwnerRestaurantMenuFileJoinVo;
import com.green.restaurant.owner.vo.OwnerRestaurantVo;
import com.green.restaurant.pds.service.impl.PdsFile;
import com.green.restaurant.user.vo.OwnerUserVo;

@Service("ownerService")
public class OwnserServiceImpl implements OwnerService {
	@Autowired
	private OwnerDao ownerDao;
	
	@Override
	public void enrollRestorant(HashMap<String, Object> map, HttpServletRequest request) {
		System.out.println("ownerService.enrollRestorant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>restaurantVo: " + map);
		PdsFile.save(map, request);	//파일정보가 string 형태로 되어있는 정보인 map과, 실제 정보가 담겨있는 request를 매개변수로 PdsFile의 save()실행. save()는 실제 저장될 파일이름을 중복처리한다음 반환한다
		this.ownerDao.insertRestaurant(map);
	}

	@Override
	public List<OwnerRestaurantVo> myRestaurantList(OwnerUserVo userVo) {
		List<OwnerRestaurantVo> myRestaurantList = this.ownerDao.selectMyRestaurantList(userVo);
		return myRestaurantList;
	}

	@Override
	public List<OwnerRestaurantMenuFileJoinVo> getMyRestaurantInfo(int restaurant_idx) {
		System.out.println("ownerService.getMyRestaurantInfo>>>>>>>>>>>>>>>>>>>restaurant_idx: " + restaurant_idx);
		List<OwnerRestaurantMenuFileJoinVo> restaurantInfo = this.ownerDao.selectMyRestaurantInfo(restaurant_idx);
		System.out.println("ownerService.getMyRestaurantInfo>>>>>>>>>>>>>>>>>>>restaurantInfo: " + restaurantInfo.toString());
		return restaurantInfo;
	}

	@Override
	public void updateRestaurant(HashMap<String, Object> map) {
		System.out.println("ownerService.updateRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		this.ownerDao.updateRestaurant(map);
	}

	@Override
	public List<OwnerBoardVo> getReviewList(int restaurant_idx) {
		System.out.println("ownerService.getBoardInfo>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>restaurant_idx: " + restaurant_idx);
		List<OwnerBoardVo> boardInfo =  this.ownerDao.selectReviewList(restaurant_idx);
		System.out.println("ownerService.getBoardInfo>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>boardInfo: " + boardInfo);
		return boardInfo;
	}

	@Override
	public List<OwnerCommentVo> getReviewCommentList(int board_idx) {
		System.out.println("OwnerService.reviewComment>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>board_idx: " + board_idx);
		List<OwnerCommentVo> reviewCommentList = this.ownerDao.selectReviewCommentList(board_idx);
		System.out.println("OwnerService.getReviewCommentList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>reviewCommentList: " + reviewCommentList.toString());
		return reviewCommentList;
	}

	@Override
	public OwnerBoardVo getReview(int board_idx) {
		System.out.println("OwnerService.getReview>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>board_idx: " + board_idx);
		OwnerBoardVo ownerBoardVo = this.ownerDao.selectReview(board_idx);
		System.out.println("OwnerService.getReview>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ownerBoardVo: " + ownerBoardVo.toString());
		return ownerBoardVo;
	}

	@Override
	public List<OwnerCategoryVo> getCategoryList() {
		List<OwnerCategoryVo> categoryList = this.ownerDao.selectCategoryList();
		System.out.println("OwnerService.getCategoryList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>categoryList: " + categoryList);
		return categoryList;
	}

	@Override
	public int getRestaurantIdx(Integer ownerIdx) {
		System.out.println("OwnerService.getRestaurantIdx>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ownerIdx: " + ownerIdx);
		int restaurnat_idx = this.ownerDao.selectRestaurantIdx(ownerIdx);
		return restaurnat_idx;
	}

	@Override
	public List<OwnerMenuFileJoinVo> getMenuList(HashMap<String, Object> map) {
		System.out.println("OwnerService.getMenuList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		List<OwnerMenuFileJoinVo> menuList = this.ownerDao.selectMenuList(map);
		System.out.println("OwnerService.getMenuList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>menuList: " + menuList.toString());
		return menuList;
	}

	@Override
	public void enrollMenu(HashMap<String, Object> map, HttpServletRequest request) {
		System.out.println("ownerService.enrollMenu>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		PdsFile.save(map, request);
		this.ownerDao.insertMenu(map);
	}


}
