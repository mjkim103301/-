package com.ssafy.happyhouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.happyhouse.dto.MemberDto;

import ch.qos.logback.core.db.dialect.DBUtil;


public class MemberDaoImpl implements MemberDao {

	//싱글톤 적용
	private static MemberDao memberDao;
	
	public MemberDaoImpl() {}

	public static MemberDao getMemberDao() {
		if(memberDao == null)
			memberDao = new MemberDaoImpl();
		return memberDao;
	}
	
	@Override
	public void registerMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//conn = DBUtil.getConnection();
			//String sql = "INSERT INTO members (id, password, name, address, phone) VALUES (?, ?, ?, ?, ?)";
			String sql = "INSERT INTO ssafymember (userid, userpwd, name, address, email) VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getUserid());
			pstmt.setString(2, memberDto.getUserpwd());
			pstmt.setString(3, memberDto.getUsername());
			pstmt.setString(4, memberDto.getEmail());
			pstmt.setString(5, memberDto.getAddress());
			int num = pstmt.executeUpdate();
			if (num > 0) System.out.println("Inserted Successfully " + memberDto.getUserid());
			else System.err.println("Insert Failed");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DBUtil.close(rs, pstmt, conn);
		}
		
	}

	@Override
	public MemberDto modifyMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		System.out.println("MemberDto modifyMember>>>>>> pwd: "+memberDto.getUserpwd()+" "+memberDto.getUsername()+ " "+memberDto.getAddress()+" "+memberDto.getEmail()+" "+ memberDto.getUserid());
	
		try {
			 StringBuilder sql = new StringBuilder();
			//conn = DBUtil.getConnection();
			
			sql.append("UPDATE member SET userpwd = ?, username = ? , address = ? , email = ? WHERE userid = ? ;");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getUserpwd());
			pstmt.setString(2, memberDto.getUsername());
			pstmt.setString(3, memberDto.getAddress());
			pstmt.setString(4, memberDto.getEmail());
			pstmt.setString(5, memberDto.getUserid());
			int num = pstmt.executeUpdate();
			System.out.println("num>>>> "+num);
			if (num > 0) {
				System.out.println("Updated Successfully " + memberDto.getUserid());
			}else {
				System.err.println("Updated Failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			//DBUtil.close(pstmt, conn);
		}
		
		return memberDto;
	}

	@Override
	public MemberDto getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
