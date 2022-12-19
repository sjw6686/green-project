package com.green.admin.board.service;

import java.util.List;

import com.green.admin.restaurant.board.vo.AdminUserBoardVo;

public interface AdminBoardService {
	
	List<AdminUserBoardVo> listAll(String searchOption, String keyword) throws Exception;
	
	int countArticle(String searchOption, String keyword) throws Exception;
}
