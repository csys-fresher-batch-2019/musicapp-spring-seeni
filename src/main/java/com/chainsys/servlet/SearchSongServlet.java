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

import com.chainsys.OtherClass.SongList;
import com.chainsys.SongList.SelectByLikeTab2DAOImpl;
@WebServlet("/SearchSongServlet")
public class SearchSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchName = request.getParameter("search");
		System.out.println(searchName);
		SelectByLikeTab2DAOImpl s = new SelectByLikeTab2DAOImpl();
		/*List<String> link = new ArrayList<String>();
		List<String> song = new ArrayList<String>();
*/
		try {

			List<SongList> songDetailsList = s.selectByLikeKey("%" + searchName.toUpperCase() + "%");
			System.out.println(songDetailsList);
			request.setAttribute("songDetailsList", songDetailsList);
			
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
