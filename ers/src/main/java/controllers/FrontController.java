package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FrontController for UserDAO and ReimbursementDAO
 */
public class FrontController extends HttpServlet {
	
	private UserController userController;
	private ReimbursementController reimbursementController;
	
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException {
		userController = new UserController();
		reimbursementController = new ReimbursementController();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doDispatch(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doDispatch(request, response);
	}


	
	
	private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String requestURI = req.getRequestURI();
		System.out.println(requestURI);
		
		switch(requestURI){
		
		//UserDAO methods
		
		//Login Servlet
		case "/ers/login.do":{
			userController.login(req, resp);
			break;
			}
		
		//ReimbursementDAO methods
		
		//Add Reimbursement
		case "/ers/addReimbursement.do":{
			reimbursementController.addReimbursement(req, resp);
			break;
			}
		
		//Approve Reimbursement
		case "/ers/approveReimbursement.do":{
			reimbursementController.approveReimbursement(req, resp);
			break;
			}
		
		//Deny Reimbursement
		case "/ers/denyReimbursement.do":{
			reimbursementController.denyReimbursement(req, resp);
			break;
			}
		
		//View Pending Reimbursement Requests
		case "/ers/viewPendingReimbursement.do":{
			reimbursementController.viewPendingRequests(req, resp);
			break;
			}
		
		//View Reimbursements
		case "/ers/viewReimbursements.do":{
			reimbursementController.viewReimbursements(req, resp);
			break;
			}
			
		//Filter By Status (either approved or denied)
		case "/ers/filterByStatus.do":{	
			reimbursementController.FilterByStatus(req, resp);
			break;
			}
		case "/ers/viewPastReimbursements.do":{
			reimbursementController.viewPastReimbursements(req, resp);
			break;
		}
		default:{
			
			throw new IllegalArgumentException("Invalid URI");
			
		}
		
		}
		
	}

}
