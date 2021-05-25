package com.ssafy.happyhouse.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.HouseDealDto;

@Mapper
public interface HouseDealDao {
	public List<HouseDealDto> houseDealList(HouseDealDto houseDealDto);

	public List<HouseDealDto> allHouseDealList();

	public List<HouseDealDto> houseDealAptList(String keyword);
}
