package com.green.restaurant.user.dao;

import java.util.HashMap;

import com.green.restaurant.user.vo.UserVo;

public interface UserDao {

	UserVo login(HashMap<String, Object> map);

	void insertUser(HashMap<String, Object> map);

}
