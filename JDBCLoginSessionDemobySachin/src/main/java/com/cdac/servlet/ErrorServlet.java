package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/err")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		handelError(request, response);
	}

	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		handelError(request, response);
	}
	
	private void handelError(HttpServletRequest request, 
				HttpServletResponse response)throws ServletException, IOException {
			
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Error Demo</title>");
		pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
		pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div class=\"container\">");
		
		Integer status = (Integer)
			request.getAttribute("jakarta.servlet.error.status_code"); 
		
		if(status != null && status.intValue() == 500)
		pw.println("<h1 style=color:red>Internal issue has occurred ,"
				+ " Please contact system admin for it </h1>");	
		
		if(status != null && status.intValue() == 404)
			pw.println("<h1 style=color:red>Please check url that"
					+ " you have used , it is inappropriate </h1>");
		
		pw.println("<h1 style=color:red> exception is : "+
				(Throwable)
				request.getAttribute("jakarta.servlet.error.exception")+
				"</h1>");
		
//		if((Integer)
//				!= null)
//		pw.println("<h1 style=color:red> requested page is not available </h1>");
//		
//		pw.println("<h1 style=color:red> requested page is : "+
//		(String)request.getAttribute("jakarta.servlet.error.request_uri")+
//		"</h1>");
		
		pw.println("</body>");
		pw.println("</html>");
	}

}


















