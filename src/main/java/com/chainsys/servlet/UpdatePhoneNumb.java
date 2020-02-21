package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.OtherClass.Logger;
import com.chainsys.OtherClass.Msg91;

@WebServlet("/UpdatePhoneNum")
public class UpdatePhoneNumb extends HttpServlet {
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		 HttpSession ses=request.getSession();
		 String numStr=request.getParameter("NewNumber");
		 	long mobNum=Long.parseLong(numStr);
			String email=(String)ses.getAttribute("mailId");
			Logger.info(email);
			ses.setAttribute("NewMobileNumber",mobNum);
			int otpNum=Msg91.msg(numStr);
			Logger.info("OTP is "+otpNum);
			ses.setAttribute("otpNum", otpNum);
			RequestDispatcher rd=request.getRequestDispatcher("OTPVerification.jsp");
			rd.forward(request, response);
			
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}
}
