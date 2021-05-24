package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.dto.ArticlePageBean;
import com.ssafy.happyhouse.dto.ArticleDto;
import com.ssafy.happyhouse.dto.PageNavigation;
import com.ssafy.happyhouse.service.ArticleService;
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
@RequestMapping("/board")

@Api(value="HappyHouse" , description="게시글 관련 컨트롤러")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private ArticleService articleService;

	@ApiOperation(value = "검색하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "key", value = "검색조건", dataType = "string", paramType = "query")
		, @ApiImplicitParam(name = "word", value = "검색어", dataType = "string", paramType = "query")
		, @ApiImplicitParam(name = "page", value = "페이지", dataType = "string", paramType = "query")
		, @ApiImplicitParam(name = "articleType", value = "게시판 종류", dataType = "string", paramType = "query")
	})

	@GetMapping("")
	public ResponseEntity<List<ArticleDto>> listArticle(@RequestParam(required = false) Map<String, String> params){
		System.out.println(">>>>>moveArticle" + params.get("articleType"));
		List<ArticleDto> result = articleService.listArticle(params);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@ApiOperation(value = "페이지 네비게이션 받기")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "key", value = "검색조건", dataType = "string", paramType = "query")
		, @ApiImplicitParam(name = "word", value = "검색어", dataType = "string", paramType = "query")
		, @ApiImplicitParam(name = "page", value = "페이지", dataType = "string", paramType = "query")
		, @ApiImplicitParam(name = "articleType", value = "게시판 종류", dataType = "string", paramType = "query")
	})
	@GetMapping("/pageNavigation")
	public ResponseEntity<PageNavigation> getPageNavigation(@RequestParam(required = false) Map<String, String> params){
		PageNavigation pageNavigation = articleService.getPageNavigation(params);
		System.out.println("pageNavigation created" + pageNavigation);
		return new ResponseEntity<>(pageNavigation, HttpStatus.OK);
	}

	@ApiOperation(value = "글 상세보기")
	@GetMapping("/{articleId}")
	public ResponseEntity<ArticleDto> getArticle(@PathVariable int articleId){
		System.out.println("GET /board/{articleId} => ");
		ArticleDto articleDto = articleService.getArticle(articleId);
		if(articleDto == null)   {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(articleDto, HttpStatus.OK);
	}

	@ApiOperation(value = "글 작성")
	@PostMapping("/write")
	public ResponseEntity<Void> writeArticle(@RequestBody ArticleDto articleDto){
		articleService.writeArticle(articleDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@ApiOperation(value = "글 삭제")
	@DeleteMapping("/{articleId}")
	public ResponseEntity<Void> removeArticle(@PathVariable int articleId) {
		articleService.removeArticle(articleId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "글 수정")
	@PutMapping("/update")
	public ResponseEntity<Void> updateArticle(@RequestBody ArticleDto articleDto) {
		articleService.updateArticle(articleDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
