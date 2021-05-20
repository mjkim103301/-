package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.UserDto;

public interface UserService {
	UserDto login(String userId, String userPwd);
	String findMemberPwd(UserDto userDto);
	void updateMember(UserDto userDto);
	void registerMember(UserDto userDto);
	boolean duplicatedIdCheck(String userDto);
}
