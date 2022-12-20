package com.green.restaurant.mypage.board.DAO;

import java.util.List;

import com.green.restaurant.mypage.board.Vo.MypageBoardVo;

public interface MypageBoardDAO {

	List<MypageBoardVo> getBoardList(String userId);
}
