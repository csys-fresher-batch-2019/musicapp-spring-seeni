package com.chainsys.musicapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import org.springframework.stereotype.Component;
public class Connection1 {

	/**
	 * To connect with the database
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public static Connection connection() throws SQLException, ClassNotFoundException {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		return DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "seeni", "seeni");

	}
}
