package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.UserDto;

import com.ssafy.happyhouse.dto.pagedto.UserListPageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao {
	List<UserDto> getUserList(UserListPageBean userListPageBean);
	void removeUser(int userId);
	int getTotalUserCount(UserListPageBean userListPageBean);
}
