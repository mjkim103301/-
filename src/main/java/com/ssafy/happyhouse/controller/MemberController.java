package com.ssafy.happyhouse.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
			return new ResponseEntity<MemberDto>(HttpStatus.NOT_FOUND);
		}
		
		System.out.println(memberDto);
		session.setAttribute("member", memberDto);
		return new ResponseEntity<MemberDto>(HttpStatus.OK);
	}
	
	@PostMapping("/findpassword")
	public ResponseEntity<String> findPassword(@RequestBody MemberDto member){
		System.out.println("init");
		String userPwd = memberService.findMemberPwd(member);
		
		if(userPwd == null) {
			System.out.println("errro");
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		System.out.println(userPwd);
		return new ResponseEntity<String>(userPwd, HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity updateMember(@RequestBody MemberDto member, HttpSession session) {
		System.out.println(member);
		memberService.updateMember(member);
		session.setAttribute("member", member);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/idcheck/{userid}")
	public ResponseEntity duplicatedIdCheck(@PathVariable(value = "userid") String userid) {
		System.out.println(userid);
		if(!memberService.duplicatedIdCheck(userid)) {
			System.out.println("fail");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
