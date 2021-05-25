package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dao.InterestAreaDao;
import com.ssafy.happyhouse.dto.areaDto.InterestAreaDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class InterestAreaServiceImpl implements InterestAreaService{
	@Autowired
	InterestAreaDao interestAreaDao;

	@Override
	public void addInterestArea(InterestAreaDto interestAreaDto) {
		interestAreaDao.addInterestArea(interestAreaDto);
	}
}
