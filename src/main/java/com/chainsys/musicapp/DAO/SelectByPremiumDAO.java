package com.chainsys.musicapp.DAO;

import java.sql.SQLException;
import java.util.List;

public interface SelectByPremiumDAO {

	public List<String> premiumMembers(String str) throws SQLException, ClassNotFoundException;
	
}
