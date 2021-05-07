package com.ssafy.happyhouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
