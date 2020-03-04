package com.chainsys.musicapp.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.chainsys.musicapp.DAO.ForgotPasswordTab1DAO;
import com.chainsys.musicapp.util.Connection1;
import com.chainsys.musicapp.util.Logger;
@Repository
public class ForgotPasswordDAOImpl implements ForgotPasswordTab1DAO {

	/**
	 * Auto generated new password
	 * 
	 */

	public String pwdChange(String emailId) throws SQLException, ClassNotFoundException {
		String u = "pass1234";
		String sql = "update userlogin set password=? where email_id=?";
		//String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		try (Connection con = Connection1.connection(); PreparedStatement pst = con.prepareStatement(sql);) {
			/*String[] ch = characters.split("");
			Random rand = new Random();

			for (int i = 0; i < 7; i++) {
				int p = rand.nextInt(14);
				int k = i * p;
				if (k <= characters.length()) {
					u += ch[k];
				}
			
			
			
			Logger.getInstanceOf().info(u);

			pst.setString(1, u);
			pst.setString(2, emailId);
			boolean b=SendMailSSL.send("cninasav@gmail.com", "seeninasav",emailId, "Password", " Your auto-generated password is "+u);*/
			
			int rows = pst.executeUpdate();
			Logger.getInstanceOf().info("No. of rows updated :" + rows);

		} catch (Exception e) {
			e.getMessage();
		}
		return u;
	}

	/**
	 * To check the EmailId is valid or not
	 * 
	 * @param mailID
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean checkEmail(String mailID) throws SQLException, ClassNotFoundException {
		String sql = "select * from userlogin where email_id=?";
		try (Connection con = Connection1.connection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, mailID);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Update New password for the respective emailID
	 */

	public boolean newPassUpdate(String newPassword, String email) throws ClassNotFoundException, SQLException {

		String sql = "update userlogin set password=? where email_id=?";
		try (Connection con = Connection1.connection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, newPassword);
			pst.setString(2, email);
			int rows = pst.executeUpdate();
			System.out.println("No. of rows updated " + rows);

		} catch (Exception e) {
			e.getMessage();
		}
		return true;
	}
}
