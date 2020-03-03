package com.chainsys.musicapp.DAO;

import java.sql.SQLException;

public interface LoginDAO {
	public boolean login(String email,String pass)  throws ClassNotFoundException, SQLException;
}
