package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.areaDto.CommercialInfoDto;
import com.ssafy.happyhouse.dto.areaDto.EnvironmentInfoDto;
import com.ssafy.happyhouse.dto.areaDto.InterestedAreaDto;
import com.ssafy.happyhouse.dto.areaDto.*;
import com.ssafy.happyhouse.service.InterestedAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


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
	public ResponseEntity<Void> addInterestArea(@RequestBody List<Map<String,Object>> params, HttpSession session) {
		System.out.println("add interest area params: "+params);
		
		InterestedAreaDto interestedAreaDto;
		UserDto userDto = (UserDto) session.getAttribute("user");
		
		
		for(Map<String, Object> p:params) {
			String dongcode=(String) p.get("dongcode");
			System.out.println("dongcode "+dongcode);
			if(dongcode==null||dongcode.length()==0) {
				System.out.println("dongocde is null");
				continue;
			}
			String dong=(String)p.get("dong");
			
			interestedAreaDto=new InterestedAreaDto(0, userDto.getUserId(), dongcode, dong);
			System.out.println("[Interested controller] => /interested/register, body : " + interestedAreaDto);
			interestedAreaService.addInterestArea(interestedAreaDto);
		}
		
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

	@ApiOperation(value = "진료소 정보 가져오기")
	@GetMapping("/screeningcenter/{gugun}")
	public ResponseEntity<List<ScreeningCenterInfoDto>> getScreeningCenterInfoList(@PathVariable String gugun) {
		System.out.println("[Interested controller] => /interested/screeningcenter/" + gugun);
		List<ScreeningCenterInfoDto> list = interestedAreaService.getScreeningCenterInfoList(gugun);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
