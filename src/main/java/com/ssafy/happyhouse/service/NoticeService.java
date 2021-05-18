package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.NoticeDto;


public interface NoticeService {
//	글작성
	void writeArticle(NoticeDto noticeDto);
//	글목록
	List<NoticeDto> listArticle(String key, String word); //검색을 위한 key -> 제목, 작성자 등 분류 word->제목
//	글수정을 위한 글얻기
	NoticeDto getArticle(int articleNo);
//	글수정
	void modifyArticle(NoticeDto noticeDto);
//	글삭제
	void removeArticle(int articleNo);
}
