package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.ReplyDto;
import com.ssafy.happyhouse.dto.pagedto.ReplyPageBean;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyDao {
	int getTotalReplyPageCount(int articleId);
	void writeReply(ReplyDto replyDto);
	List<ReplyDto> listReply(ReplyPageBean bean);
	void removeReply(int replyId);
	void updateReply(ReplyDto replyDto);
}
