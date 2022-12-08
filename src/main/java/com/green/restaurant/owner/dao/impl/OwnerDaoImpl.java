package com.green.restaurant.owner.dao.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.owner.dao.OwnerDao;

@Repository("ownerDao")
public class OwnerDaoImpl implements OwnerDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertRestaurant(HashMap<String, Object> map) {
		System.out.println("ownerDao.insertRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		this.sqlSession.insert("Owner.EnrollRestaurant", map);
	}
}
