package com.chainsys.SongList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.otherclass.Connection1;
import com.chainsys.otherclass.Logger;

public class SearchSongTab2DAOImpl implements SearchSongTab2DAO{
	List<String> arli=null;
	public List<String> searchSongName() throws ClassNotFoundException, SQLException {
		
		String sql="select song_name from song_list";
		try(Connection con=Connection1.connection();
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();){
		Logger.getInstanceOf().info(sql);
		arli=new ArrayList<String>();
		while(rs.next()) {
			arli.add(rs.getString("song_name"));
		}
		for (String string : arli) {
			System.out.println(string);
		}
		
	}
	catch(Exception e) {
	//throw new Exception(ErrorConstants.checkInput);
		e.getMessage();
}
return arli;
}
}