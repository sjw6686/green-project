package com.green.restaurant;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
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
	
	@RequestMapping("/showJsp")
	public ModelAndView showJsp() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("restaurant_idx", 1);
		mv.setViewName("/owner/enrollMenu");
		return mv;
	}


}