package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDto login(String userId, String userPwd) {
		// TODO Auto-generated method stub
		UserDto userDto = userDao.getUser(userId);
		
		if(userDto == null || !userDto.getUserPwd().equals(userPwd)) {
			return null;
		}
		return userDto;
	}

	@Override
	public String findUserPwd(UserDto userDto) {
		// TODO Auto-generated method stub
		String userPwd = userDao.getUserPwd(userDto);
		
		if(userPwd == null || userPwd.equals("")) {
			return null;
		}
		return userPwd;
	}

	@Transactional
	@Override
	public void updateUser(UserDto userDto) {
		userDao.updateUser(userDto);
	}

	@Override
	@Transactional
	public void registerUser(UserDto userDto) {
		// TODO Auto-generated method stub
		userDao.registerUser(userDto);
	}

	@Override
	public boolean duplicatedIdCheck(String userId) {
		// TODO Auto-generated method stub
		UserDto userDto = userDao.getUser(userId);
		if(userDto != null) {
			return false;
		}
		return true;
	}

	@Override
	public void removeUser(String userId) {
		userDao.removeUser(userId);
	}
	

}
