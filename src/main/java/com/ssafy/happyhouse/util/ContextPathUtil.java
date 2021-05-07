package com.ssafy.happyhouse.util;

/**
 * Java파일에서 WebContent 경로 구하기 위한 클래스
 * @author user
 *
 */
public class ContextPathUtil {
	private static ContextPathUtil instance;
	private final String path;

	public static void createInstance(String path) {
		instance = new ContextPathUtil(path);
	}

	private ContextPathUtil(String path) {
		this.path = path;
	}

	public static ContextPathUtil getInstance() {
		if (instance == null) {
			throw new NullPointerException();
		} else {
			return instance;
		}
	}

	public String getContextPath() {
		return path;
	}
}
