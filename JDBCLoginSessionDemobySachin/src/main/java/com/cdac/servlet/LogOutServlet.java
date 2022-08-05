package com.cdac.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);

		if (session != null) {

			session.setAttribute("USERNAME",null);
			session.invalidate();
			
			response.sendRedirect("logoutsuccess");
		}
		else {
			response.sendRedirect("notloggedin");
		}
	}
}
