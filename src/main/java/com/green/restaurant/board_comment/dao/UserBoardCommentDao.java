package com.green.restaurant.board_comment.dao;

import java.util.HashMap;

import com.green.restaurant.board_comment.vo.UserBoardCommentVo;

public interface UserBoardCommentDao {

	void boardInsert(UserBoardCommentVo boardCommentVo);

	UserBoardCommentVo getCommentUpdate(int comment_idx);

	void boardCommentUpdate(HashMap<String, Object> map);




}
