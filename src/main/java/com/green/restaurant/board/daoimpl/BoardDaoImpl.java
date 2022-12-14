package com.green.restaurant.board.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.board.dao.BoardDao;
import com.green.restaurant.board.vo.BoardVo;
import com.green.restaurant.board_comment.vo.BoardCommentVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVo> getBoardList() {
		List<BoardVo> boardList = sqlSession.selectList("Board.GetBoardList");	
		return boardList;
	}


	@Override
	public BoardVo getBoardVo(HashMap<Integer, Object> map) {
		System.out.println("boardDao.getBoardVo>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
		sqlSession.update("Board.ReadCountUpdate", map );
		BoardVo BoardVo = sqlSession.selectOne("Board.GetBoardVo", map);
		return BoardVo;
	}


	@Override
	public void getwritesave(BoardVo boardVo) {
		//System.out.println("bDao.getwritesave>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>boardVo: " + boardVo);
		this.sqlSession.insert("Board.getwriesave", boardVo);
	}

	@Override
	public List<BoardCommentVo> getBoardCommentList(HashMap<Integer, Object> map) {
		System.out.println("boadDao.getBoardCommentList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
		List<BoardCommentVo> commentList = this.sqlSession.selectList("Board.GetCommentList", map);
		System.out.println("boadDao.getBoardCommentList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>commentList: " + commentList.toString());
		return commentList;
	}


	@Override
	public void boardDelete(HashMap<String, Object> map) {
		sqlSession.delete("Board.BoardDelete", map );
	}


	@Override
	public BoardVo getBoard(Map<String, Object> map) {
		
		BoardVo boardVo = sqlSession.selectOne("Board.BoardUpdate",map);
		return boardVo;
	}


	@Override
	public void boardUpdate(HashMap<String, Object> map) {
		System.out.println("BoardDaoImpl.boardUpdate>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		sqlSession.update("Board.BoardUpdate",map);
		
	}


	@Override
	public BoardVo getBoard(int board_idx) {
		System.out.println("boardDao.getBoard>>>>>>>>>>>>>>>>>>>>board_idx:" + board_idx);
		BoardVo boardVo = sqlSession.selectOne("Board.GetBoardVo" , board_idx);
		System.out.println("boardDao.getBoard>>>>>>>>>>>>>>>>>>>>boardVo:" + boardVo.toString());
		return boardVo;
	}







	/*@Override
	public BoardVo getBoard(HashMap<String, Object> map) {
		// 조회수 증가
		sqlSession.update("Board.ReadCountUpdate", map );
		System.out.println("boardDao.getBoard>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
		// idx 로 게시물 조회
		BoardVo  boardVo = sqlSession.selectOne("Board.Board", map); 
		//map.put("totCnt", 12345);
		return   boardVo;
		
	}*/


}
