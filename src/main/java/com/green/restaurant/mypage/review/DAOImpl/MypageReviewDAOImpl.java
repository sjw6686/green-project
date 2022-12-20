package com.green.restaurant.mypage.review.DAOImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.mypage.review.DAO.MypageReviewDAO;
import com.green.restaurant.mypage.review.Vo.MypageReviewVo;
@Repository("ReviewDAO")
public class MypageReviewDAOImpl implements MypageReviewDAO{
		@Autowired
		private  SqlSession   sqlSession;

		@Override
		public List<MypageReviewVo> getReviewList(String userId) {
			List<MypageReviewVo> reviewList = this.sqlSession.selectList("Review.ReviewList", userId);
			return reviewList;
		}
}
