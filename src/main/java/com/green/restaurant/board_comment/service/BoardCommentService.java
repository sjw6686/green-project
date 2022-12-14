package com.green.restaurant.board_comment.service;

import java.util.HashMap;
import java.util.List;

import com.green.restaurant.board_comment.vo.BoardCommentVo;

public interface BoardCommentService {

	void boardInsert(BoardCommentVo boardCommentVo);

	BoardCommentVo getCommentUpdate(int comment_idx);

	void boardCommentUpdate(HashMap<String, Object> map);


	

	



}
