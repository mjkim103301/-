package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.ArticleDto;
import com.ssafy.happyhouse.dto.ArticlePageBean;
import com.ssafy.happyhouse.dto.ReplyDto;
import java.util.List;


public interface ArticleService {
	void writeArticle(ArticleDto articleDto);
	//검색을 위한 key -> 제목, 작성자 등 분류 word->제목
	List<ArticleDto> listArticle(ArticlePageBean articlePageBean);
	int getTotalPageCount(ArticlePageBean articlePageBean);
	ArticleDto getArticle(int articleNo);
	void updateArticle(ArticleDto articleDto);
	void removeArticle(int articleNo);
}
