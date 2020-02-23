package com.chainsys.SongList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.otherclass.Connection1;
import com.chainsys.otherclass.Logger;
import com.chainsys.otherclass.SongList;

public class SelectByLikeTab2DAOImpl implements SelectByLikeTab2DAO {

	/**
	 * Search all the song name and song link
	 */

	public List<SongList> selectByLikeKey(String str) throws ClassNotFoundException, SQLException {
		Logger.getInstanceOf().info(str);
		List<SongList> li = null;
		String sql = "select song_name,song_link from song_list where song_name like ?";
		try (Connection con = Connection1.connection(); PreparedStatement pst = con.prepareStatement(sql);) {
			Logger.getInstanceOf().info(sql);
			pst.setString(1, str);
			li = new ArrayList<SongList>();
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					SongList sl = new SongList();
					sl.setSongName(rs.getString("song_name"));
					sl.setSongLink(rs.getString("song_link"));
					li.add(sl);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println(li);
		return li;
	}/*
		 * public static void main(String[] args) throws ClassNotFoundException,
		 * SQLException { SelectByLikeTab2DAOImpl s=new SelectByLikeTab2DAOImpl();
		 * s.selectByLikeKey("%A%"); }
		 */
}
