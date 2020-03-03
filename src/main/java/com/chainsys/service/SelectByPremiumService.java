package com.chainsys.service;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.musicapp.DAO.SelectByPremiumDAO;
import com.chainsys.musicapp.implementation.SelectByPremiumDAOImpl;

public class SelectByPremiumService {

	static SelectByPremiumDAO s=new SelectByPremiumDAOImpl();
	public static List<String> premiumMembers(String str) throws SQLException, ClassNotFoundException {
		
		return s.premiumMembers(str);
	
	}

}
