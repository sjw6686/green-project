package com.green.restaurant.board_comment.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.restaurant.board_comment.service.BoardCommentService;
import com.green.restaurant.board_comment.vo.BoardCommentVo;

@Controller
@RequestMapping("/BoardComment")
public class BoardCommentController {
	
	
	@Autowired
	private BoardCommentService boardCommentService;
	
	@RequestMapping("/Write")
	public  ModelAndView  write(  BoardCommentVo boardCommentVo ) {
		// 새글 저장/ 답글 저장
		boardCommentService.boardInsert ( boardCommentVo );
		
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("redirect:/Board/View?board_idx=" + boardCommentVo.getBoard_idx());
		return  mv;
	}
	
	@RequestMapping("/CommentUpdateForm")
	public ModelAndView UpdateForm(int comment_idx) {
		BoardCommentVo boardCommentVo = this.boardCommentService.getCommentUpdate(comment_idx);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardCommentVo", boardCommentVo);
		mv.setViewName("board/commentupdate");
		return mv;
	}
	
	@RequestMapping("/CommentUpdate")
	public ModelAndView commentupdate(@RequestParam HashMap<String, Object> map) {
		
		boardCommentService.boardCommentUpdate(map);
		
		String comment_idx = (String) map.get("comment_idx");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Board/View?board_idx=" + comment_idx);
		return mv;
		
		
	}
}
