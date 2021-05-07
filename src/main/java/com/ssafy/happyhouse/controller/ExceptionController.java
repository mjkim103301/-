package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// 개별 Controller Exception 처리
// 일반 요청 및 ajax 요청 모두를 처리하려면 ajax 요청을 구분할 수 있는 reqeuest header 등을 활용해서 처리를 구분해야 함.
@Controller
public class ExceptionController {

	@GetMapping(value="/exception")
	private void makeException() throws Exception{
		//throw new RuntimeException();
		//System.out.println(">>>sqlexception");
		throw new SQLException();
	}
	
	// 예외처리와 함께 부가정보를 제공할 경우
	// 브라우저 주소 이용 테스트
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleErrorView(HttpServletRequest req, Exception ex) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", ex);
//		mav.addObject("url", req.getRequestURL());
//		mav.setViewName("error");
//		return mav;
//	}
	
	// 단순한 예외 페이지로 분기
	// 브라우저 주소 이용 테스트
//	@ExceptionHandler(Exception.class)
//	public String handleErrorView() {
//		System.out.println(">>>handle error view");
//		return "error";
//	}
	
	// SQLException 과 IOException 이 발생하면 여기서 Handling
	// 브라우저 주소 이용 테스트
	// RuntimeException 발생 시 이곳에서 처리하지 않고, GlobalExceptionHandler 에서 처리
	@ExceptionHandler({ SQLException.class, IOException.class })
	public String handleErrorViewSQL() {
		return "error/error";
	}
	
	// ajax 요청에 대한 exception 처리
	// Test.html 이용 테스트
	// String 이 아닌 다른 자료구조를 JSON 으로 추가 정보를 보낼 수 있음.
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleErrorResponseEntity() {		
//		return new ResponseEntity<String>("ajax_controller_exception", HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
