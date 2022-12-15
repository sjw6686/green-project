package com.green.restaurant.board.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.board.dao.BoardBoardDao;
import com.green.restaurant.board.service.BoardBoardService;
import com.green.restaurant.board.vo.BoardBoardVo;
import com.green.restaurant.board_comment.vo.BoardBoardCommentVo;

@Service("boardService")
public class BoardBoardServiceimpl implements BoardBoardService {

	@Autowired
	private BoardBoardDao  boardDao;
	
	@Override
	public List<BoardBoardVo> getBoardList() {
		List<BoardBoardVo>  boardList  =  boardDao.getBoardList();
		return boardList;
	}



	@Override
	public BoardBoardVo getBoard(HashMap<Integer, Object> map) {
		BoardBoardVo boardVo = boardDao.getBoardVo(map); 
		return boardVo;
	}


	@Override
	public void getwritesave(BoardBoardVo boardVo) {
		//System.out.println("bService.getwritesave>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>boardVo: " + boardVo);
		this.boardDao.getwritesave(boardVo);
	}

	@Override
	public List<BoardBoardCommentVo> getBoardCommentList(HashMap<Integer, Object> map) {
		List<BoardBoardCommentVo> BoardCommentList = boardDao.getBoardCommentList(map);
		return BoardCommentList;
	}

	@Override
	public void boardDelete(HashMap<String, Object> map) {
		boardDao.boardDelete( map );
	}

	@Override
	public BoardBoardVo getBoard(Map<String, Object> map) {
		BoardBoardVo boardVo = boardDao.getBoard(map);
		return boardVo;
	}



	@Override
	public void boardUpdate(HashMap<String, Object> map) {
		boardDao.boardUpdate(map);
		
	}



	@Override
	public BoardBoardVo getBoard(int board_idx) {
		System.out.println("boardService.getBoard>>>>>>>>>>>>>>>>>>>>board_idx:" + board_idx);
		BoardBoardVo boardVo  = boardDao.getBoard(board_idx);
		System.out.println("boardService.getBoard>>>>>>>>>>>>>>>>>>>>boardVo:" + boardVo.toString());
		return boardVo;
	}



		
}




