package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dao.InterestedAreaDao;
import com.ssafy.happyhouse.dto.areaDto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestedAreaServiceImpl implements InterestedAreaService {
	@Autowired
	InterestedAreaDao interestedAreaDao;

	@Override
	public void addInterestArea(InterestedAreaDto interestedAreaDto) {
		interestedAreaDao.addInterestedArea(interestedAreaDto);
	}

	@Override
	public List<InterestedAreaDto> getInterestedAreaList(String userId) {
		return interestedAreaDao.getInterestedAreaList(userId);
	}

	@Override
	public List<CommercialInfoDto> getCommercialInfoList(String dongcode) {
		return interestedAreaDao.getCommercialInfoList(dongcode);
	}

	@Override
	public List<EnvironmentInfoDto> getEnvironmentInfoList(String dongcode) {
		return interestedAreaDao.getEnvironmentInfoList(dongcode);
	}

	@Override
	public List<SafeHospitalInfoDto> getSafeHospitalInfoList(String gugun) {
		return interestedAreaDao.getSafeHospitalInfoList(gugun);
	}

	@Override
	public List<ScreeningCenterInfoDto> getScreeningCenterInfoList(String gugun) {
		return interestedAreaDao.getScreeningCenterInfoList(gugun);
	}
}
