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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.restaurant.owner.service.OwnerService;
import com.green.restaurant.owner.vo.OwnerBoardVo;
import com.green.restaurant.owner.vo.OwnerCategoryVo;
import com.green.restaurant.owner.vo.OwnerCommentVo;
import com.green.restaurant.owner.vo.OwnerMenuFileJoinVo;
import com.green.restaurant.owner.vo.OwnerRestaurantMenuFileJoinVo;
import com.green.restaurant.owner.vo.OwnerRestaurantVo;
import com.green.restaurant.user.vo.OwnerUserVo;

@Controller
@RequestMapping("/restaurant/owner")
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	
	@RequestMapping("/enrollRestaurant")
	public String enrollRestaurant(
				Model model,
				@SessionAttribute("login") OwnerUserVo userVo		//로그인한 유저의 세션정보를 UserVo에 담음
			) {
		System.out.println("ownerctrl.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>session: " + userVo.getUserRole());
		
		if(userVo.getUserRole().equals("USER")) {					//가게등록은 일반유저가 할수없게 하기위해 USER권한을 가진 유저는 홈으로 반환
			model.addAttribute("user_id", userVo.getUserId());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invalid authority");
			return "redirect:/";
		}
		
		List<OwnerCategoryVo> categoryList = this.ownerService.getCategoryList(); 
		System.out.println("OwnerCtrl.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>categoryList: " + categoryList);
		model.addAttribute("categoryList", categoryList);
		
		return "/owner/enrollRestaurant";
	}
	
	@RequestMapping("/enrollProcess")
	public String enrollProcess(
				@SessionAttribute("login") OwnerUserVo userVo,
				@RequestParam  HashMap<String, Object> map,
				HttpServletRequest request,		//파일정보 받기위해 추가
				Model model
			) {
		System.out.println("ownerctrl.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>session.ownerIdx: " + userVo.getOwnerIdx());
		map.put("ownerIdx", userVo.getOwnerIdx());		//map에 owner_idx 저장
		
		System.out.println("ownerctrl.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
		System.out.println("ownerctrl.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>request: " + request.toString());
		
		this.ownerService.enrollRestorant(map, request);
		System.out.println("ownerctrl.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>restaurant enroll success!!");
		
		return "redirect:/";
	}
	
	@RequestMapping("/enrollMenu")
	public String enrollMenu(
				@SessionAttribute("login") OwnerUserVo userVo,
				@RequestParam  HashMap<String, Object> map,
				Model model
			) {
		
		if(userVo.getUserRole().equals("USER")) {
			model.addAttribute("user_id", userVo.getUserId());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invalid authority");
			return "redirect:/";
		}
		
		System.out.println("ownerctrl.enrollMenu>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>session.ownerIdx: " + userVo.getOwnerIdx());
		map.put("ownerIdx", userVo.getOwnerIdx());
		System.out.println("ownerctrl.enrollMenu>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		
		List<OwnerMenuFileJoinVo> menuList = this.ownerService.getMenuList(map);
		System.out.println("ownerctrl.enrollMenu>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>menuList: " + menuList.toString());
		
		model.addAttribute("menuList", menuList);					//menu정보 등록시 메뉴를 리스트형식으로 한번에 등록하는것이 아니라 하나씩 등록후 다시 등록하는 페이지로 돌아옴. 메뉴등록후 등록된 정보를 볼수있게 메뉴정보가 있다면 찾아서 model에 담음
		model.addAttribute("restaurant_idx", map.get("restaurant_idx"));
		System.out.println("ownerctrl.enrollMenu>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>model: " + model.toString());
		
		return "/owner/enrollMenu";
	}
	
	@RequestMapping("/enrollMenuProcess")
	public String enrollMenuProcess(
				@RequestParam  HashMap<String, Object> map,
				HttpServletRequest request,
				RedirectAttributes re
			) {

//		System.out.println("OwnerCtrl.enrollMenuProcess>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
//		return "redirect:/showJsp";

		System.out.println("OwnerCtrl.enrollMenuProcess>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		this.ownerService.enrollMenu(map, request);
		System.out.println("OwnerCtrl.enrollMenuProcess>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>enroll menu success!!");
		
		re.addAttribute("restaurant_idx", map.get("restaurant_idx"));
		System.out.println("OwnerCtrl.enrollMenuProcess>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>re: " + re.toString());
		
		return "redirect:/restaurant/owner/enrollMenu";
	}
	
	@RequestMapping("/myRestaurantList")
	public String myRestaurantList(
				Model model,
				@SessionAttribute("login")OwnerUserVo userVo
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
	public String myRestaurant(
				Model model,
				@SessionAttribute("login") OwnerUserVo userVo,
				int restaurant_idx
			) {
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
	
	@RequestMapping("/requestUserUpgrade")
	public String requestUserUpgrade(
				Model model,
				@SessionAttribute("login") OwnerUserVo userVo
			) {
		if(userVo.getUserRole().equals("OWNER")) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invalid authority");
			return "redirect:/";
		}
		
		if(userVo.getUserRole().equals("USER")) {
			userVo.setUserRole("일반유저");		//만약 유저권한이 "USER" 라면 화면에 표시되는 정보는 일반유저라고 표시하기위해 값 변경
		}
		
		model.addAttribute("userVo", userVo);										//변경된 유저정보 model에 담아서 jsp에 전달
		System.out.println("OwnerController.requestUpgrade>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>model: " + model.toString());
		
		return "/owner/requestUserUpgrade";
	}
	
	@RequestMapping("/requestUserUpgradeProcess")										//등업신청시 
	public String requestUpgradeProcess(
				@SessionAttribute("login") OwnerUserVo userVo,
				@RequestParam  HashMap<String, Object> map
			) {
		System.out.println("OwnerController.requestUpgradeProcess>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		
		this.ownerService.requestUpdate(map);
		userVo.setUserRole("USER");			//requestUserUpgrade에서 변경했던 유저권한을 다시 USER로 세팅
		
		return "redirect:/";
	}
	
	@RequestMapping("/requestUserUpgradeList")
	public String requestUserUpgradeList(Model model) {
		List<OwnerUserVo> requestList = this.ownerService.getRequestUpgradeUserList();
		System.out.println("OwnerCtrl.requestUserUpgradeList>>>>>>>>>>>>>>>>>>>>>>>>>>>>requestList: " + requestList.toString());
		
		model.addAttribute("requestList", requestList);
		return "/owner/requestUserUpgradeList";
	}
	
	@RequestMapping("/userUpgradeProcess")
	public String userUpgradeProcess(@RequestParam List<Integer> owner_idx, @RequestParam List<String> user_id) {
		System.out.println("OwnerCtrl.userUpgradeProcess>>>>>>>>>>>>>>>>>>>>>>>>>>>>owner_idx: " + owner_idx);
		System.out.println("OwnerCtrl.userUpgradeProcess>>>>>>>>>>>>>>>>>>>>>>>>>>>>user_id: " + user_id);
		
		for(int ownerIdx : owner_idx) {
			System.out.println(ownerIdx);
			this.ownerService.updateOwnerIdx(ownerIdx);
		}
		
		for(String userId : user_id) {
			System.out.println(userId);
			this.ownerService.updateUserRole(userId);
		}
		
		return "redirect:/admin/usersearch";
	}
	
	@RequestMapping("/writeCommentProcess")
	public String writeCommentProcess(
				@SessionAttribute("login") OwnerUserVo userVo,
				@RequestParam  HashMap<String, Object> map
			) {
		System.out.println("OwnerCtrl.writeCommentProcess>>>>>>>>>>>>>>>>>>>>>>>map" + map);
		//this.ownerService.writeComment();
		return "redirect:/owner/reviewComment";
	}
	
	@RequestMapping("/writeReview")
	public String writeReview(
				@SessionAttribute("login") OwnerUserVo userVo,
				int restaurant_idx,
				Model model
			) {
		System.out.println("user_id: " + userVo.getUserId() + ", restaurant_idx: " +  restaurant_idx);
		
		model.addAttribute("user_id", userVo.getUserId());
		model.addAttribute("restaurant_idx", restaurant_idx);
		
		return "/owner/writeReview";
	}
	
	@RequestMapping("/writeReviewProcess")
	public String writeReviewProcess(
			@RequestParam  HashMap<String, Object> map,
			RedirectAttributes re
			) {
		System.out.println("OwnerCtrl.writeReviewProcess>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		
		this.ownerService.writeReview(map);
		
		re.addAttribute("restaurant_idx", map.get("restaurant_idx"));
		return "redirect:/restaurantInfo";
	}
	
//	@RequestMapping("/updateRestaurant")
//	public String updateRestaurant(
//			Model model,
//			int restaurant_idx,
//			@SessionAttribute("login") OwnerUserVo userVo) {
//		if(userVo.getUserRole().equals("USER")) {
//			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invalid authority");
//			return "redirect:/";
//		}
//		System.out.println("OwnerCtrl.updateRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>restaurant_idx: " + restaurant_idx);
//
//		return "/owner/updateRestaurant";
//	}
//	
//	@RequestMapping("/updateProcess")
//	public String updateProcess(
//				Model model,
//				@RequestParam  HashMap<String, Object> map,
//				@SessionAttribute("login") OwnerUserVo userVo
//			) {
//		if(userVo.getUserRole().equals("USER")) {
//			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>invalid authority");
//			return "redirect:/";
//		}
//		System.out.println("OwnerCtrl.updateRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
//		this.ownerService.updateRestaurant(map);
//		return "redirect/";
//	}
	
}
