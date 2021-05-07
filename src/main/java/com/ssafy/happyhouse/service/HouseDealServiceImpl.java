package com.ssafy.happyhouse.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.HouseDealDao;
import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.util.PageUtility;


@Service
public class HouseDealServiceImpl implements HouseDealService {
	
	@Autowired
	private HouseDealDao dao;


	@Override
	public List<HouseDealDto> houseDealList(List<HouseDealDto> houseDealDto) {
		List<HouseDealDto> list=dao.houseDealList(houseDealDto);
		return list;
	}
}
