package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;

import javax.servlet.http.HttpSession;

@Controller
@Api(value="HappyHouse" , description="HappyHouse Resources Management 2021")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String home() {
		logger.debug("index init");
		return "index";
	}
	
	@GetMapping("housedeal")
	public String housedeal() {
		logger.debug("move housedeal");
		System.out.println(">>>move housedeal HomeController");
		return "housedeal/actual_price";
	}
	
	@GetMapping("/mypage")
	public String moveMypage() {
		return "user/my_page";
	}
	
	@GetMapping("/register")
	public String moveRegister() {
		System.out.println(">>>move GET /register HomeController");
		return "user/register";
	}
	@GetMapping("article")
	public String board() {
		System.out.println("move article");
		return "notice/notice";
	}
	
	@GetMapping("admin")
	public String admin(HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("user");
		System.out.println("move user_admin");
		return user.isAdmin() ?  "admin/admin" : "index";
	}
	
	@GetMapping("shop")
	public String shop() {
		System.out.println("move shop");
		return "shop_info";
	}
	
	@GetMapping("pollution")
	public String pollution() {
		System.out.println("move pollution");
		return "pollution_info";
	}
}
