package com.ssafy.happyhouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.happyhouse.dto.MemberDto;

import ch.qos.logback.core.db.dialect.DBUtil;


public class LoginDaoImpl implements LoginDao {
	@Override
	public MemberDto login(String userid, String userpwd) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDto memberDto=null;
		try {
			//conn=DBUtil.getConnection();
			String sql="select * \n";
			sql+="from member \n";
			sql+="where userid=? and userpwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userid);
			pstmt.setString(2, userpwd);
			rs=pstmt.executeQuery();
	
			if(rs.next()) {
				memberDto=new MemberDto();
				memberDto.setUserid(userid);
				memberDto.setUsername(rs.getString("username"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setJoindate(rs.getString("joindate"));
			}else {
				System.out.println("***************null입력");
			}
			
		}finally {
//				DBUtil.close(rs);
//				DBUtil.close(pstmt);
//				DBUtil.close(conn);
		
		}
		return memberDto;
	}

	@Override
	public MemberDto getMember(String username,String userid,String useremail) throws SQLException {
		MemberDto memberDto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//	conn=DBUtil.getConnection();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" select * \n");
			sql.append(" from member \n");
			sql.append(" where userid = ? and username = ? and email = ?");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, username);
			pstmt.setString(3, useremail);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserpwd(rs.getString("userpwd"));
			}
		} finally {
//			DBUtil.close(rs);
//			DBUtil.close(pstmt);
//			DBUtil.close(conn);
		}
		return memberDto;
	}

}
