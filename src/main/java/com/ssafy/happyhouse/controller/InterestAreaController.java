package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.areaDto.InterestAreaDto;
import com.ssafy.happyhouse.service.InterestAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(value = "관심 지역 컨트롤러")
@CrossOrigin("*")
@RestController
@RequestMapping("/interest")
public class InterestAreaController {

	@Autowired
	InterestAreaService interestAreaService;

	private static final Logger logger = LoggerFactory.getLogger(InterestAreaController.class);

	@ApiOperation(value = "관심지역 추가하기")
	@PostMapping("/")
	private ResponseEntity<Void> addInterestArea(@RequestBody InterestAreaDto interestAreaDto) {
		interestAreaService.addInterestArea(interestAreaDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
