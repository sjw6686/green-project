package com.green.restaurant.owner.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.restaurant.owner.service.OwnerService;
import com.green.restaurant.owner.vo.OwnerVo;

@Controller
@RequestMapping("/restaurant/owner")
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	
	@RequestMapping("/ownerList")
	public ModelAndView getOwnerList() {
		List<OwnerVo> ownerList = this.ownerService.getOwnerList();
		System.out.println("oCtrl>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ownerList: "+ ownerList);
		
		ModelAndView   mv  = new ModelAndView();
		mv.addObject("ownerList", ownerList);
		mv.setViewName("/owner/owner");
		
		return mv;
	}
	
	@RequestMapping("/loginProcess")
	public String ologinProcess(
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
		
		OwnerVo ownerVo = this.ownerService.login(map);
		
		if(ownerVo != null) {
			session.setAttribute("login", ownerVo);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>login success, ownerVo: " + ownerVo.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>login success, session: " + session.toString());
			returnURL = "redirect:/";
		}
		else {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>login fail");
			returnURL = "redirect:/login";
		}
		return returnURL;
	}
	@RequestMapping("/signUpProcess")
	private ModelAndView signUpProcess(@RequestParam HashMap<String, Object> map) {
		System.out.println("ctrl>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map);
		this.ownerService.ownerSignUp(map);
		
		ModelAndView   mv  = new ModelAndView();
		
		return mv;
	}
}
