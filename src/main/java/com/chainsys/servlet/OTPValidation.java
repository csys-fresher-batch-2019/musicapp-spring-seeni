package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.UserLogin.UpdateTab1DAOImpl;

@WebServlet("/OTPValidation")
public class OTPValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * It checks the user entered OTP is correct or not
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession();
		String userMailID = (String) sess.getAttribute("mailId");
		long number = (Long) sess.getAttribute("NewMobileNumber");
		int otp = Integer.parseInt(request.getParameter("otp"));
		int otpNumber = (Integer) sess.getAttribute("otpNum");
		// int otp =Msg91.msg("6379434293");
		UpdateTab1DAOImpl u = new UpdateTab1DAOImpl();
		if (otp == otpNumber) {
			try {
				u.updatePhoneNo(number, userMailID);
				PrintWriter out = response.getWriter();
				out.println("<h1>Successfully updated</h1>");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (otp != otpNumber) {
			String error = "Wrong OTP";
			response.sendRedirect("OTPVerification.jsp?result=" + error);
		}
	}

}
