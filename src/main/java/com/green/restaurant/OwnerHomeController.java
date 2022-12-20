package com.green.restaurant;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.restaurant.owner.service.OwnerService;
import com.green.restaurant.owner.vo.OwnerBoardVo;
import com.green.restaurant.owner.vo.OwnerCommentVo;
import com.green.restaurant.owner.vo.OwnerRestaurantJoinImgFileVo;
import com.green.restaurant.owner.vo.OwnerRestaurantMenuFileJoinVo;

@Controller
public class OwnerHomeController {
	
	@Autowired
	private OwnerService ownerService;
	
//	@RequestMapping("/")
//	public String index() {
//		return "redirect:/home";
//	}
	
//	@RequestMapping("/home")
//	public String home() {
//		return "home";
//	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/signUp")
	public String signUp() {
		return "signUp";
	}
	
	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("restaurantList")
	public String restaurantList(Model model) {
		List<OwnerRestaurantJoinImgFileVo> restaurantList = this.ownerService.getRestaurantList();
		System.out.println("HomeConriller.restaurantList>>>>>>>>>>>>>>>>>>>>>>>>>>>>restaurantList: " + restaurantList.toString());
		
		model.addAttribute("restaurantList", restaurantList);
		System.out.println("HomeConriller.restaurantList>>>>>>>>>>>>>>>>>>>>>>>>>>>>model: " + model.toString());
		return "/owner/restaurantList";
	}
	
	@RequestMapping("/restaurantInfo")
	public String restauratnInfo(Model model, int restaurant_idx) {
		List<OwnerRestaurantMenuFileJoinVo> restaurantInfo = this.ownerService.getMyRestaurantInfo(restaurant_idx);
		System.out.println("ownerController.myRestaurant>>>>>>>>>>>>>>>>>>>restaurantInfo: " + restaurantInfo.toString());
		//리뷰정보 가져옴
		List<OwnerBoardVo> reviewList = this.ownerService.getReviewList(restaurant_idx);
		System.out.println("ownerController.myRestaurant>>>>>>>>>>>>>>>>>>>boardInfo: " + reviewList.toString());
		
		model.addAttribute("restaurantInfo", restaurantInfo);
		model.addAttribute("reviewList", reviewList);
		
		return "/owner/restauratnInfo";
	}
	
	@RequestMapping("/reviewComment")
	public String reviewComment(Model model, int board_idx) {
		System.out.println("OwnerCtrl.reviewComment>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>board_idx: " + board_idx);
		
		OwnerBoardVo ownerBoardVo = new OwnerBoardVo();				//댓글 표시할 리뷰게시판의 정보를 가져오기위해 게시판vo생성
		ownerBoardVo = this.ownerService.getReview(board_idx);		//해당게시판의 정보 가져옴
		System.out.println("OwnerCtrl.reviewCommentList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ownerBoardVo: " + ownerBoardVo.toString());
		
		List<OwnerCommentVo> reviewCommentList = this.ownerService.getReviewCommentList(board_idx);	//게시판에 대한 댓글리스트 가져옴
		System.out.println("OwnerCtrl.reviewCommentList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>reviewCommentList: " + reviewCommentList.toString());
		
		model.addAttribute("ownerBoardVo", ownerBoardVo);
		model.addAttribute("reviewCommentList", reviewCommentList);
		return "/owner/reviewComment";
	}

}