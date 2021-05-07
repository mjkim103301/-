package com.ssafy.happyhouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.dto.NoticeDto;
import com.ssafy.happyhouse.dto.PageBean;

import ch.qos.logback.core.db.dialect.DBUtil;


public class NoticeDaoImpl implements NoticeDao {

	@Override
	public void registerArticle(Connection conn,NoticeDto noticeDto) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			StringBuilder insertNotice = new StringBuilder();
			insertNotice.append("insert into notice (userid, subject, content, regtime) \n");
			insertNotice.append("values (?, ?, ?, now())");
			pstmt = conn.prepareStatement(insertNotice.toString());
			pstmt.setString(1, noticeDto.getUserId());
			pstmt.setString(2, noticeDto.getSubject());
			pstmt.setString(3, noticeDto.getContent());
			pstmt.executeUpdate();
		} finally {
			//DBUtil.close(pstmt, conn);
		}

	}

	@Override
	public List<NoticeDto> listArticle(Connection conn, String key, String word) throws SQLException {
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuilder sql = new StringBuilder(50);
			sql.append("select articleno, userid, subject, content, regtime\n");
			sql.append("from notice                                   \n");
			if (!word.isEmpty()) {
				if ("subject".equals(key)) {
					sql.append("where subject like ?                     \n");
				} else {
					sql.append("where " + key + "= ?                     \n");
				}
			}
			sql.append("order by articleno desc");
			pstmt=conn.prepareStatement(sql.toString());
			
			if (!word.isEmpty()) {
				if ("subject".equals(key)) {
					pstmt.setString(1, "%"+word+"%");
				}else {
					pstmt.setString(1, word);
				}
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				NoticeDto dto=new NoticeDto();
				dto.setArticleNo(rs.getInt("articleno"));
				dto.setUserId((rs.getString("userid")));
				dto.setSubject((rs.getString("subject")));
				dto.setContent((rs.getString("content")));
				dto.setRegtime((rs.getString("regtime")));
				list.add(dto);
			}
		} finally {
			//DBUtil.close(rs,pstmt,conn);
		}
		return list;
	}

	@Override
	public NoticeDto getArticle(int articleNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDto noticeDto=null;
		
		try {
			//conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" select * \n");
			sql.append(" from notice \n");
			sql.append(" where articleNo = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, articleNo);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				noticeDto=new NoticeDto();
				noticeDto.setArticleNo(rs.getInt("articleno"));
				noticeDto.setUserId((rs.getString("userid")));
				noticeDto.setSubject((rs.getString("subject")));
				noticeDto.setContent((rs.getString("content")));
				noticeDto.setRegtime((rs.getString("regtime")));
			}
		} finally {
//			DBUtil.close(rs);
//			DBUtil.close(pstmt);
//			DBUtil.close(conn);
		}
		return noticeDto;
	}

	@Override
	public void modifyArticle(NoticeDto noticeDto) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//conn = DBUtil.getConnection();
			String sql = " delete from notice where articleNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, articleNo);
			pstmt.executeUpdate();
		} finally {
//			DBUtil.close(pstmt);
//			DBUtil.close(conn);
		}
	}

	@Override
	public int totalCount(Connection conn, PageBean bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
