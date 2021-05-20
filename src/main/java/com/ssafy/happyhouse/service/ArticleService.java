package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.ArticleDto;
import com.ssafy.happyhouse.dto.ArticlePageBean;
import com.ssafy.happyhouse.dto.ReplyDto;
import java.util.List;


public interface ArticleService {
//	글작성
	void writeArticle(ArticleDto articleDto);
//	글목록
	List<ArticleDto> listArticle(ArticlePageBean articlePageBean); //검색을 위한 key -> 제목, 작성자 등 분류 word->제목
//	글수정을 위한 글얻기
	int getTotalPageCount(ArticlePageBean articlePageBean);

	ArticleDto getArticle(int articleNo);
//	글수정
	void updateArticle(ArticleDto articleDto);
//	글삭제
	void removeArticle(int articleNo);

	void writeReply(ReplyDto replyDto);

	List<ReplyDto> listReply(int articleNo);

	void removeReply(int id);
}
