package com.green.restaurant.board_comment.serviceimpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.board_comment.dao.UserBoardCommentDao;
import com.green.restaurant.board_comment.service.UserBoardCommentService;
import com.green.restaurant.board_comment.vo.UserBoardCommentVo;

@Service("boardCommentService")
public class UserBoardCommentServiceimpl implements UserBoardCommentService{
	
	@Autowired
	private UserBoardCommentDao boardCommentDao;
	
	@Override
	public void boardInsert(UserBoardCommentVo boardCommentVo) {
		
		boardCommentDao.boardInsert(boardCommentVo);
	
	}

	@Override
	public UserBoardCommentVo getCommentUpdate(int comment_idx) {
		UserBoardCommentVo boardCommentVo = boardCommentDao.getCommentUpdate(comment_idx);
		return boardCommentVo;
	}

	@Override
	public void boardCommentUpdate(HashMap<String, Object> map) {
		
		boardCommentDao.boardCommentUpdate(map);
		
	}

	@Override
	public void writeComment(HashMap<String, Object> map) {
		System.out.println("BoardService.writeComment>>>>>>>>>>>>>>>>>>>map: " + map);
		this.boardCommentDao.insertComment(map);
	}
	

}
