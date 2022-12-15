package com.green.restaurant.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.restaurant.board.service.BoardBoardService;
import com.green.restaurant.board.vo.BoardBoardVo;
import com.green.restaurant.board_comment.vo.BoardBoardCommentVo;

@Controller
@RequestMapping("/Board")
public class BoardBoardController {

	@Autowired
	private BoardBoardService boardService;

	@RequestMapping("/List")
	public String list(Model model) {

		// 출력할 자료목록를 조회한다
		List<BoardBoardVo> boardList = boardService.getBoardList();
		/* System.out.println("boardCont:" + boardList); */
		model.addAttribute("boardList", boardList);
		return "board/list";
	}

	@RequestMapping("/Write")
	public String write() {
		
		return "board/write";
	}

	// <a href="/Board/View?board_idx=${board.board_idx}"
	// http://localhost:8081/Board/View?board_idx=1
	@RequestMapping("/View")
	public String view(@RequestParam HashMap<Integer, Object> map, Model model) {
		// int board_idx = Integer.parseInt(String.valueOf(map.get("board_idx") ));
		System.out.println("bCtrl.view>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		BoardBoardVo boardVo = this.boardService.getBoard(map);
		List<BoardBoardCommentVo> boardCommentList = boardService.getBoardCommentList(map);
		System.out.println(
				"boadDao.getBoardCommentList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>commentList: " + boardCommentList.toString());

		model.addAttribute("boardVo", boardVo);
		model.addAttribute("commentList", boardCommentList);

		return "board/view";
	}

	@RequestMapping("/WriteSave")
	public String writesave(BoardBoardVo boardVo) {
		// System.out.println("bCtrl.writesave>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>boardVo:
		// " + boardVo);
		this.boardService.getwritesave(boardVo);
		return "redirect:/Board/List";
	}

	@RequestMapping("/Delete")
	public ModelAndView delete(@RequestParam HashMap<String, Object> map) {

		// idx 해당 글 삭제
		boardService.boardDelete(map);

		String board_idx = (String) map.get("board_idx");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Board/List?board_idx=" + board_idx);
		return mv;

	}

	@RequestMapping("/UpdateForm")
	public ModelAndView updateForm(int board_idx) {
		System.out.println("boardCtrl.update>>>>>>>>>>>>>>>>>>>>map:" + board_idx);
		BoardBoardVo boardVo = boardService.getBoard(board_idx);
		System.out.println("boardCtrl.update>>>>>>>>>>>>>>>>>>>>boardVo:" + boardVo.toString());
		
		ModelAndView mv = new ModelAndView();	
		mv.addObject("boardVo", boardVo);
		mv.setViewName("board/update");
		return mv;
	}
	
	@RequestMapping("/Update")
	public ModelAndView update(@RequestParam HashMap <String, Object> map ) {

		// System.out.println("map:" + map);
		// 수정내용저장
		boardService.boardUpdate(map);
		//System.out.println("boadCtrl.update>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		
		String board_idx = (String) map.get("board_idx");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Board/List?board_idx=" + board_idx);
		return mv;
	}
	
	
}

