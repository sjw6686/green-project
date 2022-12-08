package com.green.restaurant.owner.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.owner.dao.OwnerDao;
import com.green.restaurant.owner.service.OwnerService;

@Service("ownerService")
public class OwnserServiceImpl implements OwnerService {
	@Autowired
	private OwnerDao ownerDao;
	
	@Override
	public void enrollRestorant(HashMap<String, Object> map) {
		System.out.println("ownerService.enrollRestorant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		this.ownerDao.insertRestaurant(map);
	}
}
