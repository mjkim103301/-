package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.UserDto;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.happyhouse.service.UserService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api(value = "HappyHouse", description = "사용자 관련 컨트롤러")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody UserDto user, HttpSession session) {
		System.out.println(">>>move POST /login");
//		System.out.println(map.get("userid") + " " + map.get("userpwd"));
		System.out.println("id : " + user.getUserId() + "pwd : " + user.getUserPwd());
		UserDto userDto = userService.login(user.getUserId(), user.getUserPwd());

		if (userDto == null) {
			System.out.println("userDto null");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		System.out.println(userDto);
		session.setAttribute("user", userDto);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@PostMapping("/findpassword")
	public ResponseEntity<String> findPassword(@RequestBody UserDto user) {
		System.out.println(">>>move POST /findpassword");
		String userPwd = userService.findUserPwd(user);

		if (userPwd == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		System.out.println(userPwd);
		return new ResponseEntity<>(userPwd, HttpStatus.OK);
	}

	@GetMapping("/logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		System.out.println(">>>move GET /logout");
		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/updateuser")
	public ResponseEntity<Void> updateMember(@RequestBody UserDto user, HttpSession session) {
		System.out.println(">>>move PUT /updateUser");
		userService.updateUser(user);
		session.setAttribute("user", user);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/idcheck/{userid}")
	public ResponseEntity<Void> duplicatedIdCheck(@PathVariable(value = "userid") String userid) {
		System.out.println(">>>move GET /idcheck/{userid}");
		if (!userService.duplicatedIdCheck(userid)) {
			System.out.println("fail");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/remove/{userid}")
	public ResponseEntity<Void> removeUser(@PathVariable(value = "userid") String userid, HttpSession session) {
		userService.removeUser(userid);
		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Void> registerMember(@RequestBody UserDto user) {
		System.out.println("/register => POST >>>>>>>>>>>>>>");
		userService.registerUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getSession")
	public ResponseEntity<UserDto> getSession(HttpSession session) {
		UserDto userDto = (UserDto) session.getAttribute("user");
		System.out.println(">>>move GET /getSession" + userDto);
		if (userDto == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		userDto.setUserPwd("");
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
}
