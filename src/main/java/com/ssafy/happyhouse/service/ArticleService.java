package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.ArticleDto;
import com.ssafy.happyhouse.dto.pagedto.PageNavigation;

import java.util.List;
import java.util.Map;


public interface ArticleService {
	void writeArticle(ArticleDto articleDto);
	//검색을 위한 key -> 제목, 작성자 등 분류 word->제목
	List<ArticleDto> listArticle(Map<String, String> params);
	PageNavigation getPageNavigation(Map<String, String> params);
	ArticleDto getArticle(int articleNo);
	void updateArticle(ArticleDto articleDto);
	void removeArticle(int articleNo);
}
