package com.green.restaurant.owner.service;

import java.util.HashMap;
import java.util.List;

import com.green.restaurant.owner.vo.OwnerVo;

public interface OwnerService {

	List<OwnerVo> getOwnerList();

	OwnerVo login(HashMap<String, Object> map);

	void ownerSignUp(HashMap<String, Object> map);

}
