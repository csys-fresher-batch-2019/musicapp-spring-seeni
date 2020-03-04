package com.chainsys.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.musicapp.DAO.SearchSongTab2DAO;
import com.chainsys.musicapp.implementation.SearchSongTab2DAOImpl;
import com.chainsys.musicapp.implementation.SongLinkDAOImpl;
import com.chainsys.service.AdminDetailService;
import com.chainsys.service.LoginService;

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
	
	@GetMapping("/songpath")
	public List<String> songPath() throws ClassNotFoundException, SQLException{
		SongLinkDAOImpl sl = new SongLinkDAOImpl();
		return sl.songLink();
	}
	
	@GetMapping("/login")
	public boolean login(@RequestParam("username") String username,
			@RequestParam("pwd") String pwd) throws ClassNotFoundException, SQLException {
		return LoginService.login(username, pwd);
	}
	
	@GetMapping("/adminlogin")
	public boolean adminLogin(@RequestParam("email") String email,
			@RequestParam("pwd") String pass) throws ClassNotFoundException, SQLException {
		return AdminDetailService.adminDetailService(email, pass);
		
	}
}