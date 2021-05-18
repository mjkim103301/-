package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.NoticeDto;
import com.ssafy.happyhouse.service.NoticeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api(value="HappyHouse" , description="게시글 관련 컨트롤러")
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private NoticeService noticeService;

	@ApiOperation(value = "검색하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "key", value = "검색조건", required = false, dataType = "string", paramType = "query", defaultValue = ""),
		// 입력 받을 파라미터 명시
		@ApiImplicitParam(name = "word", value = "검색어", required = false, dataType = "string", paramType = "query", defaultValue = "")
		// 입력 받을 파라미터 명시
	})
	@GetMapping("/article")
	public ResponseEntity<List<NoticeDto>> listArticle(@RequestParam(required = false) Map<String, String> paramMap){

		List<NoticeDto> result = noticeService.listArticle(paramMap.get("key"), paramMap.get("word"));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
