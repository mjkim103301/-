package com.ssafy.happyhouse.dto.areaDto;

public class EnvironmentInfoDto {
	private int EnvironmentInfoId;
	private String name;
	private String category;
	private String address;

	public EnvironmentInfoDto(int environmentInfoId) {
		EnvironmentInfoId = environmentInfoId;
	}

	public EnvironmentInfoDto(int environmentInfoId, String name, String category, String address) {
		EnvironmentInfoId = environmentInfoId;
		this.name = name;
		this.category = category;
		this.address = address;
	}

	public int getEnvironmentInfoId() {
		return EnvironmentInfoId;
	}

	public void setEnvironmentInfoId(int environmentInfoId) {
		EnvironmentInfoId = environmentInfoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
