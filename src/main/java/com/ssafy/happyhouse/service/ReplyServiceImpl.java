package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dao.ArticleDao;
import com.ssafy.happyhouse.dao.ReplyDao;
import com.ssafy.happyhouse.dto.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDao replyDao;

	@Override
	public void writeReply(ReplyDto replyDto) {
		replyDao.writeReply(replyDto);
	}

	@Override
	public List<ReplyDto> listReply(ReplyPageBean bean) {
		return replyDao.listReply(bean);
	}

	@Override
	public void removeReply(int id) {
		replyDao.removeReply(id);
	}

	@Override
	public PageNavigation getReplyNavigation(int articleId, int page) {
		int totalReplyCount = replyDao.getTotalReplyPageCount(articleId);
		int totalPageCount = (totalReplyCount - 1) / ReplyPageBean.getReplyInterval() + 1;
		return new PageNavigation(page, 10, totalPageCount);
	}

}
