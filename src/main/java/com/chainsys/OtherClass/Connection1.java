package com.chainsys.otherclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

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
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");

	}
}
