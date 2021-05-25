package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.ArticleDto;
import com.ssafy.happyhouse.dto.pageDto.ArticlePageBean;
import com.ssafy.happyhouse.dto.ReplyDto;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ArticleDao {
	List<ArticleDto> listArticle(ArticlePageBean articlePageBean);
	int getTotalPageCount(ArticlePageBean bean);

	ArticleDto getArticle(int articleNo);
	void hitArticle(int articleNo);
	void writeArticle(ArticleDto articleDto);
	void removeArticle(int articleNo);
	void updateArticle(ArticleDto articleDto);


	void writeReply(ReplyDto replyDto);
	List<ReplyDto> listReply(int articleNo);
	void removeReply(int id);
}
