package com.green.restaurant.mypage.comment.DAOImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.mypage.comment.DAO.MypageCommentDAO;
import com.green.restaurant.mypage.comment.Vo.MypageCommentVo;
@Repository("CommentDAO")
public class MypageCommentDAOImpl implements MypageCommentDAO{

	@Autowired
	private  SqlSession   sqlSession;


	@Override
	public List<MypageCommentVo> getCommentList(String userId) {
		List<MypageCommentVo> commentList = this.sqlSession.selectList("Comment.CommentList", userId);
		return commentList;
	}
}