package com.ssafy.happyhouse.dto.areaDto;

public class EnvironmentInfoDto {
	private int EnvironmentInfoId;
	private String name;
	private String codeName;
	private String address;

	public EnvironmentInfoDto(int environmentInfoId) {
		EnvironmentInfoId = environmentInfoId;
	}

	public EnvironmentInfoDto(int environmentInfoId, String name, String codeName, String address) {
		EnvironmentInfoId = environmentInfoId;
		this.name = name;
		this.codeName = codeName;
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

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
