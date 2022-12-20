package com.green.restaurant.mypage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.green.restaurant.mypage.board.Vo.MypageBoardVo;
import com.green.restaurant.mypage.board.service.MypageBoardService;
import com.green.restaurant.mypage.comment.Vo.MypageCommentVo;
import com.green.restaurant.mypage.comment.service.MypageCommentService;
import com.green.restaurant.mypage.review.Vo.MypageReviewVo;
import com.green.restaurant.mypage.review.service.MypageReviewService;
import com.green.restaurant.user.vo.OwnerUserVo;

@Controller
public class MypageController {
	@Autowired
	private MypageCommentService commentService;
	@Autowired
	private MypageReviewService reviewService;
	@Autowired
	private MypageBoardService boardService;
	
	@RequestMapping("/mypage")
	public String home() {
		return "/mypage/mypage";
	}
	
	@RequestMapping("/restaurant/mypage/comment")
	public ModelAndView commentList(
			@SessionAttribute("login") OwnerUserVo userVo
			) {
	
	List<MypageCommentVo> commentList = this.commentService.getCommentList(userVo.getUserId());
	ModelAndView  mr  = new ModelAndView();
	mr.addObject("commentList", commentList);
	mr.setViewName("/mypage/commentList");
	return mr;
	}
	
	@RequestMapping("/restaurant/mypage/reviewList")
	public ModelAndView reviewList(
			@SessionAttribute("login") OwnerUserVo userVo
			) {
	List<MypageReviewVo> reviewList = this.reviewService.getReviewList(userVo.getUserId());
	ModelAndView  mv  = new ModelAndView();
	mv.addObject("reviewList", reviewList);
	mv.setViewName("/mypage/reviewList");
	
	System.out.println("mv" + mv );
	
	return mv;
	}
	
	@RequestMapping("/restaurant/mypage/board")
	public ModelAndView boardList(
			@SessionAttribute("login") OwnerUserVo userVo) {
	List<MypageBoardVo> boardList = this.boardService.getBoardList(userVo.getUserId());
	ModelAndView  mb  = new ModelAndView();
	mb.addObject("boardList", boardList);
	mb.setViewName("mypage/boardList");
	
	System.out.println("mb" + mb );
	
	return mb;
	}
	
}
