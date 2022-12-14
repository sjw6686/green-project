package com.green.restaurant.board_comment.serviceimpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.board_comment.dao.BoardCommentDao;
import com.green.restaurant.board_comment.service.BoardCommentService;
import com.green.restaurant.board_comment.vo.BoardCommentVo;

@Service("boardCommentService")
public class BoardCommentServiceimpl implements BoardCommentService{
	
	@Autowired
	private BoardCommentDao boardCommentDao;
	
	@Override
	public void boardInsert(BoardCommentVo boardCommentVo) {
		
		boardCommentDao.boardInsert(boardCommentVo);
	
	}

	@Override
	public BoardCommentVo getCommentUpdate(int comment_idx) {
		BoardCommentVo boardCommentVo = boardCommentDao.getCommentUpdate(comment_idx);
		return boardCommentVo;
	}

	@Override
	public void boardCommentUpdate(HashMap<String, Object> map) {
		
		boardCommentDao.boardCommentUpdate(map);
		
	}
	

}
