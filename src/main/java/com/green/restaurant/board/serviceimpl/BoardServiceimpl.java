package com.green.restaurant.board.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.board.dao.BoardDao;
import com.green.restaurant.board.service.BoardService;
import com.green.restaurant.board.vo.BoardVo;
import com.green.restaurant.board_comment.vo.BoardCommentVo;

@Service("boardService")
public class BoardServiceimpl implements BoardService {

	@Autowired
	private BoardDao  boardDao;
	
	@Override
	public List<BoardVo> getBoardList() {
		List<BoardVo>  boardList  =  boardDao.getBoardList();
		return boardList;
	}



	@Override
	public BoardVo getBoard(HashMap<Integer, Object> map) {
		BoardVo boardVo = boardDao.getBoardVo(map); 
		return boardVo;
	}


	@Override
	public void getwritesave(BoardVo boardVo) {
		//System.out.println("bService.getwritesave>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>boardVo: " + boardVo);
		this.boardDao.getwritesave(boardVo);
	}

	@Override
	public List<BoardCommentVo> getBoardCommentList(HashMap<Integer, Object> map) {
		List<BoardCommentVo> BoardCommentList = boardDao.getBoardCommentList(map);
		return BoardCommentList;
	}

	@Override
	public void boardDelete(HashMap<String, Object> map) {
		boardDao.boardDelete( map );
	}

	@Override
	public BoardVo getBoard(Map<String, Object> map) {
		BoardVo boardVo = boardDao.getBoard(map);
		return boardVo;
	}



	@Override
	public void boardUpdate(HashMap<String, Object> map) {
		boardDao.boardUpdate(map);
		
	}



	@Override
	public BoardVo getBoard(int board_idx) {
		System.out.println("boardService.getBoard>>>>>>>>>>>>>>>>>>>>board_idx:" + board_idx);
		BoardVo boardVo  = boardDao.getBoard(board_idx);
		System.out.println("boardService.getBoard>>>>>>>>>>>>>>>>>>>>boardVo:" + boardVo.toString());
		return boardVo;
	}



		
}




