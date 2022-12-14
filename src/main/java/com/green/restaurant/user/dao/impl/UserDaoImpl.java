package com.green.restaurant.user.dao.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.user.dao.UserDao;
import com.green.restaurant.user.vo.OwnerUserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession  sqlSession;

	@Override
	public OwnerUserVo login(HashMap<String, Object> map) {
		System.out.println("userDao.login>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		OwnerUserVo userVo = this.sqlSession.selectOne("User.login", map);
		System.out.println("userDao.login>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>user_role: " + userVo.getUserRole());
		if(userVo.getUserRole().equals("OWNER")) {
			map.put("userRole", userVo.getUserRole());
			userVo = this.sqlSession.selectOne("User.loginAuth", map);
		}
		return userVo;
	}

	@Override
	public void insertUser(HashMap<String, Object> map) {
		System.out.println("uDao.insertUser>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
		this.sqlSession.insert("User.SignUp", map);
	}
}
