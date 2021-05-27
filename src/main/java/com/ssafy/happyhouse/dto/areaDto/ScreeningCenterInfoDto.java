package com.ssafy.happyhouse.dto.areaDto;

public class ScreeningCenterInfoDto {
	private int screeningCenterInfoId;
	private String name;
	private String address;
	private String operatingHourWeekday;
	private String operatingHourSaturday;
	private String operatingHourHoliday;
	private String phone;

	public ScreeningCenterInfoDto() {
	}

	public ScreeningCenterInfoDto(int screeningCenterInfoId, String name, String address, String operatingHourWeekday, String operatingHourSaturday, String operatingHourHoliday) {
		this.screeningCenterInfoId = screeningCenterInfoId;
		this.name = name;
		this.address = address;
		this.operatingHourWeekday = operatingHourWeekday;
		this.operatingHourSaturday = operatingHourSaturday;
		this.operatingHourHoliday = operatingHourHoliday;
	}

	public int getScreeningCenterInfoId() {
		return screeningCenterInfoId;
	}

	public void setScreeningCenterInfoId(int screeningCenterInfoId) {
		this.screeningCenterInfoId = screeningCenterInfoId;
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

	public String getOperatingHourWeekday() {
		return operatingHourWeekday;
	}

	public void setOperatingHourWeekday(String operatingHourWeekday) {
		this.operatingHourWeekday = operatingHourWeekday;
	}

	public String getOperatingHourSaturday() {
		return operatingHourSaturday;
	}

	public void setOperatingHourSaturday(String operatingHourSaturday) {
		this.operatingHourSaturday = operatingHourSaturday;
	}

	public String getOperatingHourHoliday() {
		return operatingHourHoliday;
	}

	public void setOperatingHourHoliday(String operatingHourHoliday) {
		this.operatingHourHoliday = operatingHourHoliday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
