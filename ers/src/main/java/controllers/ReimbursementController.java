package controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ReimbursementDAO;
import dao.ReimbursementStatusDAO;
import dao.ReimbursementTypeDAO;
import model.Reimbursement;
import model.ReimbursementStatus;
import model.ReimbursementType;
import utilities.DAOUtilities;

public class ReimbursementController {
	
	public boolean addReimbursement(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		ReimbursementDAO reimbursedao = DAOUtilities.getReimbursementDAO();
		
		ObjectMapper omapper = new ObjectMapper();
		
		Reimbursement reimbursement = omapper.readValue(req.getInputStream(), Reimbursement.class);
		
		System.out.println("Reimbursement: " + reimbursement);
		
		System.out.println("Trying to add a reimbursement.");
		System.out.println("reimbursement: " + reimbursement.toString());
		
		boolean added = reimbursedao.addReimbursement(reimbursement);
		
		return added;
	
	}
	
	public boolean approveReimbursement(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		ReimbursementDAO reimbursedao = DAOUtilities.getReimbursementDAO();
		ObjectMapper omapper = new ObjectMapper();
		
		Reimbursement reimbursement = omapper.readValue(req.getInputStream(), Reimbursement.class);
		
		boolean approved = reimbursedao.approveReimbursement(reimbursement);
		
		return approved;
		
	}
	
	public boolean denyReimbursement(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		ReimbursementDAO reimbursedao = DAOUtilities.getReimbursementDAO();
		ObjectMapper omapper = new ObjectMapper();
		
		Reimbursement reimbursement = omapper.readValue(req.getInputStream(), Reimbursement.class);
		
		boolean denied = reimbursedao.denyReimbursement(reimbursement);
		
		if (denied) {
		
		return true;
			
		} else {
			
		
		return false;	
			
		}
		
	}
	
	public void viewPendingRequests(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		ReimbursementDAO reimbursedao = DAOUtilities.getReimbursementDAO();
		ObjectMapper omapper = new ObjectMapper();
		
		List<Reimbursement> reimbursements = reimbursedao.viewPendingRequests();
		omapper.writeValue(resp.getWriter(), reimbursements);
		
		
	}
	
	public void viewReimbursements(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		ReimbursementDAO reimbursedao = DAOUtilities.getReimbursementDAO();
		
		List<ReimbursementType> reimbursetypes = new ArrayList<>();
		List<ReimbursementStatus> reimbursestatuses = new ArrayList<>();
		
		ObjectMapper omapper = new ObjectMapper();
		
		List<Reimbursement> reimbursements = reimbursedao.viewReimbursements();
		
		//writes reimbursements, along with their types and statuses, to JSON.
		omapper.writeValue(resp.getWriter(), reimbursements);
		
	}
	
	public void FilterByStatus(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		ReimbursementDAO reimbursedao = DAOUtilities.getReimbursementDAO();
		
		int status = Integer.parseInt(req.getParameter("status"));
		List<Reimbursement> reimbursements = reimbursedao.filterByStatus(status);
		
	}

	public void viewPastReimbursements(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		ReimbursementDAO reimbursedao = DAOUtilities.getReimbursementDAO();
		ObjectMapper omapper = new ObjectMapper();
		
		List<Reimbursement> reimbursements = reimbursedao.viewPastReimbursements();
		omapper.writeValue(resp.getWriter(), reimbursements);
		
		
	}
	
	

}
