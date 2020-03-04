package com.chainsys.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.musicapp.DAO.SearchSongTab2DAO;
import com.chainsys.musicapp.implementation.SearchSongTab2DAOImpl;
public class SearchSongService {
	
	static SearchSongTab2DAO s1 = new SearchSongTab2DAOImpl();
	
	public static List<String> searchSongName()  throws ClassNotFoundException, SQLException{
		
		return s1.searchSongName();
		
	}

}
