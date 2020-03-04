package com.chainsys.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;
import com.chainsys.musicapp.DAO.ForgotPasswordTab1DAO;
public class ForgotPasswordService {
	
	static ForgotPasswordTab1DAO f;
	
	public static String pwdChange(String email) throws ClassNotFoundException, SQLException {
		
		return f.pwdChange(email);

	}
	
	public static boolean checkEmail(String mailID) throws ClassNotFoundException, SQLException {
		
		return f.checkEmail(mailID);
		 
		
	}
	public static boolean newPassUpdate(String newPassword,String email) throws ClassNotFoundException, SQLException {
		
		return f.newPassUpdate(newPassword, email);
		
	}

}
