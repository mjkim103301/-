package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.areaDto.InterestAreaDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InterestAreaDao {
	void addInterestArea(InterestAreaDto interestAreaDto);
}
