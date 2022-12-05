package com.green.restaurant.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.green.restaurant.user.service.UserService;
import com.green.restaurant.user.vo.UserVo;

@Controller
@RequestMapping("/restaurant/user")
public class UserController {
	
	@Autowired
	private  UserService userService;
	
	@RequestMapping("/userList")
	public ModelAndView getUserList() {
		
		List<UserVo> userList = this.userService.getUserList();
		System.out.println("UserCtrl: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>userList:  " + userList.toString());
		
		ModelAndView   mv  = new ModelAndView();
		mv.addObject("userList", userList);
		mv.setViewName("/user/userList");
		
		return mv;
	}
}
