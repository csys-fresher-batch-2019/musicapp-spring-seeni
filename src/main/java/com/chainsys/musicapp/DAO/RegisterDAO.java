package com.chainsys.musicapp.DAO;

import java.sql.SQLException;

import com.chainsys.models.Userlogin;

public interface RegisterDAO {
	
	public boolean register(Userlogin ul) throws ClassNotFoundException, SQLException ;

}
