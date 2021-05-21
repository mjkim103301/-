package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HouseDealDao;
import com.ssafy.happyhouse.dto.HouseDealDto;


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
