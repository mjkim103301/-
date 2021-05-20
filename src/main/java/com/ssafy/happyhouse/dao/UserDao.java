package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
//	public UserDto modifyMember(UserDto userDto);
	UserDto getUser(String userId);

	String getUser(UserDto userDto);

	void updateUser(UserDto userDto);

	void registerUser(UserDto userDto);
}
