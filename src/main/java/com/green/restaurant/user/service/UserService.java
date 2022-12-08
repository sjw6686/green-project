package com.green.restaurant.user.service;

import java.util.HashMap;

import com.green.restaurant.user.vo.UserVo;

public interface UserService {

	UserVo login(HashMap<String, Object> map);

	void signUpUser(HashMap<String, Object> map);

}
