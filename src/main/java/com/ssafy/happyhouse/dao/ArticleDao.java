package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.ArticleDto;
import com.ssafy.happyhouse.dto.ArticlePageBean;
import com.ssafy.happyhouse.dto.ReplyDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ArticleDao {
//	글작성
//	void registerArticle(Connection conn, NoticeDto noticeDto) throws SQLException;
//	글목록
//	List<NoticeDto> listArticle(Connection conn,String key, String word) throws SQLException; //검색을 위한 key -> 제목, 작성자 등 분류 word->제목
//	글수정을 위한 글얻기
//	NoticeDto getArticle(int articleNo) throws SQLException;
//	글수정
	void modifyArticle(ArticleDto articleDto) throws SQLException;
//	글삭제
//	void deleteArticle(int articleNo) throws SQLException;
	int totalCount(Connection conn, ArticlePageBean bean) throws SQLException;



//	List<NoticeDto> listArticle(Map<String, String> map);
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
