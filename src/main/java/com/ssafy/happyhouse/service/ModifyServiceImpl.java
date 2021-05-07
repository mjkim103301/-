package com.ssafy.happyhouse.service;

import com.ssafy.model.dao.MemberDao;
import com.ssafy.model.dao.MemberDaoImpl;
import com.ssafy.model.dto.MemberDto;


public class ModifyServiceImpl {
	private MemberDao dao=MemberDaoImpl.getMemberDao();
	
	public void modifyMember(MemberDto memberDto) {
		dao.modifyMember(memberDto);
	}
}
