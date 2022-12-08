package com.green.restaurant.owner.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.green.restaurant.owner.service.OwnerService;
import com.green.restaurant.user.vo.UserVo;

@Controller
@RequestMapping("/restaurant/owner")
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	
	@RequestMapping("/enrollRestaurant")
	public String enrollRestaurant(@SessionAttribute("login") UserVo userVo) {						//로그인한 유저의 세션정보를 UserVo에 담음
		System.out.println("ownerctrl.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>session: " + userVo.getUserRole());
		if(userVo.getUserRole().equals("OWNER") || userVo.getUserRole().equals("ADMIN")) {			//유저권한정보를 확인한 후 사장이나 관리자권한을 가진 계정이면 접근 허용
			return "/owner/enrollRestaurant";
		}
		return "redirect:/";
	}
	
	@RequestMapping("/enrollProcess")
	public String enrollProcess(
			@SessionAttribute("login") UserVo userVo,
			@RequestParam HashMap<String, Object> map
			) {
		System.out.println("ownerCtrl.enrollProcess>>>>>>>>>>>>>>>>>>>>>>>>>map: " + map.toString());
		System.out.println("ownerctrl.enrollRestaurant>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>session.ownerIdx: " + userVo.getOwnerIdx());
		
		map.put("ownerIdx", userVo.getOwnerIdx());	//유저 권한정보를 map에 담음
		
		this.ownerService.enrollRestorant(map);
		
		return "redirect:/";
	}
}
