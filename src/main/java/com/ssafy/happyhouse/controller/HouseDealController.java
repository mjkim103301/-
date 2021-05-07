package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.service.HouseDealService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api(value="HappyHouse" , description="HappyHouse Resources Management 2021")
public class HouseDealController {
	@Autowired
	private HouseDealService houseDealService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@GetMapping(value="/housedeal/search")
	public ResponseEntity<List<HouseDealDto>> houseDealSearch(@RequestBody List<HouseDealDto> houseDealDto) {
		System.out.println(">>>moveHouseDeal");
		List<HouseDealDto> list=houseDealService.houseDealList(houseDealDto);
		return new ResponseEntity<List<HouseDealDto>> (list, HttpStatus.OK);
	}
	
}
