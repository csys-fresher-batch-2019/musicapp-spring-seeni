package com.chainsys.SongList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.otherclass.Connection1;
import com.chainsys.otherclass.ErrorConstants;
import com.chainsys.otherclass.Logger;
import com.chainsys.otherclass.SongList;

public class InsertTab2DAOImpl implements InsertTab2DAO{
	public boolean insertSong(SongList sl) throws Exception  {
		
		String sql ="insert into song_list(song_number,song_name,music_director,lyricist,singers,movie_name,song_link) "
				+ "values(song_seq.nextval,?,?,?,?,?,?)";
		
		try(Connection con=Connection1.connection();
				PreparedStatement pst=con.prepareStatement(sql);){
		pst.setString(1, sl.getSongName());
		pst.setString(2, sl.getMusicDirector());
		pst.setString(3, sl.getLyricist());
		pst.setString(4, sl.getSingers());
		pst.setString(5, sl.getMovieName());
		pst.setString(6, sl.getSongLink());
		int rows=pst.executeUpdate();
		Logger.getInstanceOf().info(sql);
		Logger.getInstanceOf().info("No.of Rows Inserted = "+rows);
		}
		catch(SQLException e) {
			throw new Exception(ErrorConstants.checkInput);
		}return true;
	}

	
}