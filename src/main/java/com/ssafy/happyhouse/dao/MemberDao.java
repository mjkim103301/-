package com.ssafy.happyhouse.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.MemberDto;

@Mapper
public interface MemberDao {
	public MemberDto modifyMember(MemberDto memberDto);
	
	
	public MemberDto getMember(String userId);
	public String getMemberPwd(MemberDto member);
	public void updateMember(MemberDto member);
	public void registerMember(MemberDto member);
}
