package com.chainsys.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.models.SongList;
import com.chainsys.musicapp.DAO.SelectByLikeTab2DAO;
import com.chainsys.musicapp.implementation.SelectByLikeTab2DAOImpl;
@Service
public class SelectByLikeService {
	
	static SelectByLikeTab2DAO s = new SelectByLikeTab2DAOImpl();
	
	public static List<SongList> selectByLikeKey(String str)  throws ClassNotFoundException, SQLException{
		
		return s.selectByLikeKey(str);
	
	}

}
