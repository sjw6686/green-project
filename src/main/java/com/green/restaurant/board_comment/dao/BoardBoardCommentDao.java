package com.green.restaurant.board_comment.dao;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestParam;

import com.green.restaurant.board_comment.vo.BoardBoardCommentVo;

public interface BoardBoardCommentDao {

	void boardInsert(BoardBoardCommentVo boardCommentVo);

	BoardBoardCommentVo getCommentUpdate(@RequestParam HashMap<String, Object> map);

	void boardCommentUpdate(HashMap<String, Object> map);




}
