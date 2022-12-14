package com.green.restaurant.owner.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.owner.dao.OwnerDao;
import com.green.restaurant.owner.vo.RestaurantMenuFileJoinVo;
import com.green.restaurant.owner.vo.RestaurantVo;
import com.green.restaurant.pds.vo.FilesVo;
import com.green.restaurant.user.vo.UserVo;

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
	public List<RestaurantVo> selectMyRestaurantList(UserVo userVo) {
		List<RestaurantVo> myRestaurantList = this.sqlSession.selectList("Owner.MyRestaurantList", userVo.getOwnerIdx());
		return myRestaurantList;
	}

	@Override
	public List<RestaurantMenuFileJoinVo> selectMyRestaurantInfo(int restaurant_idx) {
		System.out.println("ownerDao.selectMyRestaurantAllInfo>>>>>>>>>>>>>>>>>>>restaurant_idx: " + restaurant_idx);
		List<RestaurantMenuFileJoinVo> restaurantInfo = this.sqlSession.selectList("Owner.GetMyRestaurantInfo", restaurant_idx);
		System.out.println("ownerDao.selectMyRestaurantAllInfo>>>>>>>>>>>>>>>>>>>restaurantInfo: " + restaurantInfo.toString());
		return restaurantInfo;
	}

	@Override
	public void updateRestaurant(HashMap<String, Object> map) {
		System.out.println("ownerDao>>>>>>>>>>>>>>>>>>>updateRestaurant: " + map);
		//this.sqlSession.update("Owner.UpdateRestaurant", map);
	}

}
