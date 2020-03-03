package com.chainsys.musicapp.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.musicapp.DAO.SongBetweenDatesTab2DAO;
import com.chainsys.musicapp.util.Connection1;
import com.chainsys.musicapp.util.Logger;

public class SongBetweenDatesTab2DAOImpl implements SongBetweenDatesTab2DAO {

	/**
	 * Search songs by released year
	 */

	public List<String> selectSongs(int releaseYearLd, int upto) throws ClassNotFoundException, SQLException {
		ArrayList<String> li = null;
		String sql = "select song_name from song_list where song_number in (select song_number from year where release_year between ? and ?)";
		try (Connection con = Connection1.connection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			Logger.getInstanceOf().info(sql);

			pst.setInt(1, releaseYearLd);
			pst.setInt(2, upto);

			li = new ArrayList<String>();
			while (rs.next()) {
				li.add(rs.getString("song_name"));
			}
			for (String string : li) {
				Logger.getInstanceOf().info(string);
			}
			if (releaseYearLd > upto) {
				Logger.getInstanceOf().info("Invalid year");
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return li;
	}

}
