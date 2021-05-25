package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.pageDto.PageNavigation;
import com.ssafy.happyhouse.service.AdminService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@Api(value = "HappyHouse", description = "관리자 컨트롤러 ")
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	AdminService adminService;


	@ApiOperation(value = "페이지 네비게이션 받기")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "key", value = "검색조건", dataType = "string", paramType = "query")
			, @ApiImplicitParam(name = "word", value = "검색어", dataType = "string", paramType = "query")
			, @ApiImplicitParam(name = "page", value = "페이지", dataType = "string", paramType = "query")
	})
	@GetMapping("/user/list/navigation")
	public ResponseEntity<PageNavigation> getPageNavigation(@RequestParam(required = false) Map<String, String> params) {
		PageNavigation pageNavigation = adminService.getPageNavigation(params);
		System.out.println("[controller] admin user pageNavigation created" + pageNavigation);
		return new ResponseEntity<>(pageNavigation, HttpStatus.OK);
	}

	@ApiOperation(value = "유저 리스트 받기")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "key", value = "검색조건", dataType = "string", paramType = "query")
			, @ApiImplicitParam(name = "word", value = "검색어", dataType = "string", paramType = "query")
			, @ApiImplicitParam(name = "page", value = "페이지", dataType = "string", paramType = "query")
	})
	@GetMapping("/user/list")
	public ResponseEntity<List<UserDto>> getUserList(@RequestParam(required = false) Map<String, String> params) {
		System.out.println("[controller] params : " + params);
		List<UserDto> list = adminService.getUserList(params);
		System.out.println("[controller] userlist created" + list);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@DeleteMapping("user/remove/{userId}")
	public ResponseEntity<Void> removeUser(@PathVariable String userId) {
		adminService.removeUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
