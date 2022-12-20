package com.green.admin.category.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.admin.board.service.AdminBoardService;
import com.green.admin.category.Service.impl.AdminCategoryServiceimpl;
import com.green.admin.category.vo.AdminCategoryVo;
import com.green.admin.restaurant.board.vo.AdminUserBoardVo;
import com.green.admin.restaurant.service.impl.AdminRestaurantServiceImpl;
import com.green.admin.restaurant.vo.AdminRestaurantVo;
import com.green.admin.review.service.impl.AdminReviewServiceImpl;
import com.green.admin.review.vo.AdminReviewVo;
import com.green.admin.user.service.AdminUserService;
import com.green.admin.user.vo.AdminUserVo;
import com.green.restaurant.owner.service.OwnerService;
import com.green.restaurant.user.vo.OwnerUserVo;

@Controller
@RequestMapping("/admin")
public class AdminCategoryController {
	
	@Autowired
	AdminCategoryServiceimpl service;
	
	@Autowired
	AdminReviewServiceImpl reviewService;
	
	@Autowired
	AdminRestaurantServiceImpl restaurantservice;
	
	@Autowired
	AdminBoardService boardService;
	
	@Autowired
	private  AdminUserService  userService;
	
	@Autowired
	private OwnerService ownerService;
	
	@RequestMapping("/index")
	public String index() {
		
		return "admin/index";
	}	
	
	@RequestMapping("/index2")
	public String index2() {
		
		return "admin/index2";
	}
	
	@RequestMapping("/index/category")
	
	public String category() {
		
		return "admin/category";
	}
	
	/*
	@RequestMapping("/index/category/add")
	public Map<String, Object> getCategory(@RequestParam String category_name){
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		
		boolean r = service.addCategory(category_name);
		if(r) {
			resultMap.put("status", r);
			resultMap.put("message", category_name+"移댄뀒怨좊━ 異붽�媛� �셿猷뚮릺�뿀�뒿�땲�떎.");
		}else {	
			resultMap.put("status", r);
			resultMap.put("message", category_name+"�룞�씪�븳 移댄뀒怨좊━媛� 議댁옱�빀�땲�떎.");
		}
		
		return resultMap;	
	}*/
	@RequestMapping("/index/category/list")
	public String CategoryList(Model model){
		
		List<AdminCategoryVo> categoryList = service.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		
		return "admin/list";
	}
	
	@RequestMapping("/index/category/writeForm")
	public String writeForm() {
		
		return "admin/category";
	}
	
	@RequestMapping("/index/category/write")
	public String write(AdminCategoryVo categoryVo) {
		
		service.insertCategory(categoryVo);
		
		return "redirect:/admin/index/category";
	}
	
	@RequestMapping("/DeleteCategory/{category_name}")
	public String deleteCategory(@PathVariable String category_name) {
		
		System.out.println("deleteCategory>>>>>>>>>>>>>>>>>>>>>>>>>>>>>category_name: " + category_name);
		service.deleteCategory(category_name);
		
		return "redirect:/admin/index/category/list";
	}

	
	@RequestMapping("/ReviewList")
	public String selectComment(Model model) {
		
		List<AdminReviewVo> reviewList = reviewService.SelectComment();
		model.addAttribute("reviewList", reviewList);
		
		
		return "admin/reviewList";
		
	}
	
	@RequestMapping("/DeleteReview/{review_comment}")
	public String deleteReview(@PathVariable String review_comment) {
		
		reviewService.DeleteReview(review_comment);
		
		return "redirect:/admin/reviewList";
		
	}
	
	
	@RequestMapping("/DeleteRestaurant")
	public String deleteRestaurant(@PathVariable String brand_name) {
		
		restaurantservice.deleteRestaurant(brand_name);
		
		return "redirect:/admin/restaurantList";
		
	}
	
	@RequestMapping("/UpdateRestaurant/{restaurant_idx}")
	public String updateRestaurantForm(
			@PathVariable int restaurant_idx, Model model) {
		
		AdminRestaurantVo restarurantVo = restaurantservice.restaurantView(restaurant_idx);
		model.addAttribute("restaurant", restarurantVo);
		
		
		return "admin/restaurantUpdate";
	}
	
	@RequestMapping("/UpdateRestaurant")
	public String updateRestaurant(AdminRestaurantVo restarurantVo) {
		
		restaurantservice.restaurantUpdate(restarurantVo);
		
		return "redirect:/admin/restaurantList";
	}
	
	@RequestMapping("reviewMap")
	public String reviewMap(Model model) {
		
		List<AdminReviewVo> reviewMap = reviewService.reviewMap();
		model.addAttribute("reviewMap", reviewMap);
		
		System.out.println("reviewMap>>>>>>>>>>>>>>>>>>>>>>>>>>>>>reviewMap: " + reviewMap);
		System.out.println("model>>>>>>>>>>>>>>>>>>>>>>>>>>>>>model: " + model);
		
		return "admin/test";
	}
	
	//검색기능
	
	@RequestMapping("/search")
	public ModelAndView list(@RequestParam(defaultValue="user_id") String searchOption,
			@RequestParam(defaultValue="") String keyword) throws Exception {
		
		// 유저 검색
		
		List<AdminUserBoardVo> list = boardService.listAll(searchOption, keyword);
		
		int count = boardService.countArticle(searchOption, keyword);
		
		ModelAndView mv = new ModelAndView();
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		
		mv.addObject("map", map);
		mv.setViewName("admin/searchList");
		
		System.out.println("mv" + mv);
		
		return mv;
	}
	
	@RequestMapping("/reviewsearch")
	public ModelAndView reviewSearch(@RequestParam(defaultValue="user_id") String searchOption,
			@RequestParam(defaultValue="") String keyword) throws Exception {
		
		// 유저 검색
		
		List<AdminReviewVo> list = reviewService.reviewSearch(searchOption, keyword);
		
		ModelAndView mv = new ModelAndView();
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		
		mv.addObject("map", map);
		mv.setViewName("admin/reviewSearch");
		
		return mv;
	}
	
	@RequestMapping("/usersearch")
	public ModelAndView usersearch(@RequestParam(defaultValue="user_id") String searchOption,
			@RequestParam(defaultValue="") String keyword) throws Exception {
			
		List<AdminUserVo> list = userService.listAll(searchOption, keyword);
				
				ModelAndView mv = new ModelAndView();
				Map<String, Object>map = new HashMap<String, Object>();
				map.put("list", list);
				map.put("searchOption", searchOption);
				map.put("keyword", keyword);
				
				List<OwnerUserVo> requestList = this.ownerService.getRequestUpgradeUserList();
				System.out.println("OwnerCtrl.requestUserUpgradeList>>>>>>>>>>>>>>>>>>>>>>>>>>>>requestList: " + requestList.toString());
				mv.addObject("requestList", requestList);
				
				mv.addObject("map", map);
				mv.setViewName("admin/userSearch");
		
		return mv;
	}
	
	
}
