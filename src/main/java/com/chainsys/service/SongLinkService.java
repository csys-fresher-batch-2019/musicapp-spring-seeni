package com.chainsys.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.musicapp.DAO.SongLinkDAO;
import com.chainsys.musicapp.implementation.SongLinkDAOImpl;
@Service
public class SongLinkService {
	
	static SongLinkDAO sl = new SongLinkDAOImpl();
	
	public static List<String> songLink() throws SQLException, ClassNotFoundException{
		
		return sl.songLink();
		
	}
	

}
