package com.green.restaurant.mypage.board.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.mypage.board.DAO.MypageBoardDAO;
import com.green.restaurant.mypage.board.Vo.MypageBoardVo;
import com.green.restaurant.mypage.board.service.MypageBoardService;

@Service("MypageService")
public class MypageBoardServiceImpl implements MypageBoardService {
	@Autowired
	private  MypageBoardDAO boardDAO;
	
	@Override
	public List<MypageBoardVo> getBoardList(String userId) {
		List<MypageBoardVo>boardList =  this.boardDAO.getBoardList(userId);
		return boardList;
	}
}
