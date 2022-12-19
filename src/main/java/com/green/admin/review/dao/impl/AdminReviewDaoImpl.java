package com.green.admin.review.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.admin.review.dao.AdminReviewDao;
import com.green.admin.review.vo.AdminReviewVo;

@Repository("adminreviewDao")
public class AdminReviewDaoImpl implements AdminReviewDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<AdminReviewVo> SelectComment() {
		
		List<AdminReviewVo> ReviewList = sqlSession.selectList("AdminReview.SelectComment");
		return ReviewList;
	}

	@Override
	public void DeleteReview(String review_comment) {
		
		sqlSession.delete("AdminReview.DeleteReview", review_comment);
		
	}

	@Override
	public List<AdminReviewVo> reviewMap() {
		
		List<AdminReviewVo> reviewMap = sqlSession.selectList("AdminReview.reviewMap");
		
		return reviewMap;
	}

	@Override
	public List<AdminReviewVo> reviewSearch(String searchOption, String keyword) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return sqlSession.selectList("AdminReview.reviewSearch", map);
	}

}
