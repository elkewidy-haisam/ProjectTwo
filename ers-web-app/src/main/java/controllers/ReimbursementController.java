package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ReimbursementDAO;
import model.Reimbursement;

public class ReimbursementController {
	
	
	public void create(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		InputStream httpRequestBody = req.getInputStream();
		
		ObjectMapper mapper = new ObjectMapper();
		
		Reimbursement reimb = mapper.readValue(httpRequestBody, Reimbursement.class);
		
		new ReimbursementDAO().create(reimb);
		
	}
	
	public void getPending(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		Reimbursement reimbursement = getFromBody(req);
		
		new ObjectMapper().writeValue(resp.getWriter(), reimbursement);
		
	}
	
	public void getAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		Collection<Reimbursement> reimbursements = new ReimbursementDAO().getAll();
		
		new ObjectMapper().writeValue(resp.getWriter(), reimbursements);
		
	}
	
	public void approve(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		Reimbursement reimbursement = getFromBody(req);
		
		new ObjectMapper().writeValue(resp.getWriter(), reimbursement);
		
	}
	
	public void deny(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		Reimbursement reimbursement = getFromBody(req);
		
		new ObjectMapper().writeValue(resp.getWriter(), reimbursement);
		
	}
	
	
	// meant to acquire JSON object and store into Java Object.
	
	private Reimbursement getFromBody(HttpServletRequest req) throws JsonParseException, JsonMappingException, IOException {
		
		return new ObjectMapper().readValue(req.getInputStream(), Reimbursement.class);
		
	}
	
	
	
	

}
