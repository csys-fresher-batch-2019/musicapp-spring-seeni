package com.chainsys.musicapp.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.musicapp.DAO.SearchSongTab2DAO;
import com.chainsys.musicapp.util.Connection1;
import com.chainsys.musicapp.util.Logger;
public class SearchSongTab2DAOImpl implements SearchSongTab2DAO {

	/**
	 * Select all the song names from the database
	 */

	public List<String> searchSongName() throws ClassNotFoundException, SQLException {
		
		String sql = "select song_number,song_name from song_list";
		try (Connection con = Connection1.connection();
				Statement pst = con.createStatement();
				ResultSet rs = pst.executeQuery(sql);) {
			Logger.getInstanceOf().info(sql);
			List<String> arli = new ArrayList<String>();
			while (rs.next()) {
				arli.add(rs.getString("song_name"));
				
			}System.out.println(arli);
			return arli;
		} catch (Exception e) {
			// throw new Exception(ErrorConstants.checkInput);
			e.getMessage();
		}
		return null;
	}public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SearchSongTab2DAOImpl s=new SearchSongTab2DAOImpl();
		s.searchSongName();
	}
}