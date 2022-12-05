package com.green.restaurant.owner.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.owner.dao.OwnerDao;
import com.green.restaurant.owner.vo.OwnerVo;

@Repository("ownerDao")
public class OwnerDaoImpl implements OwnerDao {

	@Autowired
	private SqlSession  sqlSession;
	
	@Override
	public List<OwnerVo> selectOwnerList() {
		List<OwnerVo> ownerList = this.sqlSession.selectList("Owner.OwnerList");
		return ownerList;
	}

	@Override
	public OwnerVo login(HashMap<String, Object> map) {
		System.out.println("ownerDao map>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		OwnerVo ownerVo = this.sqlSession.selectOne("Owner.login", map);
		return ownerVo;
	}

	@Override
	public void ownerInsert(HashMap<String, Object> map) {
		System.out.println("dao>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		this.sqlSession.insert("Owner.OwnerInsert",map);
	}

}
