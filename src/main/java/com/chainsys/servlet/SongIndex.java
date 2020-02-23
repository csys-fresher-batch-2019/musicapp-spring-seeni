package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.SongList.SearchSongTab2DAOImpl;
import com.chainsys.otherclass.SongLink;

@WebServlet("/SongIndex")
public class SongIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * To get all the names and their respective links of the songs
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SongLink sl = new SongLink();
			List<String> li = sl.songLink();
			SearchSongTab2DAOImpl s1 = new SearchSongTab2DAOImpl();
			List<String> song = s1.searchSongName();
			request.setAttribute("songlink", li);
			request.setAttribute("song", song);

			RequestDispatcher rd = request.getRequestDispatcher("songlist.jsp");
			rd.forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
