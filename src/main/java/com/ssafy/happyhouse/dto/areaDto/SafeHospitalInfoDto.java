package com.ssafy.happyhouse.dto.areaDto;

public class SafeHospitalInfoDto {
	private int safeHospitalInfoId;
	private String name;
	private String address;
	private String phone;

	public SafeHospitalInfoDto() {
	}

	public SafeHospitalInfoDto(int safeHospitalInfoId, String name, String address, String phone) {
		this.safeHospitalInfoId = safeHospitalInfoId;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public int getSafeHospitalInfoId() {
		return safeHospitalInfoId;
	}

	public void setSafeHospitalInfoId(int safeHospitalInfoId) {
		this.safeHospitalInfoId = safeHospitalInfoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
