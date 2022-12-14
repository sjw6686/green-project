package com.green.restaurant.owner.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.green.restaurant.owner.service.OwnerService;
import com.green.restaurant.owner.vo.OwnerBoardVo;
import com.green.restaurant.owner.vo.OwnerCommentVo;
import com.green.restaurant.owner.vo.OwnerRestaurantMenuFileJoinVo;
import com.green.restaurant.owner.vo.OwnerRestaurantVo;
import com.green.restaurant.user.vo.OwnerUserVo;

@Controller
@RequestMapping("/restaurant/owner")
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	
//	@Autowired
//	private PdsService pdsService;
	
	@RequestMapping("/enrollRestaurant")
	public String enrollRestaurant(@SessionAttribute("login") OwnerUserVo userVo) {						//로그인한 유저의 세션정보를 UserVo에 담음
		System.out.println("ownerctrl.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>session: " + userVo.getUserRole());
		if(userVo.getUserRole().equals("OWNER") || userVo.getUserRole().equals("ADMIN")) {			//유저권한정보를 확인한 후 사장이나 관리자권한을 가진 계정이면 접근 허용
			return "/owner/enrollRestaurant";
		}
		return "redirect:/";
	}
	
	@RequestMapping("/enrollProcess")
	public String enrollProcess(
			@SessionAttribute("login") OwnerUserVo userVo,
			@RequestParam  HashMap<String, Object> map,
			HttpServletRequest request		//파일정보 받기위해 추가
			) {
		System.out.println("ownerctrl.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>session.ownerIdx: " + userVo.getOwnerIdx());
		map.put("ownerIdx", userVo.getOwnerIdx());		//map에 owner_idx 저장
		
		System.out.println("ownerctrl.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
		System.out.println("ownerctrl.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>request: " + request.toString());
		
		this.ownerService.enrollRestorant(map, request);
		
		return "redirect:/";
	}
	
	@RequestMapping("/myRestaurantList")
	public String myRestaurantList(
			Model model,
			@SessionAttribute("login") OwnerUserVo userVo
			) {
		if(userVo.getUserRole().equals("USER")) {			//가게목록은 일반유저가 볼수없게 하기위해 USER권한을 가진 유저는 홈으로 반환
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invalid authority");
			return "redirect:/";
		}
		
		List<OwnerRestaurantVo> myRestaurantList = this.ownerService.myRestaurantList(userVo);
		System.out.println("myRestaurantList>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>myRestaurantList: " + myRestaurantList);
		model.addAttribute("restaurantList", myRestaurantList);
		
		return "/owner/myRestaurantList";
	}
	
	@RequestMapping("/myRestaurant")
	public String myRestaurant(Model model, @SessionAttribute("login") OwnerUserVo userVo, int restaurant_idx) {
		System.out.println("ownerController>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>restaurant_idx: " + restaurant_idx);
		if(userVo.getUserRole().equals("USER") ) {			//가게목록은 일반유저가 볼수없게 하기위해 USER권한을 가진 유저는 홈으로 반환
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invalid authority");
			return "redirect:/";
		}
		System.out.println("ownerController.myRestaurant>>>>>>>>>>>>>>>>>>>restaurant_idx: " + restaurant_idx);
		//식당정보 가져옴
		List<OwnerRestaurantMenuFileJoinVo> restaurantInfo = this.ownerService.getMyRestaurantInfo(restaurant_idx);
		System.out.println("ownerController.myRestaurant>>>>>>>>>>>>>>>>>>>restaurantInfo: " + restaurantInfo.toString());
		//리뷰정보 가져옴
		List<OwnerBoardVo> reviewList = this.ownerService.getReviewList(restaurant_idx);
		System.out.println("ownerController.myRestaurant>>>>>>>>>>>>>>>>>>>boardInfo: " + reviewList.toString());
		
		model.addAttribute("restaurantInfo", restaurantInfo);
		model.addAttribute("reviewList", reviewList);
		System.out.println("ownerController.myRestaurant>>>>>>>>>>>>>>>>>>>model: " + model.toString());
		
		return "/owner/myRestaurant";
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
		
		return "/owner/ownerReviewComment";
	}
	
	@RequestMapping("/updateRestaurant")
	public String updateRestaurant(
			Model model,
			int restaurant_idx,
			@SessionAttribute("login") OwnerUserVo userVo) {
		if(userVo.getUserRole().equals("USER")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invalid authority");
			return "redirect:/";
		}
		System.out.println("OwnerCtrl.updateRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>restaurant_idx: " + restaurant_idx);

		return "/owner/updateRestaurant";
	}
	
	@RequestMapping("/updateProcess")
	public String updateProcess(
				Model model,
				@RequestParam  HashMap<String, Object> map,
				@SessionAttribute("login") OwnerUserVo userVo
			) {
		if(userVo.getUserRole().equals("USER")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invalid authority");
			return "redirect:/";
		}
		System.out.println("OwnerCtrl.updateRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
		this.ownerService.updateRestaurant(map);
		return "redirect/";
	}
	
}
