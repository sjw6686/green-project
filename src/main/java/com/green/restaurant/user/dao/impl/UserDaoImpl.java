package com.green.restaurant.user.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.user.dao.UserDao;
import com.green.restaurant.user.vo.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession  sqlSession;
	
	@Override
	public List<UserVo> getUserList() {
		List<UserVo>  userList  =  sqlSession.selectList("User.UserList");
		return userList;
	}

}
