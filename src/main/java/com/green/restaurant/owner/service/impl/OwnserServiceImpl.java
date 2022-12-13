package com.green.restaurant.owner.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.owner.dao.OwnerDao;
import com.green.restaurant.owner.service.OwnerService;
import com.green.restaurant.owner.vo.RestaurantJoinMenu;
import com.green.restaurant.owner.vo.RestaurantVo;
import com.green.restaurant.pds.service.impl.PdsFile;
import com.green.restaurant.user.vo.UserVo;

@Service("ownerService")
public class OwnserServiceImpl implements OwnerService {
	@Autowired
	private OwnerDao ownerDao;
	
	@Override
	public void enrollRestorant(HashMap<String, Object> map, HttpServletRequest request) {
		System.out.println("ownerService.enrollRestorant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		System.out.println("ownerService.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>request: " + request.toString());
		
		PdsFile.save(map, request);	//파일정보가 string 형태로 되어있는 정보인 map과, 실제 정보가 담겨있는 request를 매개변수로 PdsFile의 save()실행. save()는 실제 저장될 파일이름을 중복처리한다음 반환한다
		System.out.println("ownerService.enrollRestorant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>after PdsFile map: " + map);
		System.out.println("ownerService.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>after PdsFile request: " + request.toString());
		
		this.ownerDao.insertRestaurant(map);
	}

	@Override
	public List<RestaurantVo> myRestaurantList(UserVo userVo) {
		List<RestaurantVo> myRestaurantList = this.ownerDao.selectMyRestaurantList(userVo);
		return myRestaurantList;
	}

	@Override
	public List<RestaurantJoinMenu> getMyRestaurant(int restaurant_idx) {
		List<RestaurantJoinMenu> restaurantJoinMenu = this.ownerDao.selectMyRestaurant(restaurant_idx);
		System.out.println("ownerService>>>>>>>>>>>>>>>>>>>restaurantJoinMenu: " + restaurantJoinMenu);
		return restaurantJoinMenu;
	}

	@Override
	public void updateRestaurant(HashMap<String, Object> map) {
		System.out.println("ownerService.updateRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		this.ownerDao.updateRestaurant(map);
	}

}
