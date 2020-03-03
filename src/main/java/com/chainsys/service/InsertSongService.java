package com.chainsys.service;

import com.chainsys.models.SongList;
import com.chainsys.musicapp.DAO.InsertTab2DAO;
import com.chainsys.musicapp.implementation.InsertTab2DAOImpl;

public class InsertSongService {

	static InsertTab2DAO in = new InsertTab2DAOImpl();
	
	public static boolean insertSong(SongList songList)  throws Exception{
		
		return in.insertSong(songList);
	}


	
}
