package com.green.admin.user.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.admin.user.dao.AdminUserDao;
import com.green.admin.user.service.AdminUserService;
import com.green.admin.user.vo.AdminUserVo;

@Service("adminuserService")
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private  AdminUserDao  userDao;
	
	@Override
	public List<AdminUserVo> getUserList() {
		
		List<AdminUserVo> userList =  userDao.getUserList();
		return    userList;
		
	}

	@Override
	public AdminUserVo getView(String id) {
		AdminUserVo  vo  =  userDao.getView( id ); 
		return  vo;
	}

	@Override
	public List<AdminUserVo> getViewName(String name) {
		
		List<AdminUserVo> userList = userDao.getViewName( name );
		return       userList;
		
	}

	@Override
	public AdminUserVo login(HashMap<String, Object> map) {
		AdminUserVo    vo   =   userDao.login( map ); 
		return    vo;
	}

	@Override
	public void deleteUser(String userid) {
		
		userDao.deleteUser(userid);
		
	}

	@Override
	public List<AdminUserVo> UserListSearch(String searchType, String keyword) throws Exception {
		System.out.println("service.listSearch>>>>>>>>>>>>>>>>>>>>>>searchType: " + searchType);
		System.out.println("service.listSearch>>>>>>>>>>>>>>>>>>>>>>keyword: " + keyword);
		return userDao.UserListSearch(searchType, keyword);
	}	


}





