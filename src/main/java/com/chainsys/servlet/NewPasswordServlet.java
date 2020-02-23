package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.UserLogin.ForgotPasswordDAOImpl;

@WebServlet("/NewPasswordServlet")
public class NewPasswordServlet extends HttpServlet {

	/**
	 * Whether the user wants to change their passwords from auto-generated
	 * passwords
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mailId = (String) session.getAttribute("email");
		System.out.println(mailId);
		String newPass = request.getParameter("newpwd");
		String cnfmPass = request.getParameter("cnfmpwd");
		ForgotPasswordDAOImpl f = new ForgotPasswordDAOImpl();
		if (newPass.equals(cnfmPass)) {
			try {
				boolean b = f.newPassUpdate(cnfmPass, mailId);
				if (b) {
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				} else {
					response.sendRedirect("PasswordValidation?result=Invalid input");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			request.setAttribute("msg", "Password must be same");
			request.getRequestDispatcher("NewPassword.jsp").forward(request, response);
		}
	}

}
