package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.model.dto.HouseDealDto;
import com.ssafy.model.dto.PageBean;

public interface HouseDealService {
	public HouseDealDto getHouseDeal(long no);

	public List<HouseDealDto> searchAll(PageBean bean);
}
