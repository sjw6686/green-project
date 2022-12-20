	package com.green.admin.user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.admin.user.dao.AdminUserDao;
import com.green.admin.user.vo.AdminUserVo;

@Repository("adminuserDao")
public class AdminUserDaoImpl implements AdminUserDao {
	
	@Autowired
	private SqlSession  sqlSession;
	
	private static String namespace = "com.green.admin.user.dao";

	@Override
	public List<AdminUserVo> getUserList() {
		
		List<AdminUserVo>  userList  =  sqlSession.selectList("AdminUser.UserList");
		return  userList;
		
	}

	@Override
	public AdminUserVo getView(String id) {
		AdminUserVo  vo  = sqlSession.selectOne("AdminUser.getView", id);
		return  vo;
	}

	@Override
	public List<AdminUserVo> getViewName(String name) {
		
		List<AdminUserVo>  userList  =  sqlSession.selectList("AdminUser.getViewName", name);
		
		return     userList;
	}

	@Override
	public AdminUserVo login(HashMap<String, Object> map) {
		
		AdminUserVo  vo  =  sqlSession.selectOne("AdminUser.login", map); 
		
		System.out.println("userdao map:" + map);
		
		return  vo;
	}

	@Override
	public void deleteUser(String userid) {
		
		sqlSession.delete("AdminUser.DeleteUser", userid);
		
	}

	@Override
	public List<AdminUserVo> UserListSearch(String searchType, String keyword) throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		  
		  data.put("searchType", searchType);
		  data.put("keyword", keyword);
		  
		  System.out.println("dao.listSearch>>>>>>>>>>>>>>>>>>>>>>searchType: " + searchType);
		  System.out.println("dao.listSearch>>>>>>>>>>>>>>>>>>>>>>keyword: " + keyword);
		  
		  return sqlSession.selectList("AdminUser.UserListSearch", data);
		  
	}

	@Override
	public List<AdminUserVo> listAll(String searchOption, String keyword) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		System.out.println("map"+ map);
		
		return sqlSession.selectList("AdminUser.listAll", map);
	}

	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return sqlSession.selectOne("AdminUser.countArticle", map);
	}



}





