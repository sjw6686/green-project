package com.green.restaurant.mypage.board.DAOImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.mypage.board.DAO.MypageBoardDAO;
import com.green.restaurant.mypage.board.Vo.MypageBoardVo;

@Repository("MypageDAO")
public class MypageBoardDAOImpl implements MypageBoardDAO {
	@Autowired
	private  SqlSession   sqlSession;

	@Override
	public List<MypageBoardVo> getBoardList(String userId) {
		List<MypageBoardVo> boardList = this.sqlSession.selectList("Board.BoardList", userId);
		return boardList;
	}
}
