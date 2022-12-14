package com.green.restaurant.user.dao;

import java.util.HashMap;

import com.green.restaurant.user.vo.OwnerUserVo;

public interface UserDao {

	OwnerUserVo login(HashMap<String, Object> map);

	void insertUser(HashMap<String, Object> map);

}
