package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.areaDto.InterestedAreaDto;

import java.util.List;


public interface InterestedAreaService {
	void addInterestArea(InterestedAreaDto interestedAreaDto);
	List<InterestedAreaDto> getInterestedAreaList(String userId);
}

