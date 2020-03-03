package com.chainsys.musicapp.DAO;

import java.sql.SQLException;

public interface UpdateTab1DAO {
	
	public boolean updatePhoneNo(long phNo,String email) throws ClassNotFoundException, SQLException; 
	
}
