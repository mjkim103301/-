package com.ssafy.happyhouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HouseDealDao;
import com.ssafy.happyhouse.dto.HouseDealDto;

@Service
public class HouseDealServiceImpl implements HouseDealService {

	@Autowired
	private HouseDealDao dao;

	private List<HouseDealDto> list;

	@Override
	public List<HouseDealDto> houseDealList(List<HouseDealDto> houseDealDto) {
		list = new ArrayList<>();
		for (HouseDealDto item : houseDealDto) {
			List<HouseDealDto> result = dao.houseDealList(item);
			list.addAll(result);
		}
		return list;
	}

	@Override
	public List<HouseDealDto> allHouseDealList() {
		list = new ArrayList<>();

		list.addAll(dao.allHouseDealList());

		return list;
	}

	@Override
	public List<HouseDealDto> houseDealList(String keyword) {
		System.out.println("houseDealAptList keyword "+keyword);
		list = new ArrayList<>();
		list.addAll(dao.houseDealAptList(keyword));

		return list;
	}
}
