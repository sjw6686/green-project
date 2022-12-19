package com.green.admin.review.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.admin.review.dao.AdminReviewDao;
import com.green.admin.review.service.AdminReviewService;
import com.green.admin.review.vo.AdminReviewVo;

@Service("adminreviewService")
public class AdminReviewServiceImpl implements AdminReviewService {
	
	@Autowired
	private AdminReviewDao reviewDao;

	@Override
	public List<AdminReviewVo> SelectComment() {
		
		List<AdminReviewVo> reviewList = reviewDao.SelectComment();
		return reviewList;
	}

	@Override
	public void DeleteReview(String review_comment) {
		
		reviewDao.DeleteReview(review_comment);
		
	}

	@Override
	public List<AdminReviewVo> reviewMap() {
		
		List<AdminReviewVo> reviewMap = reviewDao.reviewMap();
		
		return reviewMap;
	}

	@Override
	public List<AdminReviewVo> reviewSearch(String searchOption, String keyword) throws Exception {
		
		return reviewDao.reviewSearch(searchOption, keyword);
	}

}
