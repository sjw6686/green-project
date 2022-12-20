package com.green.restaurant.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.green.restaurant.board.vo.UserBoardVo;
import com.green.restaurant.board_comment.vo.UserBoardCommentVo;

public interface UserBoardService {

	List<UserBoardVo> getBoardList();

	UserBoardVo getBoard(Map<String,Object> map);

	void getwritesave(@RequestParam HashMap<Integer, Object> map);

	void boardDelete(HashMap<String, Object> map);

	List<UserBoardCommentVo> getBoardCommentList(HashMap<Integer, Object> map);

	UserBoardVo getBoard(HashMap<Integer, Object> map);

	void boardUpdate(HashMap<String, Object> map);

	UserBoardVo getBoard(int board_idx);



	



}
