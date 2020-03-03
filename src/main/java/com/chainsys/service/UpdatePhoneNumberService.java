package com.chainsys.service;

import java.sql.SQLException;

import com.chainsys.musicapp.DAO.UpdateTab1DAO;
import com.chainsys.musicapp.implementation.UpdateTab1DAOImpl;

public class UpdatePhoneNumberService {

	static UpdateTab1DAO u = new UpdateTab1DAOImpl();
	
	public static boolean updatePhoneNo(long phNo,String email) throws ClassNotFoundException, SQLException{
		
		return u.updatePhoneNo(phNo, email);
	
	}
	
}
