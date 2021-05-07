package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dao.MemberDao;
import com.ssafy.happyhouse.dao.MemberDaoImpl;
import com.ssafy.happyhouse.dto.MemberDto;

public class ModifyServiceImpl {
	private MemberDao dao=MemberDaoImpl.getMemberDao();
	
	public void modifyMember(MemberDto memberDto) {
		dao.modifyMember(memberDto);
	}
}
