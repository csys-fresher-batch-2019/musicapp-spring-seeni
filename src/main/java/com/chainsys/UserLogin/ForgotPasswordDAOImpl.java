package com.chainsys.UserLogin;

import java.sql.Connection;
import com.chainsys.otherclass.Connection1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


public class ForgotPasswordDAOImpl implements ForgotPasswordTab1DAO {
	public String pwdChange(String emailId) throws SQLException, ClassNotFoundException {
		String u="";
		String sql="update userlogin set password=? where email_id=?";
		String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		try(Connection con=Connection1.connection();
				PreparedStatement pst=con.prepareStatement(sql);){
		String[] ch=characters.split("");
		Random rand=new Random();
		
		for(int i=0;i<7;i++) {
			int p=rand.nextInt(14);
			int k=i*p;
			if(k<=characters.length()) {
				u+=ch[k];
			}
		}System.out.println(u);
		
		
		pst.setString(1, u);
		pst.setString(2, emailId);
		int rows=pst.executeUpdate();
		System.out.println("No. of rows updated :"+rows);
		
		}catch(Exception e) {
			e.getMessage();
		}return u;
	}public boolean checkEmail(String mailID) throws SQLException, ClassNotFoundException {
		String sql="select * from userlogin where email_id=?";
		try(Connection con=Connection1.connection();
				PreparedStatement pst=con.prepareStatement(sql);){
			pst.setString(1, mailID);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				return true;
			}
		}return false;
	}
	public boolean newPassUpdate(String newPassword,String email) throws ClassNotFoundException, SQLException {
		
		String sql="update userlogin set password=? where email_id=?";
		try(Connection con=Connection1.connection();
				PreparedStatement pst=con.prepareStatement(sql);){
		pst.setString(1, newPassword);
		pst.setString(2, email);
		int rows=pst.executeUpdate();
		System.out.println("No. of rows updated "+rows);
		
		}catch(Exception e) {
			e.getMessage();
		}return true;
	}
}
