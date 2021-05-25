package com.ssafy.happyhouse.dto.areaDto;

public class InterestArea {
	private int interestAreaId;
	private String userId;
	private String dongcode;

	public InterestArea() {
	}

	public InterestArea(int interestAreaId, String userId, String dongcode) {
		this.interestAreaId = interestAreaId;
		this.userId = userId;
		this.dongcode = dongcode;
	}

	public int getInterestAreaId() {
		return interestAreaId;
	}

	public void setInterestAreaId(int interestAreaId) {
		this.interestAreaId = interestAreaId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDongcode() {
		return dongcode;
	}

	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
}
