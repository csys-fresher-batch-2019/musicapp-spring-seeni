package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PasswordValidation")
public class PasswordValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * It checks the user entered correct mail auto-generated password or not
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*
		 * String em=request.getParameter("mail"); session.setAttribute("m",em);
		 */
		String em = (String) session.getAttribute("email");
		String mpwd = (String) session.getAttribute("mailpwd");
		String emailID = (String) session.getAttribute("email");
		String mailGenPwd = request.getParameter("mailpwd");
		// ForgotPasswordDAOImpl f=new ForgotPasswordDAOImpl();

		if (em.equals(emailID) && mpwd.equals(mailGenPwd)) {

			/*
			 * SelectByPremium sp=new SelectByPremium(); try { List<String>
			 * mailId=sp.premiumMembers("Y"); for(String str:mailId) { if(email.equals(str))
			 * { RequestDispatcher rd=request.getRequestDispatcher("PremiumSongList.jsp");
			 * rd.forward(request, response); } }RequestDispatcher
			 * rd=request.getRequestDispatcher("songlist.jsp"); rd.forward(request,
			 * response); } catch (ClassNotFoundException e) { e.printStackTrace(); } catch
			 * (SQLException e) { e.printStackTrace(); }
			 */
			RequestDispatcher rd = request.getRequestDispatcher("NewPassword.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("message", "Wrong Password"); // Will be available as ${message}
			request.getRequestDispatcher("MailGeneratedPassword.jsp").forward(request, response);
		}
		/*
		 * RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		 * rd.forward(request, response);
		 */

	}

}
