package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.*;

import java.util.List;
import java.util.Map;

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
	public List<ArticleDto> listArticle(Map<String, String> params) {
		ArticlePageBean articlePageBean = new ArticlePageBean(params.get("key")
				, params.get("word"), params.get("page"), params.get("articleType"));

		System.out.println(">>>>>> List Article" + articlePageBean);
		return articleDao.listArticle(articlePageBean);
	}

	@Override
	public PageNavigation getPageNavigation(Map<String, String> params) {
		ArticlePageBean articlePageBean = new ArticlePageBean(params.get("key")
				, params.get("word"), params.get("page"), params.get("articleType"));

		System.out.println("pageBean created"  + articlePageBean);
		int totalArticleCount = articleDao.getTotalPageCount(articlePageBean);
		System.out.println("get total count");
		int totalPageCount = (totalArticleCount - 1) / ArticlePageBean.getArticleInterval() + 1;
		System.out.println(params.get("page"));
		int page = params.get("page") == null ? 1 : Integer.parseInt(params.get("page"));
		return new PageNavigation(page, 10, totalPageCount);
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
