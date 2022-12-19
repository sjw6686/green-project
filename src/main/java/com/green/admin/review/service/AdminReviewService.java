package com.green.admin.review.service;

import java.util.List;

import com.green.admin.review.vo.AdminReviewVo;

public interface AdminReviewService {
	
	List<AdminReviewVo> SelectComment();
	
	void DeleteReview(String review_comment);
	
	List<AdminReviewVo> reviewMap();
	
	List<AdminReviewVo> reviewSearch(String searchOption, String keyword) throws Exception;
}
