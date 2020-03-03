package com.chainsys.service;

import java.sql.SQLException;

import com.chainsys.musicapp.DAO.AdminLoginDAO;
import com.chainsys.musicapp.implementation.AdminLoginDAOImpl;

public class AdminDetailService {

	public static boolean adminDetailService(String email, String pwd) throws ClassNotFoundException, SQLException {
		AdminLoginDAO al=new AdminLoginDAOImpl();
		return al.adminDetails(email, pwd);
		 
	}

}
