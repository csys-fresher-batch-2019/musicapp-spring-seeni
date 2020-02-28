package com.chainsys.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.SongList.SearchSongTab2DAO;
import com.chainsys.SongList.SearchSongTab2DAOImpl;

@RestController
@RequestMapping("api")
public class SongsController {

	@GetMapping("/songlist")
	public List<String> list() {
		SearchSongTab2DAO s1 = new SearchSongTab2DAOImpl();
		List<String> song = new ArrayList<>();
		try {
			song = s1.searchSongName();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return song;
	}
	
	
}