package com.chainsys.musicapp.DAO;

import java.sql.SQLException;

public interface ForgotPasswordTab1DAO {

	public String pwdChange(String emailId)throws SQLException, ClassNotFoundException;
	
	public boolean checkEmail(String mailID) throws SQLException, ClassNotFoundException ;
	
	public boolean newPassUpdate(String newPassword,String email) throws ClassNotFoundException, SQLException ;
	
}
