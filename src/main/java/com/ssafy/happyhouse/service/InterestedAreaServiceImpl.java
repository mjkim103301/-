package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dao.InterestedAreaDao;
import com.ssafy.happyhouse.dto.areaDto.InterestedAreaDto;
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
}
