package com.ssafy.happyhouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;

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
		System.out.println(">>>move housedeal HomeControllder");
		return "housedeal/actual_price";
	}
	
	@GetMapping("mypage")
	public String mypage() {
		return "member/my_page";
	}
	
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	
	@GetMapping("article")
	public String board() {
		System.out.println("move article");
		return "notice/notice";
	}
	
	@GetMapping("user_admin")
	public String userAdmin() {
		System.out.println("move user_admin");
		return "admin/user_admin";
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
