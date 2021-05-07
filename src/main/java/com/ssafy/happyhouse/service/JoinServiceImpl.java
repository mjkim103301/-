package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.JoinDao;
import com.ssafy.model.dao.JoinDaoImpl;
import com.ssafy.model.dto.JoinDto;
import com.ssafy.model.dto.MemberDto;

public class JoinServiceImpl implements JoinService {
	JoinDao dao = new JoinDaoImpl();

	@Override
	public JoinDto getUser(String name) throws SQLException {
		return null;
	}

	@Override
	public List<JoinDto> listUser(String key,String word) throws SQLException {
		return dao.listUser(key,word);
	}

	@Override
	public void registMember(JoinDto joinDto) throws SQLException {
		dao.insertUser(joinDto);
	}

	@Override
	public void deleteMember(String userId) throws SQLException {
		dao.deleteMember(userId);
	}

	@Override
	public boolean isDuplicatedId(MemberDto memberDto){
		boolean result=true;
		try {
			result=dao.isDuplicatedId(memberDto);
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		
		return result;
	}

}