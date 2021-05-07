package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.model.dto.NoticeDto;

public interface NoticeService {
//	글작성
	void registerArticle(NoticeDto noticeDto) throws Exception;
//	글목록
	List<NoticeDto> listArticle(String key, String word) throws Exception; //검색을 위한 key -> 제목, 작성자 등 분류 word->제목
//	글수정을 위한 글얻기
	NoticeDto getArticle(int articleNo) throws Exception;
//	글수정
	void modifyArticle(NoticeDto noticeDto) throws Exception;
//	글삭제
	void deleteArticle(int articleNo) throws Exception;
}
