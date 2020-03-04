package com.chainsys.musicapp.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.musicapp.DAO.SongLinkDAO;
import com.chainsys.musicapp.util.Connection1;

/**
 * Select all the songlink from the database
 * 
 * @author seen2380
 *
 */
public class SongLinkDAOImpl implements SongLinkDAO {
	public List<String> songLink() throws SQLException, ClassNotFoundException {
		String sql = "select song_link from song_list";
		try (Connection con = Connection1.connection(); PreparedStatement pst = con.prepareStatement(sql);) {
			ResultSet rs = pst.executeQuery();
			List<String> li = new ArrayList<>();
			while (rs.next()) {
				li.add(rs.getString("song_link"));
			}
			System.out.println(li);
			return li;
		}
	}
}
