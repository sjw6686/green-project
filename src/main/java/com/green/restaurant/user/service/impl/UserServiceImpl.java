package com.green.restaurant.user.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.user.dao.UserDao;
import com.green.restaurant.user.service.UserService;
import com.green.restaurant.user.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserVo login(HashMap<String, Object> map) {
		System.out.println("ownerService>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>login() called");
		UserVo userVo = this.userDao.login(map);
		return userVo;
	}

	@Override
	public void signUpUser(HashMap<String, Object> map) {
		System.out.println("service.signUpUser>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
		this.userDao.insertUser(map);
	}
	
}
