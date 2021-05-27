package com.ssafy.happyhouse.dto.areaDto;

public class InterestedAreaDto {
	private int interestAreaId;
	private String userId;
	private String dongcode;
	private String gugun;
	private String city;
	private String dong;

	public InterestedAreaDto() {
	}

	public InterestedAreaDto(int interestAreaId, String userId, String dongcode, String dong) {
		this.interestAreaId = interestAreaId;
		this.userId = userId;
		this.dongcode = dongcode;
		this.dong = dong;
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

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("InterestedAreaDto{");
		sb.append("interestAreaId=").append(interestAreaId);
		sb.append(", userId='").append(userId).append('\'');
		sb.append(", dongcode='").append(dongcode).append('\'');
		sb.append(", dong='").append(dong).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
