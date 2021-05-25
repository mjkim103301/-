package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dao.AdminDao;
import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.pagedto.PageNavigation;
import com.ssafy.happyhouse.dto.pagedto.UserListPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	public List<UserDto> getUserList(Map<String, String> paramsMap) {
		UserListPageBean userListPageBean = new UserListPageBean(paramsMap.get("key")
			,paramsMap.get("word"), paramsMap.get("page"));
		System.out.println("[service] userListPageBean created : " + userListPageBean);
		return adminDao.getUserList(userListPageBean);
	}

	@Override
	public PageNavigation getPageNavigation(Map<String, String> paramsMap) {
		UserListPageBean userListPageBean = new UserListPageBean(paramsMap.get("key")
				,paramsMap.get("word"), paramsMap.get("page"));
		int totalUserCount = adminDao.getTotalUserCount(userListPageBean);
		int totalPageCount = (totalUserCount - 1) / UserListPageBean.getUserListInterval() + 1;
		int page = paramsMap.get("page") == null ? 1 : Integer.parseInt(paramsMap.get("page"));

		return new PageNavigation(page, 10, totalPageCount);
	}

	@Override
	public void removeUser(String userId) {
		adminDao.removeUser(userId);
	}
}
