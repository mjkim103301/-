package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.areaDto.InterestAreaDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface InterestAreaService {
	void addInterestArea(InterestAreaDto interestAreaDto);
}

