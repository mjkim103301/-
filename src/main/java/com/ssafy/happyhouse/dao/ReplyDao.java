package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.ArticleDto;
import com.ssafy.happyhouse.dto.ArticlePageBean;
import com.ssafy.happyhouse.dto.ReplyDto;
import com.ssafy.happyhouse.dto.ReplyPageBean;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyDao {
	int getTotalReplyPageCount(ReplyPageBean bean);
	void writeReply(ReplyDto replyDto);
	List<ReplyDto> listReply(ReplyPageBean bean);
	void removeReply(int replyId);
}
