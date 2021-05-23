package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.PageNavigation;
import com.ssafy.happyhouse.dto.ReplyDto;
import com.ssafy.happyhouse.dto.ReplyPageBean;
import com.ssafy.happyhouse.service.ReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/board/{articleId}/reply")

@Api(value="댓글 컨트롤러 ")
public class ReplyController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private ReplyService replyService;

	@ApiOperation(value = "댓글 쓰기")
	@PostMapping("")
	public ResponseEntity<Void> writeReply(@RequestBody ReplyDto replyDto){
		System.out.println(">>>move POST /board/{article}/reply");
		replyService.writeReply(replyDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "댓글 불러오기")
	@GetMapping("/{pageNo}")
	public ResponseEntity<List<ReplyDto>> listReply(@PathVariable int articleId, @PathVariable int pageNo){
		ReplyPageBean replyPageBean = new ReplyPageBean(articleId, pageNo);
		System.out.println(">>>move GET /board/{article}/reply/{pageNo}");
		return new ResponseEntity<>(replyService.listReply(replyPageBean), HttpStatus.OK);
	}

	@ApiOperation(value = "댓글 페이지 네비게이션")
	@GetMapping("/{pageNo}/navigation")
	public ResponseEntity<PageNavigation> getReplyNavigation(@PathVariable int articleId, @PathVariable int pageNo){
		System.out.println(">>>move GET /board/{article}/reply/{pageNo}navgation");
		return new ResponseEntity<>(replyService.getReplyNavigation(articleId, pageNo), HttpStatus.OK);
	}


	@ApiOperation(value = "댓글 삭제")
	@DeleteMapping("/{replyId}")
	public ResponseEntity<Void> removeReply(@PathVariable int replyId){
		System.out.println(">>>move DELETE /board/{article}/reply/{replyID}");
		replyService.removeReply(replyId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
