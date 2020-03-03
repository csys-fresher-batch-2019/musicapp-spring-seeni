package com.chainsys.musicapp.DAO;

import java.sql.SQLException;

public interface AdminLoginDAO {
	
	public boolean adminDetails(String mail, String pwd) throws SQLException, ClassNotFoundException ;

}
