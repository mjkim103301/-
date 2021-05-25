package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.areaDto.InterestedAreaDto;
import com.ssafy.happyhouse.service.InterestedAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "관심 지역 컨트롤러")
@CrossOrigin("*")
@RestController
@RequestMapping("/interested")
public class InterestedAreaController {

	@Autowired
	InterestedAreaService interestedAreaService;

	private static final Logger logger = LoggerFactory.getLogger(InterestedAreaController.class);

	@ApiOperation(value = "관심지역 추가하기")
	@PostMapping("/register")
	public ResponseEntity<Void> addInterestArea(@RequestBody InterestedAreaDto interestedAreaDto) {
		interestedAreaService.addInterestArea(interestedAreaDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "관심지역 받아오기")
	@GetMapping("/list/{userId}")
	public ResponseEntity<List<InterestedAreaDto>> getInterestedAreaList(@PathVariable String userId) {
		List<InterestedAreaDto> list = interestedAreaService.getInterestedAreaList(userId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
