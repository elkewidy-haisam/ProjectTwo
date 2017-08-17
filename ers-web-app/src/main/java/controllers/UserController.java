package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController {
	
	
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		req.getRequestDispatcher("index.html").forward(req, resp);
		
	}
	

}
