package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.NoticeDto;
import com.ssafy.happyhouse.service.NoticeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		@ApiImplicitParam(name = "key", value = "검색조건", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "word", value = "검색어", dataType = "string", paramType = "query")
	})
	@GetMapping("/article")
	public ResponseEntity<List<NoticeDto>> listArticle(@RequestParam(required = false) Map<String, String> paramMap){

		List<NoticeDto> result = noticeService.listArticle(paramMap.get("key"), paramMap.get("word"));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@ApiOperation(value = "글 상세보기")
	@GetMapping("/article/{articleNo}")
	public ResponseEntity<NoticeDto> getArticle(@PathVariable int articleNo){
		NoticeDto noticeDto = noticeService.getArticle(articleNo);
		if(noticeDto == null)   {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(noticeDto, HttpStatus.OK);
	}

	@ApiOperation(value = "글 작성")
	@PostMapping("/article/write")
	public ResponseEntity<Void> writeArticle(@RequestBody NoticeDto noticeDto){
		noticeService.writeArticle(noticeDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@ApiOperation(value = "글 삭제")
	@DeleteMapping("/article/{articleNo}")
	public ResponseEntity<Void> removeArticle(@PathVariable int articleNo) {
		noticeService.removeArticle(articleNo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

