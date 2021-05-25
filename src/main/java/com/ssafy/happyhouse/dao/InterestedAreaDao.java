package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.areaDto.InterestedAreaDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterestedAreaDao {
	void addInterestedArea(InterestedAreaDto interestedAreaDto);
	List<InterestedAreaDto>	getInterestedAreaList(String userId);
}
