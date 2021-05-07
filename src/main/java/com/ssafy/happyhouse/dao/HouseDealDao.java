package com.ssafy.happyhouse.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.PageBean;

@Mapper
public interface HouseDealDao {
	public List<HouseDealDto> houseDealList(List<HouseDealDto> houseDealDto);
}
