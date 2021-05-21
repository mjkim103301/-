package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.ArticleDto;
import com.ssafy.happyhouse.dto.ArticlePageBean;
import com.ssafy.happyhouse.dto.ReplyDto;
import com.ssafy.happyhouse.dto.ReplyPageBean;
import java.util.List;


public interface ReplyService {
	void writeReply(ReplyDto replyDto);
	List<ReplyDto> listReply(ReplyPageBean bean);
	void removeReply(int id);
}
