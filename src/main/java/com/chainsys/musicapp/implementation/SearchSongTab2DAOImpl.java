package com.chainsys.musicapp.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.musicapp.DAO.SearchSongTab2DAO;
import com.chainsys.musicapp.util.Connection1;
import com.chainsys.musicapp.util.Logger;

public class SearchSongTab2DAOImpl implements SearchSongTab2DAO {

	/**
	 * Select all the song names from the database
	 */

	public List<String> searchSongName() throws ClassNotFoundException, SQLException {
		List<String> arli = null;
		String sql = "select song_name from song_list";
		try (Connection con = Connection1.connection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			Logger.getInstanceOf().info(sql);
			arli = new ArrayList<String>();
			while (rs.next()) {
				arli.add(rs.getString("song_name"));
			}
			
		} catch (Exception e) {
			// throw new Exception(ErrorConstants.checkInput);
			e.getMessage();
		}
		
		return arli;
	}
}