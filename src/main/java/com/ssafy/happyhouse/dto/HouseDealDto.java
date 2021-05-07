package com.ssafy.happyhouse.dto;

public class HouseDealDto {
	private long no;
	private String dong;
	private String aptName;
	private long dongcode;
	private long guguncode;
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
	private String img;
	private String lat;
	private String lng;
    
	public HouseDealDto() {

	}
	
	

	public HouseDealDto(long no, String dong, String aptName, long dongcode, long guguncode, long dealAmount,
			int buildYear, int dealYear, int dealMonth, int dealDay, double area, double floor, String jibun, int type,
			long rentMoney, String img, String lat, String lng) {
		super();
		this.no = no;
		this.dong = dong;
		this.aptName = aptName;
		this.dongcode = dongcode;
		this.guguncode = guguncode;
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
		this.img = img;
		this.lat = lat;
		this.lng = lng;
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
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public long getDongcode() {
		return dongcode;
	}

	public void setDongcode(long dongcode) {
		this.dongcode = dongcode;
	}

	public long getGuguncode() {
		return guguncode;
	}

	public void setGuguncode(long guguncode) {
		this.guguncode = guguncode;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}



	

}
