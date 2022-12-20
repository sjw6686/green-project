package com.green.restaurant.mypage.comment.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.mypage.comment.DAO.MypageCommentDAO;
import com.green.restaurant.mypage.comment.Vo.MypageCommentVo;
import com.green.restaurant.mypage.comment.service.MypageCommentService;

@Service("CommentService")
public class MypageCommentServiceImpl implements MypageCommentService{

	@Autowired
	private  MypageCommentDAO commentDAO;
	
	@Override
	public List<MypageCommentVo> getCommentList(String userId) {
		List<MypageCommentVo>commentList =  this.commentDAO.getCommentList(userId);
		return commentList;
	}
}
