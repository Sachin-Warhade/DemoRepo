package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		HttpSession session = request.getSession(false);

		if (session != null) {

			String uname = (String) session.getAttribute("USERNAME");

			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");

			pw.println("<title>Home Page </title>");

			pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			pw.println("<link rel=\"stylesheet\"\r\n"
					+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
			pw.println("<script\r\n"
					+ "	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>");
			pw.println("<script\r\n"
					+ "	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");

			pw.println("</head>");

			pw.println("<body>");
			pw.println("<div class=\"container\">");

			pw.println("<h1 style=color:green> Welcome " + uname + ", to your profile page </h1>");

			pw.println("<p> Click <a href=\"logout\"> here </a>" + "to LOG OUT</p>");

			pw.println("</body>");
			pw.println("</html>");

		} else {
			response.sendRedirect("notloggedin");
		}
	}
}
