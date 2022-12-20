package com.green.restaurant.mypage.review.DAO;

import java.util.List;

import com.green.restaurant.mypage.review.Vo.MypageReviewVo;

public interface MypageReviewDAO {
	
	List<MypageReviewVo> getReviewList(String userId);
}
