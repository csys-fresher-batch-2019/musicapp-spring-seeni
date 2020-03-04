package com.chainsys.musicapp.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.chainsys.musicapp.DAO.LoginDAO;
import com.chainsys.musicapp.util.Connection1;
@Repository
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
