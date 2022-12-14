package com.green.restaurant.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.restaurant.user.service.UserService;
import com.green.restaurant.user.vo.OwnerUserVo;

@Controller
@RequestMapping("/restaurant/user")
public class UserController {
	
	@Autowired
	private  UserService userService;
	
	@RequestMapping("/loginProcess")
	public String loginProcess(
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
		
		OwnerUserVo userVo = this.userService.login(map);
		
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
	
	@RequestMapping("signUpProcess")
	public String signUpProcess(@RequestParam HashMap<String, Object> map) {
		System.out.println("uctrl.signUpProcess>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
		this.userService.signUpUser(map);
		return "redirect:/";
	}
}
