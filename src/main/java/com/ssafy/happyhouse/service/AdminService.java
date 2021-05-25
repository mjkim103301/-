package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.pagedto.PageNavigation;

import java.util.List;
import java.util.Map;

public interface AdminService {
	List<UserDto> getUserList(Map<String, String> paramsMap);
	PageNavigation getPageNavigation(Map<String, String> paramsMap);

	void removeUser(String userId);
}
