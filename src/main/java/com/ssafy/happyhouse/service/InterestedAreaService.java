package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.areaDto.*;

import java.util.List;


public interface InterestedAreaService {
	void addInterestArea(InterestedAreaDto interestedAreaDto);
	List<InterestedAreaDto> getInterestedAreaList(String userId);
	List<CommercialInfoDto> getCommercialInfoList(String dongcode);
	List<EnvironmentInfoDto> getEnvironmentInfoList(String dongcode);
	List<SafeHospitalInfoDto> getSafeHospitalInfoList(String gugun);
	List<ScreeningCenterInfoDto> getScreeningCenterInfoList(String gugun);
}

