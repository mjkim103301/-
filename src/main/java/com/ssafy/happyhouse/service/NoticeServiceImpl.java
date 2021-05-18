package com.ssafy.happyhouse.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.NoticeDao;
import com.ssafy.happyhouse.dto.NoticeDto;

import ch.qos.logback.core.db.dialect.DBUtil;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao noticeDao;
	

//	public void registerArticle(NoticeDto noticeDto) throws Exception {
//		Connection conn=null;
//		try {
//			//conn=DBUtil.getConnection();
//			conn.setAutoCommit(false);
//			noticeDao.registerArticle(conn, noticeDto);
//		}catch (SQLException e) {
//			e.printStackTrace();
//		//	DBUtil.rollback(conn);
//			throw new Exception("게시글 등록 중 오류 발생");
//		}finally {
//			try {
//				conn.commit();
//			}catch (Exception e) {}
//			//DBUtil.close(conn);
//		}
//	}
	@Transactional
	@Override
	public void writeArticle(NoticeDto noticeDto) {
		noticeDao.writeArticle(noticeDto);
	}

	@Override
	public List<NoticeDto> listArticle(String key, String word) {
		Map<String, String> map = new HashMap<>();
		System.out.println("service Key , val  : " + key + " " + word);
		if(key != null){
			map.put("key", key);
		}
		if(word != null){
			map.put("word", word);
		}

		return noticeDao.listArticle(map);
	}

	@Transactional
	@Override
	public NoticeDto getArticle(int articleNo) {
		noticeDao.hitArticle(articleNo);
		return noticeDao.getArticle(articleNo);
	}

	@Transactional
	@Override
	public void modifyArticle(NoticeDto noticeDto){
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public void removeArticle(int articleNo) {
		noticeDao.removeArticle(articleNo);
	}

}
