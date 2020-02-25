package com.chainsys.otherclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Insert the new user account into the database
 * 
 * @author seen2380
 *
 */

public class Register {
	public boolean register(Userlogin ul) throws ClassNotFoundException, SQLException {
		try (Connection con = Connection1.connection();) {
			String sql = "insert into userlogin(user_id,username,email_id,password,mobile_no) values(?,?,?,?,?)";

			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setInt(1, ul.getUserId());
				pst.setString(2, ul.getUserName());
				pst.setString(3, ul.getEmailId());
				pst.setString(4, ul.getPassword());
				pst.setLong(5, ul.getMobileNo());
				int row = pst.executeUpdate(sql);
				Logger.getInstanceOf().info(row);

			}
			return true;
		}
	}
}
