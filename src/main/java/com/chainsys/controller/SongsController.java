package com.chainsys.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.SongList.SearchSongTab2DAO;
import com.chainsys.SongList.SearchSongTab2DAOImpl;
import com.chainsys.UserLogin.LoginDAO;
import com.chainsys.UserLogin.LoginDAOImpl;
import com.chainsys.otherclass.SongLink;

@CrossOrigin(origins = "*")
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
	
	@PostMapping("/login")
	public boolean login(@RequestParam("email") String email,@RequestParam("pass") String pass) throws ClassNotFoundException, SQLException{
		LoginDAO l = new LoginDAOImpl();
		return l.login(email, pass);
	}
	@GetMapping("/songpath")
	public List<String> songPath() throws ClassNotFoundException, SQLException{
		SongLink sl = new SongLink();
		return sl.songLink();
	}
}