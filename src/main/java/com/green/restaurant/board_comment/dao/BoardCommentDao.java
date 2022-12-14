package com.green.restaurant.board_comment.dao;

import java.util.HashMap;

import com.green.restaurant.board_comment.vo.BoardCommentVo;

public interface BoardCommentDao {

	void boardInsert(BoardCommentVo boardCommentVo);

	BoardCommentVo getCommentUpdate(int comment_idx);

	void boardCommentUpdate(HashMap<String, Object> map);




}
