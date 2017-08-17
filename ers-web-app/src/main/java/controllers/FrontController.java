package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	
	private UserController userController;
	private ReimbursementController reimbursementController;
	
	@Override
	public void init() throws ServletException {
		
		userController = new UserController();
		reimbursementController = new ReimbursementController();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doDispatch(req, resp);
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doDispatch(req, resp);
		
	}
	
	
	private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String requestURI = req.getRequestURI();
		System.out.println(requestURI);
		
		switch(requestURI){
		
		
		//UserDAO methods
		
		case "/ers-web-app/login.do":{
			userController.login(req, resp);
			break;
		}
		//ReimbursementDAO methods
			
		case "/ers-web-app/create.do":{
			reimbursementController.create(req, resp);
			break;	
		}
		
		case "/ers-web-app/getPending.do":{
			reimbursementController.getPending(req, resp);
			break;
		}
		
		case "/ers-web-app/getAll.do":{
			reimbursementController.getAll(req, resp);
			break;
		}
		
		case "/ers-web-app/approve.do":{
			reimbursementController.approve(req, resp);
			break;
		}
		
		case "/ers-web-app/deny.do":{
			reimbursementController.deny(req, resp);
			break;
		}
		
		}
		
	}
	

}
