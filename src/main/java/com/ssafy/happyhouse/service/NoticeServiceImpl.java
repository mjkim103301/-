package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.dto.ReplyDto;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.NoticeDao;
import com.ssafy.happyhouse.dto.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao noticeDao;

	@Transactional
	@Override
	public void writeArticle(NoticeDto noticeDto) {
		noticeDao.writeArticle(noticeDto);
	}

	@Override
	public List<NoticeDto> listArticle(PageBean pageBean) {
		return noticeDao.listArticle(pageBean);
	}

	@Override
	public int getTotalPageCount(PageBean pageBean){
		return noticeDao.getTotalPageCount(pageBean)/pageBean.getInterval() + 1;
	}

	@Transactional
	@Override
	public NoticeDto getArticle(int articleNo) {
		noticeDao.hitArticle(articleNo);
		return noticeDao.getArticle(articleNo);
	}

	@Transactional
	@Override
	public void updateArticle(NoticeDto noticeDto){
		// TODO Auto-generated method stub
		noticeDao.updateArticle(noticeDto);
	}

	@Transactional
	@Override
	public void removeArticle(int articleNo) {
		noticeDao.removeArticle(articleNo);
	}

	@Override
	public void writeReply(ReplyDto replyDto) {
		noticeDao.writeReply(replyDto);
	}

	@Override
	public List<ReplyDto> listReply(int articleNo) {
		return noticeDao.listReply(articleNo);
	}

	@Override
	public void removeReply(int id) {
		noticeDao.removeReply(id);
	}

}
