package com.green.restaurant.mypage.comment.service;

import java.util.List;

import com.green.restaurant.mypage.comment.Vo.MypageCommentVo;

public interface MypageCommentService {

	List<MypageCommentVo> getCommentList(String userId);
	
}
