package com.ssafy.happyhouse.dto;

public class HouseException extends RuntimeException{
	public HouseException() {}
	public HouseException(String msg) {
		super(msg);
	}
}
