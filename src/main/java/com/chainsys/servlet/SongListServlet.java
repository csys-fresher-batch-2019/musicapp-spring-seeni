package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.SongList.InsertTab2DAO;
import com.chainsys.SongList.InsertTab2DAOImpl;
import com.chainsys.otherclass.SongList;

@WebServlet("/SongListServlet")
public class SongListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * To insert a new songs into the database by admin
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SongList sl = new SongList();
		String sname = request.getParameter("songName").toUpperCase();
		sl.setSongName(sname);
		String mDirector = request.getParameter("mDir").toUpperCase();
		sl.setMusicDirector(mDirector);
		String lyr = request.getParameter("lyric").toUpperCase();
		sl.setLyricist(lyr);
		String singers = request.getParameter("singer").toUpperCase();
		sl.setSingers(singers);
		String movie = request.getParameter("mName").toUpperCase();
		sl.setMovieName(movie);
		String songLink = request.getParameter("slink");
		sl.setSongLink(songLink);
		InsertTab2DAO in = new InsertTab2DAOImpl();
		try {
			boolean b = in.insertSong(sl);
			if (b) {
				PrintWriter out = response.getWriter();
				out.println("<h1>Successfully Inserted</h1>");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
