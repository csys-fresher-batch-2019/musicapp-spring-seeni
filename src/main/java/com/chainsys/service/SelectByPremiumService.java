package com.chainsys.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.musicapp.DAO.SelectByPremiumDAO;
import com.chainsys.musicapp.implementation.SelectByPremiumDAOImpl;
@Service
public class SelectByPremiumService {

	static SelectByPremiumDAO s=new SelectByPremiumDAOImpl();
	public static List<String> premiumMembers(String str) throws SQLException, ClassNotFoundException {
		
		return s.premiumMembers(str);
	
	}

}
