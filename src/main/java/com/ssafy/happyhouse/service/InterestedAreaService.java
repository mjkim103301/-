package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.areaDto.CommercialInfoDto;
import com.ssafy.happyhouse.dto.areaDto.EnvironmentInfoDto;
import com.ssafy.happyhouse.dto.areaDto.InterestedAreaDto;
import com.ssafy.happyhouse.dto.areaDto.SafeHospitalInfoDto;

import java.util.List;


public interface InterestedAreaService {
	void addInterestArea(InterestedAreaDto interestedAreaDto);
	List<InterestedAreaDto> getInterestedAreaList(String userId);
	List<CommercialInfoDto> getCommercialInfoList(String dongcode);
	List<EnvironmentInfoDto> getEnvironmentInfoList(String dongcode);
	List<SafeHospitalInfoDto> getSafeHospitalInfoList(String gugun);
}

