package com.ssafy.happyhouse.service;

import java.sql.SQLException;

import com.ssafy.happyhouse.dao.LoginDao;
import com.ssafy.happyhouse.dao.LoginDaoImpl;
import com.ssafy.happyhouse.dto.MemberDto;


public class LoginServiceImpl implements LoginService {
	LoginDao loginDao=new LoginDaoImpl();
	@Override
	public MemberDto login(String userid, String userpwd) {
		MemberDto member=null;
		
		try {
			member=loginDao.login(userid, userpwd);
			if(member==null) {
				throw new Exception("등록되지 않은 아이디이거나, 잘못된 비밀번호입니다.");
			}else {
				return member;
			}
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@Override
	public MemberDto getMember(String username,String userid,String useremail) throws SQLException{
		MemberDto member=null;
		
		try {
			member=loginDao.getMember(username,userid,useremail);
			System.out.println(member);
			if(member==null) {
				throw new Exception("일치하는 회원정보가 없습니다.");
			}else {
				return member;
			}
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
