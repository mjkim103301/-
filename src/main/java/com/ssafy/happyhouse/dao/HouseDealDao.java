package com.ssafy.happyhouse.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.HouseDealDto;
import com.ssafy.model.dto.PageBean;

public interface HouseDealDao {
	public HouseDealDto getHouseDeal(long no) throws SQLException;
	public int totalCount(Connection conn, PageBean bean) throws SQLException;
	public List<HouseDealDto> searchAll(Connection conn, PageBean bean) throws SQLException;
}
