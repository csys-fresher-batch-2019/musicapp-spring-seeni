package com.chainsys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.accountinfo.AccountTab5Tab1DAO;
import com.chainsys.accountinfo.AccountTab5Tab1DAOImpl;
@WebServlet("/PremiumServlet")
public class PremiumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AccountTab5Tab1DAO a=new AccountTab5Tab1DAOImpl();
		List<String> li=a.accountInfo("Y");
		for (String string : li) {
			System.out.println(string);
		}
		
	}

}
