package com.ssafy.happyhouse.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.MemberDto;
@Mapper
public interface MemberDao {
	public void registerMember(MemberDto memberDto);
	public MemberDto modifyMember(MemberDto memberDto);
	
}
