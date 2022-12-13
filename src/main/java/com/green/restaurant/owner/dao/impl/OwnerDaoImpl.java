package com.green.restaurant.owner.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.owner.dao.OwnerDao;
import com.green.restaurant.owner.vo.RestaurantJoinMenu;
import com.green.restaurant.owner.vo.RestaurantVo;
import com.green.restaurant.pds.vo.FilesVo;
import com.green.restaurant.user.vo.UserVo;

@Repository("ownerDao")
public class OwnerDaoImpl implements OwnerDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertRestaurant(HashMap<String, Object> map) {

		System.out.println("ownerDao.insertRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		
		List<FilesVo> filesList = (List<FilesVo>) map.get("filesList");
		System.out.println("ownerDao.insertRestaurant>>>>>>>>>>>>>>>>filesList: " + filesList.size());
		if(filesList.size() > 0) {
			for(int i = 0; i < filesList.size(); i++) {
//				int nextRes_idx = this.sqlSession.selectOne("Restaurant.SelectNextResaurantIdx");
//				
//				map.put("nextRes_idx", nextRes_idx);
				System.out.println("ownerDao.insertRestaurantInIf>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
				
				this.sqlSession.insert("Owner.EnrollRestaurant", map);	//식당정보 먼저 저장
				System.out.println("ownerDao.insertRestaurantInIf>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>after restaurant insert");
				this.sqlSession.insert("Owner.EnrollMenu", map);	//메뉴정보 저장
				System.out.println("ownerDao.insertRestaurantInIf>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>after menu insert");
				this.sqlSession.insert("Pds.MenuFileInsert", map);	//파일정보 저장
				System.out.println("ownerDao.insertRestaurantInIf>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>after file insert");
			}
		}
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

	@Override
	public void updateRestaurant(HashMap<String, Object> map) {
		System.out.println("ownerDao>>>>>>>>>>>>>>>>>>>updateRestaurant: " + map);
		this.sqlSession.update("Owner.UpdateRestaurant", map);
	}

}
