package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.NoticeDto;
import com.ssafy.happyhouse.dto.ReplyDto;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@RequestMapping("/article")
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
	@GetMapping("/")
	public ResponseEntity<List<NoticeDto>> listArticle(@RequestParam(required = false) Map<String, String> paramMap){

		List<NoticeDto> result = noticeService.listArticle(paramMap.get("key"), paramMap.get("word"));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@ApiOperation(value = "글 상세보기")
	@GetMapping("/{articleNo}")
	public ResponseEntity<NoticeDto> getArticle(@PathVariable int articleNo){
		NoticeDto noticeDto = noticeService.getArticle(articleNo);
		if(noticeDto == null)   {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(noticeDto, HttpStatus.OK);
	}

	@ApiOperation(value = "글 작성")
	@PostMapping("/write")
	public ResponseEntity<Void> writeArticle(@RequestBody NoticeDto noticeDto){
		noticeService.writeArticle(noticeDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@ApiOperation(value = "글 삭제")
	@DeleteMapping("/{articleNo}")
	public ResponseEntity<Void> removeArticle(@PathVariable int articleNo) {
		noticeService.removeArticle(articleNo);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "글 수정")
	@PutMapping("/update")
	public ResponseEntity<Void> updateArticle(@RequestBody NoticeDto noticeDto) {
		noticeService.updateArticle(noticeDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@ApiOperation(value = "댓글 쓰기")
	@PostMapping("/{articleNo}/reply")
	public ResponseEntity<Void> writeReply(@RequestBody ReplyDto replyDto){
		noticeService.writeReply(replyDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "댓글 불러오기")
	@GetMapping("/{articleNo}/reply")
	public ResponseEntity<List<ReplyDto>> listReply(@PathVariable int articleNo){
		return new ResponseEntity<>(noticeService.listReply(articleNo), HttpStatus.OK);
	}

	@ApiOperation(value = "댓글 삭제")
	@DeleteMapping("/{articleNo}/{id}")
	public ResponseEntity<Void> removeReply(@PathVariable int id){
		noticeService.removeReply(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
