package com.ssafy.happyhouse.dto.areaDto;

public class CommercialInfo {
	private int commercialInfoId;
	private String shopName;
	private String localName;
	private String address;
	private String lng;
	private String lat;

	public CommercialInfo() {
	}

	public CommercialInfo(int commercialInfoId, String shopName, String localName, String address, String lng, String lat) {
		this.commercialInfoId = commercialInfoId;
		this.shopName = shopName;
		this.localName = localName;
		this.address = address;
		this.lng = lng;
		this.lat = lat;
	}

	public int getCommercialInfoId() {
		return commercialInfoId;
	}

	public void setCommercialInfoId(int commercialInfoId) {
		this.commercialInfoId = commercialInfoId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}
}
