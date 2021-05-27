package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.areaDto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterestedAreaDao {
	void addInterestedArea(InterestedAreaDto interestedAreaDto);
	List<InterestedAreaDto>	getInterestedAreaList(String userId);
	List<CommercialInfoDto> getCommercialInfoList(String dongcode);
	List<EnvironmentInfoDto> getEnvironmentInfoList(String dongcode);
	List<SafeHospitalInfoDto> getSafeHospitalInfoList(String gugun);
	List<ScreeningCenterInfoDto> getScreeningCenterInfoList(String gugun);
	InterestedAreaDto getInterestedArea(InterestedAreaDto interestedAreaDto);
}
