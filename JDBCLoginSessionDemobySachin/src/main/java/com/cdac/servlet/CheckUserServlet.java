package com.cdac.servlet;

import java.io.IOException;

import com.cdac.dao.UserDao;
import com.cdac.daoimpl.UserDaoImpl;
import com.cdca.pojo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkuser")
// we assume this as controller servlet (this is controller program)MVC this is C part
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("txtUname");
		String pass = request.getParameter("txtPass");

		User user = new User(uname, pass);
		
		UserDao daoimpl = new UserDaoImpl();
		
		if(daoimpl.checkUserCredentials(user)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("USERNAME", uname);
			session.setMaxInactiveInterval(60);
			response.sendRedirect("home");
			
		}else {
			response.sendRedirect("loginerror");
		}
	}

}
