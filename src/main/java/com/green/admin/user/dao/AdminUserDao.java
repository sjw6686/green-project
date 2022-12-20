package com.green.admin.user.dao;

import java.util.HashMap;
import java.util.List;

import com.green.admin.restaurant.board.vo.AdminUserBoardVo;
import com.green.admin.user.vo.AdminUserVo;

public interface AdminUserDao {

	List<AdminUserVo> getUserList();

	AdminUserVo getView(String id);
	
	List<AdminUserVo> getViewName(String name);

	AdminUserVo login(HashMap<String, Object> map);
	
	void deleteUser(String userid);
	
	List<AdminUserVo> UserListSearch(String searchType, String keyword) throws Exception;
	
	List<AdminUserVo> listAll(String searchOption, String keyword) throws Exception;
	
	int countArticle(String searchOption, String keyword) throws Exception;
}
