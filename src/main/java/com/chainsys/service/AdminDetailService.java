package com.chainsys.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.chainsys.musicapp.DAO.AdminLoginDAO;
import com.chainsys.musicapp.implementation.AdminLoginDAOImpl;
@Service
public class AdminDetailService {

	public static boolean adminDetailService(String email, String pwd) throws ClassNotFoundException, SQLException {
		AdminLoginDAO al=new AdminLoginDAOImpl();
		return al.adminDetails(email, pwd);
		 
	}

}
