package com.green.restaurant.owner.dao;

import java.util.HashMap;
import java.util.List;

import com.green.restaurant.owner.vo.OwnerVo;

public interface OwnerDao {

	List<OwnerVo> selectOwnerList();

	OwnerVo login(HashMap<String, Object> map);

	void ownerInsert(HashMap<String, Object> map);

}
