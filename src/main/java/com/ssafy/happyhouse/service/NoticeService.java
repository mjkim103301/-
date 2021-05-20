package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.dto.ReplyDto;
import java.util.List;

import com.ssafy.happyhouse.dto.NoticeDto;


public interface NoticeService {
//	글작성
	void writeArticle(NoticeDto noticeDto);
//	글목록
	List<NoticeDto> listArticle(PageBean pageBean); //검색을 위한 key -> 제목, 작성자 등 분류 word->제목
//	글수정을 위한 글얻기
	int getTotalPageCount(PageBean pageBean);

	NoticeDto getArticle(int articleNo);
//	글수정
	void updateArticle(NoticeDto noticeDto);
//	글삭제
	void removeArticle(int articleNo);

	void writeReply(ReplyDto replyDto);

	List<ReplyDto> listReply(int articleNo);

	void removeReply(int id);
}
