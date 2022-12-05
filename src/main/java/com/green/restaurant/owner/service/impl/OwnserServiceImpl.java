package com.green.restaurant.owner.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.owner.dao.OwnerDao;
import com.green.restaurant.owner.service.OwnerService;
import com.green.restaurant.owner.vo.OwnerVo;

@Service("ownerService")
public class OwnserServiceImpl implements OwnerService {
	
	@Autowired
	private OwnerDao ownerDao;

	@Override
	public List<OwnerVo> getOwnerList() {
		List<OwnerVo> ownerList = this.ownerDao.selectOwnerList();
		return ownerList;
	}

	@Override
	public OwnerVo login(HashMap<String, Object> map) {
		System.out.println("ownerService>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>login() called");
		OwnerVo ownerVo = this.ownerDao.login(map);
		return ownerVo;
	}

	@Override
	public void ownerSignUp(HashMap<String, Object> map) {
		System.out.println("service>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		this.ownerDao.ownerInsert(map);
	}

}
