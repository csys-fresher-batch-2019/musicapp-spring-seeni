package com.chainsys.musicapp.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.musicapp.DAO.UpdateTab1DAO;
import com.chainsys.musicapp.util.Connection1;

public class UpdateTab1DAOImpl implements UpdateTab1DAO {

	/**
	 * To update the user mobile number
	 */

	public boolean updatePhoneNo(long phNo, String email) throws ClassNotFoundException, SQLException {
		String sql = "update userlogin set mobile_no=? where email_id=?";
		try (Connection con = Connection1.connection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setLong(1, phNo);
			pst.setString(2, email);
			int rows = pst.executeUpdate();
			System.out.println("No. of rows updated " + rows);
			pst.close();
			con.close();

		} catch (Exception e) {
			e.getMessage();
		}
		return true;
	}
}