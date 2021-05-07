package com.ssafy.happyhouse.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.MemberDto;
@Mapper
public interface LoginDao {
	public MemberDto login(String userid, String userpwd) throws SQLException;
	public MemberDto getMember(String username,String userid,String useremail) throws SQLException;
}
