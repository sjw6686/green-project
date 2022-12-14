package com.green.restaurant.owner.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.owner.dao.OwnerDao;
import com.green.restaurant.owner.service.OwnerService;
import com.green.restaurant.owner.vo.RestaurantMenuFileJoinVo;
import com.green.restaurant.owner.vo.RestaurantVo;
import com.green.restaurant.pds.service.impl.PdsFile;
import com.green.restaurant.user.vo.UserVo;

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
	public List<RestaurantVo> myRestaurantList(UserVo userVo) {
		List<RestaurantVo> myRestaurantList = this.ownerDao.selectMyRestaurantList(userVo);
		return myRestaurantList;
	}

	@Override
	public List<RestaurantMenuFileJoinVo> getMyRestaurantInfo(int restaurant_idx) {
		System.out.println("ownerService.getMyRestaurantInfo>>>>>>>>>>>>>>>>>>>restaurant_idx: " + restaurant_idx);
		List<RestaurantMenuFileJoinVo> restaurantInfo = this.ownerDao.selectMyRestaurantInfo(restaurant_idx);
		System.out.println("ownerService.getMyRestaurantInfo>>>>>>>>>>>>>>>>>>>restaurantInfo: " + restaurantInfo.toString());
		return restaurantInfo;
	}

	@Override
	public void updateRestaurant(HashMap<String, Object> map) {
		System.out.println("ownerService.updateRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		this.ownerDao.updateRestaurant(map);
	}

}
