package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.musicapp.DAO.AdminLoginDAO;
import com.chainsys.musicapp.implementation.AdminLoginDAOImpl;
import com.chainsys.service.AdminDetailService;

@WebServlet("/AdminLoginVerification")
public class AdminLoginVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * To verify the admin login details whether valid or Invalid
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();

		String email = request.getParameter("mail");
		ses.setAttribute("mailID", email);
		System.out.println("Email is " + email);
		String pwd = request.getParameter("password");
		System.out.println("Password is " + pwd);
		try {
			boolean li = AdminDetailService.adminDetailService(email, pwd);
			if (li) {
				RequestDispatcher rd = request.getRequestDispatcher("DisplayForAdmin.jsp");
				rd.forward(request, response);
			} else {
				String error = "Invalid Username/Password";
				response.sendRedirect("Admin.jsp?result=" + error);

			}
		} catch (Exception e) {
			response.sendRedirect("Admin.js?resul=" + e.getMessage());
		}
	}

}
