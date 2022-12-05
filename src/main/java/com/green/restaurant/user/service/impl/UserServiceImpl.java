package com.green.restaurant.user.service.impl;

import java.util.List;

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
	public List<UserVo> getUserList() {
		List<UserVo> userList = this.userDao.getUserList();
		return userList;
	}
	
}
