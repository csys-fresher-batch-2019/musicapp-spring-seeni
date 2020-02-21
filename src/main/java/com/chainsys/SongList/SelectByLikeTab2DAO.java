package com.chainsys.SongList;

import java.sql.SQLException;

import java.util.List;

import com.chainsys.otherclass.SongList;

public interface SelectByLikeTab2DAO {
	
	public List<SongList> selectByLikeKey(String str)  throws ClassNotFoundException, SQLException;

}
