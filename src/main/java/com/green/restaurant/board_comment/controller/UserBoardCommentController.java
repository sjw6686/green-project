package com.green.restaurant.board_comment.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.restaurant.board_comment.service.UserBoardCommentService;
import com.green.restaurant.board_comment.vo.UserBoardCommentVo;
import com.green.restaurant.user.vo.OwnerUserVo;

@Controller
@RequestMapping("/restaurant/BoardComment")
public class UserBoardCommentController {
	
	
	@Autowired
	private UserBoardCommentService boardCommentService;
	
	@RequestMapping("/Write")			//댓글 처리
	public String write(
				@SessionAttribute("login") OwnerUserVo userVo,
				@RequestParam HashMap<String, Object> map,
				RedirectAttributes re
			) {
		map.put("user_id", userVo.getUserId());
		System.out.println("write>>>>>>>>>>>>>>>map: " + map);
		
		this.boardCommentService.writeComment(map);
		
		re.addAttribute("board_idx", map.get("board_idx"));
		return "redirect:/Board/View";
	}
	
	@RequestMapping("/CommentUpdateForm")
	public ModelAndView UpdateForm(int comment_idx) {
		UserBoardCommentVo boardCommentVo = this.boardCommentService.getCommentUpdate(comment_idx);
		
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
	
	@RequestMapping("/boardWrite")
	public String boardWrite(
				Model model,
				@RequestParam HashMap<String, Object> map,
				@SessionAttribute("login") OwnerUserVo userVo
			) {
		map.put("user_id", userVo.getUserId());
		System.out.println("boardWrite>>>>>>>>>>>>>>>map: " + map);
		
		model.addAttribute("map", map);
		
		return "board/write";
	}
}
