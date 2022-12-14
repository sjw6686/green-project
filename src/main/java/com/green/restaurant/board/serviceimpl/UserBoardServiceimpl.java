package com.green.restaurant.board.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.board.dao.UserBoardDao;
import com.green.restaurant.board.service.UserBoardService;
import com.green.restaurant.board.vo.UserBoardVo;
import com.green.restaurant.board_comment.vo.UserBoardCommentVo;

@Service("boardService")
public class UserBoardServiceimpl implements UserBoardService {

	@Autowired
	private UserBoardDao  boardDao;
	
	@Override
	public List<UserBoardVo> getBoardList() {
		List<UserBoardVo>  boardList  =  boardDao.getBoardList();
		return boardList;
	}



	@Override
	public UserBoardVo getBoard(HashMap<Integer, Object> map) {
		UserBoardVo boardVo = boardDao.getBoardVo(map); 
		return boardVo;
	}


	@Override
	public void getwritesave(UserBoardVo boardVo) {
		//System.out.println("bService.getwritesave>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>boardVo: " + boardVo);
		this.boardDao.getwritesave(boardVo);
	}

	@Override
	public List<UserBoardCommentVo> getBoardCommentList(HashMap<Integer, Object> map) {
		List<UserBoardCommentVo> BoardCommentList = boardDao.getBoardCommentList(map);
		return BoardCommentList;
	}

	@Override
	public void boardDelete(HashMap<String, Object> map) {
		boardDao.boardDelete( map );
	}

	@Override
	public UserBoardVo getBoard(Map<String, Object> map) {
		UserBoardVo boardVo = boardDao.getBoard(map);
		return boardVo;
	}



	@Override
	public void boardUpdate(HashMap<String, Object> map) {
		boardDao.boardUpdate(map);
		
	}



	@Override
	public UserBoardVo getBoard(int board_idx) {
		System.out.println("boardService.getBoard>>>>>>>>>>>>>>>>>>>>board_idx:" + board_idx);
		UserBoardVo boardVo  = boardDao.getBoard(board_idx);
		System.out.println("boardService.getBoard>>>>>>>>>>>>>>>>>>>>boardVo:" + boardVo.toString());
		return boardVo;
	}



		
}




