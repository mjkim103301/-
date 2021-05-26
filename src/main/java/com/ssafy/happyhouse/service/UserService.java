package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.UserDto;

public interface UserService {
	UserDto login(String userId, String userPwd);
	String findUserPwd(UserDto userDto);
	void updateUser(UserDto userDto);
	void registerUser(UserDto userDto);
	boolean duplicatedIdCheck(String userDto);
	void removeUser(String userId);
}
