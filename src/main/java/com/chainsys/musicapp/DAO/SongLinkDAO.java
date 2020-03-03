package com.chainsys.musicapp.DAO;

import java.sql.SQLException;
import java.util.List;

public interface SongLinkDAO {
	
	public List<String> songLink() throws SQLException, ClassNotFoundException;

}
