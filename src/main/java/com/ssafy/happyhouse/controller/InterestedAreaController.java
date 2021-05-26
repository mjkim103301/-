package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.areaDto.CommercialInfoDto;
import com.ssafy.happyhouse.dto.areaDto.EnvironmentInfoDto;
import com.ssafy.happyhouse.dto.areaDto.InterestedAreaDto;
import com.ssafy.happyhouse.dto.areaDto.SafeHospitalInfoDto;
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
		System.out.println("[Interested controller] => /interested/register, body : " + interestedAreaDto);
		interestedAreaService.addInterestArea(interestedAreaDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "관심지역 받아오기")
	@GetMapping("/list/{userId}")
	public ResponseEntity<List<InterestedAreaDto>> getInterestedAreaList(@PathVariable String userId) {
		System.out.println("[Interested controller] => /interested/list/" + userId);
		List<InterestedAreaDto> list = interestedAreaService.getInterestedAreaList(userId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "상권 정보 받아오기")
	@GetMapping("/commercial/{dongcode}")
	public ResponseEntity<List<CommercialInfoDto>> getCommercialInfoList(@PathVariable String dongcode) {
		System.out.println("[Interested controller] => /interested/commercial/" + dongcode);
		List<CommercialInfoDto> list = interestedAreaService.getCommercialInfoList(dongcode);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "환경 오염 정보 가져오기")
	@GetMapping("/environment/{dongcode}")
	public ResponseEntity<List<EnvironmentInfoDto>> getEnvironmentInfoList(@PathVariable String dongcode) {
		System.out.println("[Interested controller] => /interested/environment/" + dongcode);
		List<EnvironmentInfoDto> list = interestedAreaService.getEnvironmentInfoList(dongcode);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "병원 정보 가져오기")
	@GetMapping("/safehospital/{gugun}")
	public ResponseEntity<List<SafeHospitalInfoDto>> getSafeHospitalInfoList(@PathVariable String gugun) {
		System.out.println("[Interested controller] => /interested/safehospital/" + gugun);
		List<SafeHospitalInfoDto> list = interestedAreaService.getSafeHospitalInfoList(gugun);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
