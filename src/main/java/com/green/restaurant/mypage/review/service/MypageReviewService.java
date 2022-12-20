package com.green.restaurant.mypage.review.service;

import java.util.List;

import com.green.restaurant.mypage.review.Vo.MypageReviewVo;

public interface MypageReviewService {
	List<MypageReviewVo> getReviewList(String userId);
}
