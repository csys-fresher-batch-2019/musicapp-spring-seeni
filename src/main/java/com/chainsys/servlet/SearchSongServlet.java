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

import com.chainsys.models.SongList;
import com.chainsys.musicapp.implementation.SelectByLikeTab2DAOImpl;
import com.chainsys.service.SelectByLikeService;

@WebServlet("/SearchSongServlet")
public class SearchSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * To search the songs by names
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchName = request.getParameter("search");
		/*
		 * List<String> link = new ArrayList<String>(); List<String> song = new
		 * ArrayList<String>();
		 */
		try {

			List<SongList> songDetailsList = SelectByLikeService.selectByLikeKey("%" + searchName.toUpperCase() + "%");
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
