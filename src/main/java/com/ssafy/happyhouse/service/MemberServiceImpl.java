package com.ssafy.happyhouse.service;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.MemberDao;
import com.ssafy.happyhouse.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public MemberDto login(String userId, String userPwd) {
		// TODO Auto-generated method stub
		MemberDto memberDto = memberDao.getMember(userId);
		
		if(memberDto == null || !memberDto.getUserpwd().equals(userPwd)) {
			return null;
		}
		
		return memberDto;
	}

}
