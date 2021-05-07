package com.ssafy.happyhouse.dao;

import com.ssafy.model.dto.MemberDto;

public interface MemberDao {
	public void registerMember(MemberDto memberDto);
	public MemberDto modifyMember(MemberDto memberDto);
	
}
