package com.green.restaurant.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.green.restaurant.board.vo.BoardVo;
import com.green.restaurant.board_comment.vo.BoardCommentVo;

public interface BoardDao {

	List<BoardVo> getBoardList();

	BoardVo getBoardVo(HashMap<Integer, Object> map);

	void getwritesave(BoardVo boardVo);

	void boardDelete(HashMap<String, Object> map);

	List<BoardCommentVo> getBoardCommentList(HashMap<Integer, Object> map);

	BoardVo getBoard(Map<String, Object> map);

	void boardUpdate(HashMap<String, Object> map);

	BoardVo getBoard(int board_idx);





}
