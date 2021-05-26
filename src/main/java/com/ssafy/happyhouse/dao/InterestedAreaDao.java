package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.areaDto.CommercialInfoDto;
import com.ssafy.happyhouse.dto.areaDto.EnvironmentInfoDto;
import com.ssafy.happyhouse.dto.areaDto.InterestedAreaDto;
import com.ssafy.happyhouse.dto.areaDto.SafeHospitalInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterestedAreaDao {
	void addInterestedArea(InterestedAreaDto interestedAreaDto);
	List<InterestedAreaDto>	getInterestedAreaList(String userId);
	List<CommercialInfoDto> getCommercialInfoList(String dongcode);
	List<EnvironmentInfoDto> getEnvironmentInfoList(String dongcode);
	List<SafeHospitalInfoDto> getSafeHospitalInfoList(String gugun);
}
