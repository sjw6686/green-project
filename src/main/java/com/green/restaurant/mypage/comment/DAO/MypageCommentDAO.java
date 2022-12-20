package com.green.restaurant.mypage.comment.DAO;

import java.util.List;

import com.green.restaurant.mypage.comment.Vo.MypageCommentVo;

public interface MypageCommentDAO {

	List<MypageCommentVo> getCommentList(String userId);

}
