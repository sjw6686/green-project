package com.green.restaurant.board_comment.serviceimpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.restaurant.board_comment.dao.BoardBoardCommentDao;
import com.green.restaurant.board_comment.service.BoardBoardCommentService;
import com.green.restaurant.board_comment.vo.BoardBoardCommentVo;

@Service("boardCommentService")
public class BoardBoardCommentServiceimpl implements BoardBoardCommentService{
	
	@Autowired
	private BoardBoardCommentDao boardCommentDao;
	
	@Override
	public void boardInsert(BoardBoardCommentVo boardCommentVo) {
		
		boardCommentDao.boardInsert(boardCommentVo);
	
	}

	@Override
	public BoardBoardCommentVo getCommentUpdate(@RequestParam HashMap<String, Object> map) {
		BoardBoardCommentVo boardCommentVo = boardCommentDao.getCommentUpdate(map);
		return boardCommentVo;
	}

	@Override
	public void boardCommentUpdate(HashMap<String, Object> map) {
		System.out.println("boardService.boardCommentUpdate>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		boardCommentDao.boardCommentUpdate(map);
		
	}
	

}
