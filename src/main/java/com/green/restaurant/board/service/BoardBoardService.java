package com.green.restaurant.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.green.restaurant.board.vo.BoardBoardVo;
import com.green.restaurant.board_comment.vo.BoardBoardCommentVo;

public interface BoardBoardService {

	List<BoardBoardVo> getBoardList();

	BoardBoardVo getBoard(Map<String,Object> map);

	void getwritesave(BoardBoardVo boardVo);

	void boardDelete(HashMap<String, Object> map);

	List<BoardBoardCommentVo> getBoardCommentList(HashMap<Integer, Object> map);

	BoardBoardVo getBoard(HashMap<Integer, Object> map);

	void boardUpdate(HashMap<String, Object> map);

	BoardBoardVo getBoard(int board_idx);



	



}
