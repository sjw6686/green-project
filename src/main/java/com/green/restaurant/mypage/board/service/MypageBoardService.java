package com.green.restaurant.mypage.board.service;

import java.util.List;

import com.green.restaurant.mypage.board.Vo.MypageBoardVo;

public interface MypageBoardService {

	List<MypageBoardVo> getBoardList(String userId);

}
