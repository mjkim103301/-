package com.ssafy.happyhouse.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api(value="HappyHouse" , description="HappyHouse Resources Management 2021")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/login")
	public ResponseEntity<MemberDto> login(@RequestBody MemberDto member, HttpSession session){
//		System.out.println(map.get("userid") + " " + map.get("userpwd"));
		System.out.println("id : " + member.getUserid());
		MemberDto memberDto = memberService.login(member.getUserid(), member.getUserpwd());
		
		if(memberDto == null) {
			System.out.println("fail");
			return new ResponseEntity<MemberDto>(HttpStatus.NOT_FOUND);
		}
		session.setAttribute("member", memberDto);
		System.out.println(HttpStatus.OK);
		return new ResponseEntity<MemberDto>(member, HttpStatus.OK);
	}
}
