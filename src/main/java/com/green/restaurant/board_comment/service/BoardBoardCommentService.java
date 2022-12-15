package com.green.restaurant.board_comment.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.green.restaurant.board_comment.vo.BoardBoardCommentVo;

public interface BoardBoardCommentService {

	void boardInsert(BoardBoardCommentVo boardCommentVo);

	BoardBoardCommentVo getCommentUpdate(@RequestParam HashMap<String, Object> map);

	void boardCommentUpdate(HashMap<String, Object> map);


	

	



}
