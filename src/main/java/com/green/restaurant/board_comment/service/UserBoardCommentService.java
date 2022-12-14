package com.green.restaurant.board_comment.service;

import java.util.HashMap;
import java.util.List;

import com.green.restaurant.board_comment.vo.UserBoardCommentVo;

public interface UserBoardCommentService {

	void boardInsert(UserBoardCommentVo boardCommentVo);

	UserBoardCommentVo getCommentUpdate(int comment_idx);

	void boardCommentUpdate(HashMap<String, Object> map);


	

	



}
