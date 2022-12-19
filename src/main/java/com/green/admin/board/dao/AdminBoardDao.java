package com.green.admin.board.dao;

import java.util.List;

import com.green.admin.restaurant.board.vo.AdminUserBoardVo;

public interface AdminBoardDao {
	
	List<AdminUserBoardVo> listAll(String searchOption, String keyword) throws Exception;
	
	int countArticle(String searchOption, String keyword) throws Exception;
}
