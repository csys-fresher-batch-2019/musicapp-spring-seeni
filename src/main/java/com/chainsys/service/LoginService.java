package com.chainsys.service;

import java.sql.SQLException;

import com.chainsys.musicapp.DAO.LoginDAO;
import com.chainsys.musicapp.implementation.LoginDAOImpl;

public class LoginService {

	public static boolean login(String email,String pass)  throws ClassNotFoundException, SQLException{
		LoginDAO l=new LoginDAOImpl();
		return l.login(email, pass);
	}
	
}
