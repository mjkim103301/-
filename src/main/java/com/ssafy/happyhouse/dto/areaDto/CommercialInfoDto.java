package com.ssafy.happyhouse.dto.areaDto;

public class CommercialInfoDto {
	private int commercialInfoId;
	private String shopName;
	private String localName;
	private String address;
	private String lng;
	private String lat;
	private String largeCategory;
	private String smallCategory;

	public CommercialInfoDto() {
	}

	public CommercialInfoDto(int commercialInfoId, String shopName, String localName, String address, String lng, String lat, String largeCategory, String smallCategory) {
		this.commercialInfoId = commercialInfoId;
		this.shopName = shopName;
		this.localName = localName;
		this.address = address;
		this.lng = lng;
		this.lat = lat;
		this.largeCategory = largeCategory;
		this.smallCategory = smallCategory;
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

	public String getLargeCategory() {
		return largeCategory;
	}

	public void setLargeCategory(String largeCategory) {
		this.largeCategory = largeCategory;
	}

	public String getSmallCategory() {
		return smallCategory;
	}

	public void setSmallCategory(String smallCategory) {
		this.smallCategory = smallCategory;
	}
}
