package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
//	public UserDto modifyMember(UserDto userDto);
	
	
	public UserDto getMember(String userId);
	public String getMemberPwd(UserDto userDto);
	public void updateMember(UserDto userDto);
	public void registerMember(UserDto userDto);
}
