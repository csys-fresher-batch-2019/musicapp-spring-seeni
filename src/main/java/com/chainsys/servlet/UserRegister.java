package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.otherclass.Logger;
import com.chainsys.otherclass.Register;
import com.chainsys.otherclass.Userlogin;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * To insert new user registration into the database
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		com.chainsys.otherclass.Userlogin ul = new Userlogin();
		String mail = request.getParameter("email");
		ul.setEmailId(mail);
		String pwd = request.getParameter("password");
		ul.setPassword(pwd);
		String name = request.getParameter("username");
		ul.setUserName(name);
		//String id = request.getParameter("number");

		/*
		 * int uId=Integer.parseInt(id); System.out.println(uId); ul.setUserId(uId);
		 */
		String mobileNo = request.getParameter("mobileNumber");
		System.out.println(mobileNo);
		long mobNo = Long.parseLong(mobileNo);
		ul.setMobileNo(mobNo);
		Register reg = new Register();
		try {

			boolean res = reg.register(ul);
			if (res) {
				RequestDispatcher r = request.getRequestDispatcher("login.jsp");
				r.forward(request, response);
			}
		} catch (Exception e1) {
			Logger.getInstanceOf().error(e1.getMessage());
		}
	}

}
