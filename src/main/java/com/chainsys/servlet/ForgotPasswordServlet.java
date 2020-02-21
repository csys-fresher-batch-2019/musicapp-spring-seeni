package com.chainsys.servlet;
import com.chainsys.otherclass.Logger;
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

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("mail");
		ForgotPasswordDAOImpl f=new ForgotPasswordDAOImpl();
		try {
			HttpSession session=request.getSession();
			boolean bo=f.checkEmail(email);
			Logger.getInstanceOf().info(bo);
			if(bo) {
				String b=f.pwdChange(email);
				session.setAttribute("mailpwd", b);
				session.setAttribute("email", email);
				Logger.getInstanceOf().info("User Email is "+email);
				Logger.getInstanceOf().info("User Mail password is "+b);
				RequestDispatcher rd=request.getRequestDispatcher("MailGeneratedPassword.jsp");
				rd.forward(request, response);
			}else {
				String error="Invalid EmailID";
				response.sendRedirect("ForgotPwd.jsp?result="+error);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
