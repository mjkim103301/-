package com.ssafy.happyhouse.dao;

import java.sql.SQLException;

import com.ssafy.model.dto.MemberDto;

public interface LoginDao {
	public MemberDto login(String userid, String userpwd) throws SQLException;
	public MemberDto getMember(String username,String userid,String useremail) throws SQLException;
}
