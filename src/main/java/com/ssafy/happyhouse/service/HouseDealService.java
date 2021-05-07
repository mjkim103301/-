package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.PageBean;


public interface HouseDealService {
	public List<HouseDealDto> houseDealList(List<HouseDealDto> houseDealDto);
}
