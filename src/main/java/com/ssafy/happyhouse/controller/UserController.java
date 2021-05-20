package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.UserDto;
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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.service.UserService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api(value="HappyHouse" , description="HappyHouse Resources Management 2021")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody UserDto user, HttpSession session){
//		System.out.println(map.get("userid") + " " + map.get("userpwd"));
		System.out.println("id : " + user.getUserId());
		UserDto userDto = userService.login(user.getUserId(), user.getUserPwd());
		
		if(userDto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		System.out.println(userDto);
		session.setAttribute("user", userDto);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	
	@PostMapping("/findpassword")
	public ResponseEntity<String> findPassword(@RequestBody UserDto user){
		System.out.println("init");
		String userPwd = userService.findMemberPwd(user);
		
		if(userPwd == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		System.out.println(userPwd);
		return new ResponseEntity<>(userPwd, HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity<Void> updateMember(@RequestBody UserDto user, HttpSession session) {
		System.out.println(user);
		userService.updateMember(user);
		session.setAttribute("user", user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/idcheck/{userid}")
	public ResponseEntity<Void> duplicatedIdCheck(@PathVariable(value = "userid") String userid) {
		System.out.println(userid);
		if(!userService.duplicatedIdCheck(userid)) {
			System.out.println("fail");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Void> registerMember(@RequestBody UserDto member) {
		userService.registerMember(member);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
