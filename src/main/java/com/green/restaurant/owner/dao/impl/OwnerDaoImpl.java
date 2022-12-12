package com.green.restaurant.owner.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.owner.dao.OwnerDao;
import com.green.restaurant.owner.vo.RestaurantJoinMenu;
import com.green.restaurant.owner.vo.RestaurantVo;
import com.green.restaurant.user.vo.UserVo;

@Repository("ownerDao")
public class OwnerDaoImpl implements OwnerDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertRestaurant(HashMap<String, Object> map) {

		System.out.println("ownerDao.insertRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		
		//List<FilesVo> filesList = (List<FilesVo>) map.get("filesList");
		//System.out.println("ownerDao.insertRestaurant>>>>>>>>>>>>>>>>filesList: " + filesList.size());
//		if(filesList.size() > 0) {
//			int stable_idx = this.sqlSession.selectOne("Restaurant.SelectNextResaurantIdx");
//			map.put("stable_idx", stable_idx);
//			System.out.println("ownerDao.insertRestaurantIf>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
//			this.sqlSession.insert("Pds.FileInsert", map);	//파일정보 저장
//		}
		this.sqlSession.insert("Owner.EnrollRestaurant", map);	//파일정보 없으면 그냥 저장
	}

	@Override
	public List<RestaurantVo> selectMyRestaurantList(UserVo userVo) {
		List<RestaurantVo> myRestaurantList = this.sqlSession.selectList("Owner.MyRestaurantList", userVo.getOwnerIdx());
		return myRestaurantList;
	}

	@Override
	public List<RestaurantJoinMenu> selectMyRestaurant(int restaurant_idx) {
		List<RestaurantJoinMenu> restaurantJoinMenu = this.sqlSession.selectList("Owner.GetMyRestaurant", restaurant_idx);
		System.out.println("ownerDao>>>>>>>>>>>>>>>>>>>restaurantJoinMenu: " + restaurantJoinMenu);
		return restaurantJoinMenu;
	}

	
}
