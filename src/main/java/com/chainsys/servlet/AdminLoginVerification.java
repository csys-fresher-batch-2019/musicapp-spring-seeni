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

import com.chainsys.OtherClass.AdminLogin;
@WebServlet("/AdminLoginVerification")
public class AdminLoginVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses=request.getSession();
		
		String email=request.getParameter("mail");
		ses.setAttribute("mailID", email);
		System.out.println("Email is "+email);
		String pwd=request.getParameter("password");
		System.out.println("Password is "+pwd);
		try {
			boolean li=AdminLogin.adminDetails(email,pwd);
			if(li) {
				RequestDispatcher rd=request.getRequestDispatcher("DisplayForAdmin.jsp");
				rd.forward(request, response);
			}else {
				String error="Invalid Username/Password";
				response.sendRedirect("Admin.jsp?result="+error);
				
			}
		} catch (Exception e) {
			response.sendRedirect("Admin.js?resul="+e.getMessage());
		} 
	}

}
