package com.ssafy.happyhouse.dto;

public class HouseDealDto {
	private long no;
	private String dong;
	private String AptName;
	private int guguncode;
	private long dealAmount;
	private int buildYear;
	private int dealYear;
	private int dealMonth;
	private int dealDay;
	private double area;
	private double floor;
	private String jibun;
	private int type;
	private long rentMoney;
    
	public HouseDealDto() {

	}

	public HouseDealDto(long no, String aptName, long dealAmount, int dealYear, int dealMonth, int dealDay,
			double area) {
		super();
		this.no = no;
		this.AptName = aptName;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
	}

	public HouseDealDto(long no, String dong, String aptName, int code, long dealAmount, int buildYear, int dealYear,
			int dealMonth, int dealDay, double area, double floor, String jibun, int type, long rentMoney) {
		super();
		this.no = no;
		this.dong = dong;
		this.AptName = aptName;
		this.guguncode = code;
		this.dealAmount = dealAmount;
		this.buildYear = buildYear;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.jibun = jibun;
		this.type = type;
		this.rentMoney = rentMoney;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getAptName() {
		return AptName;
	}

	public void setAptName(String aptName) {
		AptName = aptName;
	}

	public int getGugunCode() {
		return guguncode;
	}

	public void setGugunCode(int code) {
		this.guguncode = code;
	}

	public long getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(long dealAmount) {
		this.dealAmount = dealAmount;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public int getDealYear() {
		return dealYear;
	}

	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}

	public int getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}

	public int getDealDay() {
		return dealDay;
	}

	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getFloor() {
		return floor;
	}

	public void setFloor(double floor) {
		this.floor = floor;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getRentMoney() {
		return rentMoney;
	}

	public void setRentMoney(long rentMoney) {
		this.rentMoney = rentMoney;
	}

}
