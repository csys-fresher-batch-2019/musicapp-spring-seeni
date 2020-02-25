package com.chainsys.UserLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.otherclass.Connection1;

public class LoginDAOImpl implements LoginDAO {

	/**
	 * To check the user login is correct or not
	 */

	public boolean login(String email, String pass) throws ClassNotFoundException, SQLException {
		System.out.println(email);
		System.out.println(pass);
		String sql = "select email_id,password from userlogin where email_id=? and password=?";
		try (Connection con = Connection1.connection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, email);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			} 
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
}
