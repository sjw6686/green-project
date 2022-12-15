package com.green.restaurant.board_comment.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.restaurant.board_comment.service.BoardBoardCommentService;
import com.green.restaurant.board_comment.vo.BoardBoardCommentVo;

@Controller
@RequestMapping("/BoardComment")
public class BoardBoardCommentController {
	
	
	@Autowired
	private BoardBoardCommentService boardCommentService;
	
	@RequestMapping("/Write")
	public  ModelAndView  write(  BoardBoardCommentVo boardCommentVo ) {
		// 새글 저장/ 답글 저장
		boardCommentService.boardInsert ( boardCommentVo );
		
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("redirect:/Board/View?board_idx=" + boardCommentVo.getBoard_idx());
		return  mv;
	}
	
	@RequestMapping("/CommentUpdateForm")
	public ModelAndView UpdateForm(@RequestParam HashMap<String, Object> map) {
		BoardBoardCommentVo boardCommentVo = this.boardCommentService.getCommentUpdate(map);
		System.out.println("commentupdate>>>>>>>>>>>>>>>>>>>>>>>>map.board_idx: " + map.get("board_idx"));
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardCommentVo", boardCommentVo);
		mv.addObject("board_idx", map.get("board_idx"));
		mv.setViewName("board/commentupdate");
		return mv;
	}
	
	@RequestMapping("/CommentUpdate")
	public ModelAndView commentupdate(@RequestParam HashMap<String, Object> map) {
		
		System.out.println("commentupdate>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		boardCommentService.boardCommentUpdate(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Board/View?board_idx=" + map.get("board_idx"));
		return mv;
		
		
	}
}
