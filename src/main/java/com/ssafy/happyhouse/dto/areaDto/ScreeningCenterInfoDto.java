package com.ssafy.happyhouse.dto.areaDto;

public class ScreeningCenterInfoDto {
	private int screeningCenterInfoId;
	private String name;
	private String address;
	private String opertingHourWeekday;
	private String opertingHourSaturday;
	private String opertingHourHoliday;

	public ScreeningCenterInfoDto() {
	}

	public ScreeningCenterInfoDto(int screeningCenterInfoId, String name, String address, String opertingHourWeekday, String opertingHourSaturday, String opertingHourHoliday) {
		this.screeningCenterInfoId = screeningCenterInfoId;
		this.name = name;
		this.address = address;
		this.opertingHourWeekday = opertingHourWeekday;
		this.opertingHourSaturday = opertingHourSaturday;
		this.opertingHourHoliday = opertingHourHoliday;
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

	public String getOpertingHourWeekday() {
		return opertingHourWeekday;
	}

	public void setOpertingHourWeekday(String opertingHourWeekday) {
		this.opertingHourWeekday = opertingHourWeekday;
	}

	public String getOpertingHourSaturday() {
		return opertingHourSaturday;
	}

	public void setOpertingHourSaturday(String opertingHourSaturday) {
		this.opertingHourSaturday = opertingHourSaturday;
	}

	public String getOpertingHourHoliday() {
		return opertingHourHoliday;
	}

	public void setOpertingHourHoliday(String opertingHourHoliday) {
		this.opertingHourHoliday = opertingHourHoliday;
	}
}
