package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.ArticleDto;
import com.ssafy.happyhouse.dto.ArticlePageBean;
import com.ssafy.happyhouse.dto.ReplyDto;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.ArticleDao;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDao articleDao;

	@Transactional
	@Override
	public void writeArticle(ArticleDto articleDto) {
		articleDao.writeArticle(articleDto);
	}

	@Override
	public List<ArticleDto> listArticle(ArticlePageBean articlePageBean) {
		return articleDao.listArticle(articlePageBean);
	}

	@Override
	public int getTotalPageCount(ArticlePageBean articlePageBean){
		return articleDao.getTotalPageCount(articlePageBean)/ articlePageBean.getArticleInterval() + 1;
	}

	@Transactional
	@Override
	public ArticleDto getArticle(int articleNo) {
		articleDao.hitArticle(articleNo);
		return articleDao.getArticle(articleNo);
	}

	@Transactional
	@Override
	public void updateArticle(ArticleDto articleDto){
		articleDao.updateArticle(articleDto);
	}

	@Transactional
	@Override
	public void removeArticle(int articleNo) {
		articleDao.removeArticle(articleNo);
	}
}
