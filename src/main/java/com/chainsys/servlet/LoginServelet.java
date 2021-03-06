package com.chainsys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.service.LoginService;
import com.chainsys.service.SelectByPremiumService;

@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * To verify the user login details whether it is valid or Invalid and it also
	 * checks whether the user make premium or not
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession se = request.getSession();
		String mailID = request.getParameter("mail");
		se.setAttribute("mailId", mailID);
		System.out.println("EmailId= " + mailID);
		String pwd = request.getParameter("password");
		System.out.println("Password:" + pwd);
		try {
			boolean insert = LoginService.login(mailID, pwd);
			if (insert) {
				List<String> li = SelectByPremiumService.premiumMembers("Y");
				for (String mailCheck : li) {
					if (mailCheck.equals(mailID)) {
						RequestDispatcher r = request.getRequestDispatcher("PremiumNextContent.jsp");
						r.forward(request, response);
					}
				}
				RequestDispatcher r = request.getRequestDispatcher("nextcontent.jsp");
				r.forward(request, response);
			} else {
				String error = "Incorrect Username/Password";
				response.sendRedirect("login.jsp?result=" + error);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
