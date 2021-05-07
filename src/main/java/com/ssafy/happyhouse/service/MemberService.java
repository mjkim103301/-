package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.MemberDto;

public interface MemberService {
	public MemberDto login(String userid, String userpwd);
	public String findUserpwd(MemberDto member);
}
