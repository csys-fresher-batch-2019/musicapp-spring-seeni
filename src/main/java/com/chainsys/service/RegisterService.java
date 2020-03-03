package com.chainsys.service;

import java.sql.SQLException;

import com.chainsys.models.Userlogin;
import com.chainsys.musicapp.DAO.RegisterDAO;
import com.chainsys.musicapp.implementation.RegisterDAOImpl;

public class RegisterService {

	static RegisterDAO reg = new RegisterDAOImpl();
	
	public static boolean register(Userlogin ul) throws ClassNotFoundException, SQLException{
		
		return reg.register(ul);
	
	}
	
}
