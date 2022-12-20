package com.green.restaurant.mypage.review.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.mypage.review.DAO.MypageReviewDAO;
import com.green.restaurant.mypage.review.Vo.MypageReviewVo;
import com.green.restaurant.mypage.review.service.MypageReviewService;

@Service("ReviewService")
public class MypageReviewServiceImpl implements MypageReviewService{

	@Autowired
	private  MypageReviewDAO reviewDAO;
	
	@Override
	public List<MypageReviewVo> getReviewList(String userId) {
		List<MypageReviewVo>reviewList =  this.reviewDAO.getReviewList(userId);
		return reviewList;
	}
}
