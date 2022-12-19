package com.green.home.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.admin.category.Service.AdminCategoryService;
import com.green.admin.category.vo.AdminCategoryVo;
import com.green.admin.restaurant.service.AdminRestaurantService;
import com.green.admin.user.service.AdminUserService;
import com.green.admin.user.vo.AdminUserVo;

@Controller
public class HomeController {
	
	@Autowired
	private  AdminUserService  userService;
	
	@Autowired
	AdminCategoryService categoryService;
	
	@Autowired
	AdminRestaurantService restaurantService;
	
	@RequestMapping("/")
	public  String  home(Model model) {
		
		List<AdminCategoryVo> categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		
		System.out.println("home>>>>"+ model);
		
		return "home";
	}
	
	@RequestMapping("/categorySearch")
	public String CategoryRestaurant(Model model,String category_name) {
		
		List<AdminCategoryVo> categoryList = categoryService.getCategoryList();
		
		List<AdminCategoryVo> categoryVo = categoryService.CategoryRestaurant(category_name);
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("categoryVo",categoryVo);
		
		
		return "/admin/categoryRestaurant";
	}
	/*
	@RequestMapping("/login")
	public  String  login() {
		return "user/login"; //WEB-INF/views/user/login.jsp
	}
	
	@RequestMapping("/loginProcess")
	public  String   loginProcess(
			HttpSession session,
			@RequestParam
			HashMap<String, Object> map
		) {
	
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>in loginProcess");
	String returnURL ="";
	
	if(session.getAttribute("login") != null) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>session remove");
		session.removeAttribute("login");
	}
	
	AdminUserVo userVo = this.userService.login(map);
	
	if(userVo != null) {
		session.setAttribute("login", userVo);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>login success, ownerVo: " + userVo.toString());
		returnURL = "redirect:/";
	}
	else {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>login fail");
		returnURL = "redirect:/login";
	}
	
	return returnURL;		
	}
	
	// 濡쒓렇�븘�썐
	@RequestMapping("/logout") 
	public  String  logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";  // 濡쒓렇�븘�썐�떆 �씠�룞�븷 二쇱냼 -> /login
	}
	*/
	@RequestMapping("/User/List")
	public  String  list( Model model ) {
		
		List<AdminUserVo> userList = userService.getUserList();
		List<String> msgList  = new ArrayList<>(); 
		
		for (AdminUserVo userVo : userList) {
			String msg = userVo.getUser_Id() + "\n";
			msgList.add( msg );
		}
		
		model.addAttribute("userList", userList);
		model.addAttribute("msgList",  msgList);
		
		
		return "user/list"; 
	} 
	
	@RequestMapping(value = "/User/ListSearch", method = RequestMethod.GET)
	public String  listSearch( Model model, 
			@RequestParam(value = "searchType", required = false) String searchType,
			@RequestParam(value = "keyword", required = false) String keyword) throws Exception {
		
		List<AdminUserVo> userList = null;
		userList = userService.UserListSearch(searchType, keyword);
		
		model.addAttribute("userList", userList);
		System.out.println("ctrl.listSearch>>>>>>>>>>>>>>>>>>>>>>searchType: " + searchType);
		System.out.println("ctrl.listSearch>>>>>>>>>>>>>>>>>>>>>>keyword: " + keyword);
		
		return "user/list"; 
	} 
	
	// html 濡� �씠�룞
	/*
	@RequestMapping("/a")
	public  String  a() {
		return "redirect:/static/html/ajax01.html";
		//return  "ajax01.html";  // �삤瑜�  /WEB-INF/ajax01.html.jsp
	}
	@RequestMapping("/b")
	public  String  b() {
		return "redirect:/static/html/ajax02.html";
	}*/
	
	@RequestMapping("/{val}")
	public  String  html( @PathVariable String val ) {
		String loc = "redirect:/static/html/";
		switch(val) {
		case "a" : loc += "ajax01.html"; break; 
		case "b" : loc += "ajax02.html"; break; 
		case "c" : loc += "ajax03.html"; break; 
		}
		return loc;
	}
	
	//-------------------------------------
	@RequestMapping("/ajax")
	public  void   ajax(  String v, HttpServletResponse response  ) {
		
		String  fmt  = "{"
				+ "   \"id\"   : \"sky\","
				+ "   \"pass\" : \"234\","
				+ "   \"v\"    : \"%s\" "
				+ "}";   // json
		String  data = String.format(fmt, v);
		
		try {		
			response.setContentType("application/json;charset=utf-8");
			PrintWriter  out = response.getWriter();
			out.print( data );
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// json library �궗�슜 : map data -> json�쑝濡� 異쒕젰
	// json library 異붽��빐�빞�븿 pom.xml : jackson-databind-2.12.0.jar
	
	// @ResponseBody �궗�슜 : viewresolver 瑜� 嫄곗튂吏� �븡怨� xml, json�쓣 異쒕젰媛��뒫�븯寃� �빐以��떎	
	@RequestMapping("/ajax2")
	@ResponseBody
	public  Map<String, Object>   ajax2(  String v ) {
		Map<String, Object> map = new HashMap<>(); 
		map.put("id",   "sky");
		map.put("pass", "1234");
		map.put("v",     v);
		return   map;   // map -> .json
	}
	
	@RequestMapping("/ajaxlist")
	@ResponseBody
	public  Map<Integer, Object > ajaxlist() {
		
		List<AdminUserVo> userList  =  userService.getUserList();
		// arraylist -> map
		
		Map<Integer, Object> map = new HashMap<>();
		for (int i = 0; i < userList.size(); i++) {
			map.put(i, userList.get(i) );
		}		
		return map;
	}
	
	@RequestMapping("/ajaxlist2") 
	@ResponseBody
	public  Map<String, Object> ajaxlist2() {
		
		List<AdminUserVo> userList = userService.getUserList();
		Map<String, Object> map = new HashMap<>();
		map.put("data", userList);		
		return map;
	}
	
	@RequestMapping("/DeleteUser/{userid}")
	public  String   deleteUser(@PathVariable String userid) {
		userService.deleteUser( userid );
		
		return "redirect:/User/List";
	}

	
}









