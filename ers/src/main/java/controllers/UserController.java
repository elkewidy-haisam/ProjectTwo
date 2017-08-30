package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import jbcrypt.BCrypt;
import model.User;
import utilities.DAOUtilities;

public class UserController {
	
	
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());
		
		if (BCrypt.checkpw(password, hashed_password))
			System.out.println("The password matches.");
		else
			System.out.println("The password does not match.");
		
		UserDAO userdao = DAOUtilities.getUserDAO();
		User user = userdao.getUserCredentials(username, hashed_password);
		
		if (username.isEmpty() && hashed_password.isEmpty()) {
			
			req.getSession().setAttribute("message", "Please provide your account credentials.");
			req.getSession().setAttribute("messageClass", "alert-danger");
			
			resp.sendRedirect("login.jsp");
			
			} else if (username.isEmpty() && !hashed_password.isEmpty()) {
			
			req.getSession().setAttribute("message", "Please provide your user name.");
			req.getSession().setAttribute("messageClass", "alert-danger");
			
			resp.sendRedirect("login.jsp");
			
			} else if (hashed_password.isEmpty() && !username.isEmpty()) {
				
			req.getSession().setAttribute("message", "Please provide your password.");
			req.getSession().setAttribute("messageClass", "alert-danger");
			
			resp.sendRedirect("login.jsp");
			
		}
		
		
		if(user != null){
			
			// success: store user in Session-scoped variable
			req.getSession().setAttribute("loggedInUser", user);		
			req.getRequestDispatcher("index.html").forward(req, resp); // this will be replaced later with a single-page application on AngularJS.
			
		} else {
			
			// fail: send request-scope variable to login page
			req.setAttribute("loginFail", "Authentication failure.");
			req.getRequestDispatcher("login.jsp").forward(req, resp);//forward request variables to another page
			
		}
	}
		
		
}
	
