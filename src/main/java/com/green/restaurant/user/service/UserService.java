package com.green.restaurant.user.service;

import java.util.HashMap;

import com.green.restaurant.user.vo.OwnerUserVo;

public interface UserService {

	OwnerUserVo login(HashMap<String, Object> map);

	void signUpUser(HashMap<String, Object> map);

}
