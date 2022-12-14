package com.green.restaurant.board_comment.daoimpl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.board_comment.dao.BoardCommentDao;
import com.green.restaurant.board_comment.vo.BoardCommentVo;

@Repository("boardCommentDao")
public class BoardCommentDaoimpl implements BoardCommentDao{
	
	@Autowired
	private  SqlSession sqlSession;
	
	@Override
	public void boardInsert(BoardCommentVo boardCommentVo) {
		System.out.println(boardCommentVo);
		int cnum = boardCommentVo.getCnum();  
		if(cnum == 0) { // 새글쓰기
			sqlSession.insert("Board.BoardInsert", boardCommentVo);
		} else {        // 답글 쓰기
			sqlSession.update("Board.UpdateRef",   boardCommentVo);
			sqlSession.insert("Board.BoardReply",  boardCommentVo);
		}
		
	}

	@Override
	public BoardCommentVo getCommentUpdate(int comment_idx) {
		System.out.println("boardCommentDao.getCommentUpdate>>>>>>>>>>>>>>>>>>>>board_idx:" + comment_idx);
		BoardCommentVo boardCommentVo = sqlSession.selectOne("Board.GetCommentUpdate" , comment_idx);
		System.out.println("boardCommentDao.getCommentUpdate>>>>>>>>>>>>>>>>>>>>boardCommentVo:" + boardCommentVo.toString());
		return boardCommentVo;
	}

	@Override
	public void boardCommentUpdate(HashMap<String, Object> map) {
		System.out.println("boardCommentDao.boardCommentUpdate>>>>>>>>>>>>>>>>>>>>map:" + map);
		sqlSession.update("Board.BoardCommentUpdate",map);
		System.out.println("boardCommentDao.boardCommentUpdate>>>>>>>>>>>>>>>>>>>>update:" + map);
	}
	
	
	
	
}
