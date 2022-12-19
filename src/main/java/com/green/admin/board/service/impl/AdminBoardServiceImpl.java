package com.green.admin.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.admin.board.dao.AdminBoardDao;
import com.green.admin.board.service.AdminBoardService;
import com.green.admin.restaurant.board.vo.AdminUserBoardVo;

@Service("adminboardService")
public class AdminBoardServiceImpl implements AdminBoardService {

	@Autowired
	private  AdminBoardDao   boardDao;

	@Override
	public List<AdminUserBoardVo> listAll(String searchOption, String keyword) throws Exception {
		
		return boardDao.listAll(searchOption, keyword);
	}

	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		
		return boardDao.countArticle(searchOption, keyword);
	}

}






