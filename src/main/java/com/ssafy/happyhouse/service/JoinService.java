package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.JoinDto;
import com.ssafy.model.dto.MemberDto;

public interface JoinService {
	public JoinDto getUser(String name) throws SQLException;
	public List<JoinDto> listUser(String key,String word) throws SQLException;
	public void registMember(JoinDto joinDto) throws SQLException;
	public void deleteMember(String userId) throws SQLException;
	public boolean isDuplicatedId(MemberDto memberDto) throws Exception;
	
}
