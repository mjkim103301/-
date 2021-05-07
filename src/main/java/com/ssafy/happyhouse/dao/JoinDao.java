package com.ssafy.happyhouse.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.JoinDto;
import com.ssafy.model.dto.MemberDto;

public interface JoinDao {
	
	public void insertUser(JoinDto joinDto) throws SQLException;
	public JoinDto getUser(String name) throws SQLException;
	public List<JoinDto> listUser(String key, String user) throws SQLException;
	public void deleteMember(String userId) throws SQLException;
	public boolean isDuplicatedId(MemberDto memberDto) throws SQLException;
}
