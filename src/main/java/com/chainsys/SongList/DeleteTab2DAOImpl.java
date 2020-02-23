package com.chainsys.SongList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.chainsys.otherclass.Connection1;
import com.chainsys.otherclass.Logger;

/**
 * For admin wants to delete the song from existing one
 * 
 * @author seen2380
 *
 */

public class DeleteTab2DAOImpl implements DeleteTab2DAO {
	public void delRow(String sName) throws SQLException, ClassNotFoundException {
		String sql = "delete song_list where song_number=?";
		try (Connection con = Connection1.connection(); PreparedStatement pst = con.prepareStatement(sql);) {
			Logger.getInstanceOf().info(sql);
			pst.setString(1, sName);
			int rows = pst.executeUpdate();
			Logger.getInstanceOf().info("No. of songs deleted " + rows);
		}
	}
}
