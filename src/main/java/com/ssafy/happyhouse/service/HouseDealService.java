package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDealDto;


public interface HouseDealService {
	public List<HouseDealDto> houseDealList(List<HouseDealDto> houseDealDto);
	public List<HouseDealDto> houseDealList(String keyword);
	public List<HouseDealDto> allHouseDealList();
}
