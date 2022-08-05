package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/logoutsuccess")
public class LogoutSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		pw.println("<div align=\"center\" style=\"color:green\">");
		pw.println("LogOut Successfully !!!");
		pw.println("</div>");

		RequestDispatcher dispatcher = request.getRequestDispatcher("input.html");
		dispatcher.include(request, response);

	}

}
