package com.ssafy.happyhouse.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/happyhouse?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String ID = "ssafy";
	private static final String PASSWORD = "ssafy";

	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}

	public static void close(AutoCloseable... c) {
		for(AutoCloseable target:c) {
			if(target!=null) {
				try {
					target.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}

	public static void rollback(Connection con ) {
		try {
			con.rollback();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
