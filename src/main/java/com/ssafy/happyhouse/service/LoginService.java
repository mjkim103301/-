package com.ssafy.happyhouse.service;

import java.sql.SQLException;

import com.ssafy.model.dto.MemberDto;

public interface LoginService {
	public MemberDto login(String userid, String userpwd) throws Exception;
	public MemberDto getMember(String username,String userid,String useremail) throws SQLException;
}
