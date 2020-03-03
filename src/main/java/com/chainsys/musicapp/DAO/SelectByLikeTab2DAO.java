package com.chainsys.musicapp.DAO;

import java.sql.SQLException;

import java.util.List;

import com.chainsys.models.SongList;

public interface SelectByLikeTab2DAO {
	
	public List<SongList> selectByLikeKey(String str)  throws ClassNotFoundException, SQLException;

}
