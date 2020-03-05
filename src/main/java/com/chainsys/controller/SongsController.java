package com.chainsys.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.models.SongList;
import com.chainsys.musicapp.DAO.SearchSongTab2DAO;
import com.chainsys.musicapp.implementation.SearchSongTab2DAOImpl;
import com.chainsys.musicapp.implementation.SongLinkDAOImpl;
import com.chainsys.service.AdminDetailService;
import com.chainsys.service.InsertSongService;
import com.chainsys.service.LoginService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class SongsController {

	@GetMapping("/songlist")
	public List<String> list() throws ClassNotFoundException, SQLException {
		SearchSongTab2DAO s1 = new SearchSongTab2DAOImpl();
		return s1.searchSongName();
		
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
	public boolean adminLogin(@RequestParam("username") String email,
			@RequestParam("pwd") String pass) throws ClassNotFoundException, SQLException {
		return AdminDetailService.adminDetailService(email, pass);
	}
	@PostMapping("/insertSong")
	public boolean insertSong(@RequestParam("sname") String sname,@RequestParam("mdir") String mdir,
			@RequestParam("singer") String singers,@RequestParam("lyricist") String lyricist,
			@RequestParam("mname") String mname,@RequestParam("slink") String slink) throws Exception {
		SongList sl=new SongList();
		sl.setSongName(sname);
		sl.setMusicDirector(mdir);
		sl.setSingers(singers);
		sl.setLyricist(lyricist);
		sl.setMovieName(mname);
		sl.setSongLink(slink);
		return InsertSongService.insertSong(sl);
	}
}