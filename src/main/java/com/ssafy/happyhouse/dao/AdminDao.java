package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.UserDto;

import com.ssafy.happyhouse.dto.pageDto.UserListPageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao {
	List<UserDto> getUserList(UserListPageBean userListPageBean);
	void removeUser(String userId);
	int getTotalUserCount(UserListPageBean userListPageBean);
}
