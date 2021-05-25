package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.pagedto.PageNavigation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public List<UserDto> getUserList(Map<String, String> paramsMap) {
		return null;
	}

	@Override
	public PageNavigation getPageNavigation(Map<String, String> paramsMap) {
		return null;
	}

	@Override
	public void removeUser(int userId) {

	}
}
