package com.green.admin.board.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.admin.board.dao.AdminBoardDao;
import com.green.admin.restaurant.board.vo.AdminUserBoardVo;

@Repository("adminboardDao")
public class AdminBoardDaoImpl implements AdminBoardDao {

	@Autowired
	private  SqlSession   sqlSession;

	@Override
	public List<AdminUserBoardVo> listAll(String searchOption, String keyword) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return sqlSession.selectList("Board.listAll", map);
	}

	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		 
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return sqlSession.selectOne("Board.countArticle", map);
	}

}






