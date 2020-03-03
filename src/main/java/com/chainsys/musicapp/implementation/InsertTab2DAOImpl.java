package com.chainsys.musicapp.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.models.SongList;
import com.chainsys.musicapp.DAO.InsertTab2DAO;
import com.chainsys.musicapp.util.Connection1;
import com.chainsys.musicapp.util.ErrorConstants;
import com.chainsys.musicapp.util.Logger;

public class InsertTab2DAOImpl implements InsertTab2DAO {

	/**
	 * For insert a new song
	 */

	public boolean insertSong(SongList sl) throws Exception {

		String sql = "insert into song_list(song_number,song_name,music_director,lyricist,singers,movie_name,song_link) "
				+ "values(song_seq.nextval,?,?,?,?,?,?)";

		try (Connection con = Connection1.connection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, sl.getSongName());
			pst.setString(2, sl.getMusicDirector());
			pst.setString(3, sl.getLyricist());
			pst.setString(4, sl.getSingers());
			pst.setString(5, sl.getMovieName());
			pst.setString(6, sl.getSongLink());
			int rows = pst.executeUpdate();
			Logger.getInstanceOf().info(sql);
			Logger.getInstanceOf().info("No.of Rows Inserted = " + rows);
		} catch (SQLException e) {
			throw new Exception(ErrorConstants.checkInput);
		}
		return true;
	}

}