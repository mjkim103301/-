package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.*;
import com.ssafy.happyhouse.dto.pagedto.PageNavigation;
import com.ssafy.happyhouse.dto.pagedto.ReplyPageBean;

import java.util.List;


public interface ReplyService {
	void writeReply(ReplyDto replyDto);
	List<ReplyDto> listReply(ReplyPageBean bean);
	void removeReply(int replyId);
	PageNavigation getReplyNavigation(int articleId, int page);
	void updateReply(ReplyDto replyDto);
}
