package com.ssafy.happyhouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.happyhouse.dto.JoinDto;
import com.ssafy.happyhouse.dto.MemberDto;

import ch.qos.logback.core.db.dialect.DBUtil;


public class JoinDaoImpl implements JoinDao {

	@Override
	public void insertUser(JoinDto joinDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String userId = joinDto.getUserId();
		String userName = joinDto.getUserName();
		String userPwd = joinDto.getUserPwd();
		String email = joinDto.getEmail();
		String address = joinDto.getAddress();

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into member values(?,?,?,?,?,?); \n");
		//	conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			// pstmt.setString(1, no);
			pstmt.setString(1, userId);
			pstmt.setString(2, userName);
			pstmt.setString(3, userPwd);
			pstmt.setString(4, email);
			pstmt.setString(5, address);
			pstmt.setString(6, LocalDateTime.now().toString());
			int result = pstmt.executeUpdate();
			System.out.println("insert result>> " + result);
		} finally {
			//DBUtil.close(pstmt, conn);
		}

	}

	@Override
	public JoinDto getUser(String name) throws SQLException {
		JoinDto joinDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" select * \n");
			sql.append("from member \n");
			sql.append("where name = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				joinDto = new JoinDto();

				joinDto.setUserId(rs.getString("userid"));
				joinDto.setUserName(rs.getString("name"));
				joinDto.setEmail(rs.getString("email"));
				joinDto.setAddress(rs.getString("address"));
			}

		} finally {
//			DBUtil.close(rs);
//			DBUtil.close(pstmt);
//			DBUtil.close(conn);
		}
		return joinDto;
	}

	@Override
	public List<JoinDto> listUser(String key, String word) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<JoinDto> list = new LinkedList<JoinDto>();

		try {
			//conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(50);
			sql.append("select userid, username, email, address\n");
			sql.append("from member                                   \n");
			if (!word.equals("")) {
				sql.append("where " + key + " like ?                     \n");
			}
			pstmt = conn.prepareStatement(sql.toString());

			if (!word.equals("")) {
				pstmt.setString(1, "%" + word + "%");
			}
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println(rs);
			while (rs.next()) {
				JoinDto joinDto = new JoinDto();

				joinDto.setUserId(rs.getString("userid"));
				joinDto.setUserName(rs.getString("username"));
				joinDto.setEmail(rs.getString("email"));
				joinDto.setAddress(rs.getString("address"));
				list.add(joinDto);
				System.out.println(rs.getString("userid"));
			}
		} finally {
			//DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public void deleteMember(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			//conn = DBUtil.getConnection();
			String sql = " delete from member where userId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
		} finally {
//			DBUtil.close(pstmt);
//			DBUtil.close(conn);
		}
	}

	@Override
	public boolean isDuplicatedId(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
		//	conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT userid FROM member WHERE userid=?");

			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getUserid());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = true; // 해당 아이디 존재
			}
			

		} finally {
		//	DBUtil.close(conn, pstmt, rs);
		}

		return result;

	}
}