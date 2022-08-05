package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/loginerror")
public class LoginErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("input.html");
		dispatcher.include(request, response);
		
		pw.println("<div align=\"center\" style=\"color:red\">");
		pw.println("Username Or Password Incorrect !!! Try Again");
		pw.println("</div>");
		
		
		
	}

}






