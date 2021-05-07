package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.MemberDto;

public interface MemberService {
	public MemberDto login(String userid, String userpwd);
	public String findMemberPwd(MemberDto member);
	public void updateMember(MemberDto member);
	public void registerMember(MemberDto member);
	public boolean duplicatedIdCheck(String userid);
}
