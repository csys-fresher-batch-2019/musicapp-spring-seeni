package com.chainsys.otherclass;

import java.sql.Connection;
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
			String sql = "insert into userlogin(user_id,username,email_id,password,mobile_no) values(uid_seq.nextval,'"
					+ ul.getUserName() + "','" + ul.getEmailId() + "','" + ul.getPassword() + "'," + ul.getMobileNo()
					+ ")";
			boolean sql1 = true;
			if (sql1) {
				Statement st = con.createStatement();
				int row = st.executeUpdate(sql);
				Logger.getInstanceOf().info(row);
				System.out.println("true");
				return true;
			} else {
				System.out.println("false");
				return false;
			}
		} catch (Exception e) {
			Logger.getInstanceOf().info(e.getMessage());
		}
		return false;
	}
}
