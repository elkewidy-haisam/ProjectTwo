package testing;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import dao.ReimbursementDAO;
import model.Reimbursement;
import utilities.DAOUtilities;

public class ReimbursementMethodTests {
	
	ReimbursementDAO reimbursedao = DAOUtilities.getReimbursementDAO();
	
	@Test
	public void getReimbursementsTest() {
		
		List<Reimbursement> reimbursements = reimbursedao.viewReimbursements();
		
		assertNotNull(reimbursements);
		
	}
	
	@Test
	public void filterByStatusTest() {
		
		List<Reimbursement> reimbursements = reimbursedao.filterByStatus(0);
		
		assertNotNull(reimbursements);
		
	}
	
	
	
/*	@Test
	public void addReimbursementTest() {
		
		Reimbursement reimb = new Reimbursement();
		
		reimb.setReimb_amount(2000);
		reimb.setReimb_author(9000);
		reimb.setReimb_description("Some description for Reimbursement.");
		reimb.setReimb_id(12341235);
		reimb.setReimb_receipt(null);
		reimb.setReimb_submitted(null);
		reimb.setReimb_resolved(null);
		reimb.setReimb_resolver(8000);
		reimb.setReimb_status_id(2);
		reimb.setReimb_type_id(120000);
		
		boolean added = reimbursedao.addReimbursement(reimb);
		
		assertTrue(added);
		
	}*/
	

	
	@Test
	public void approveReimbursementTest() {
	
		Reimbursement reimb = new Reimbursement();
		boolean approved = reimbursedao.approveReimbursement(reimb);
		
		assertTrue(approved);
			
	}
	
	@Test
	public void denyReimbursementTest() {
		
		Reimbursement reimb = new Reimbursement();
		boolean denied = reimbursedao.denyReimbursement(reimb);
		
		assertTrue(denied);
		
	}
	
	@Test
	public void viewPendingReimbursementTest(){
		
		List<Reimbursement> reimb = reimbursedao.viewPendingRequests();
		assertNotNull(reimb);
		
	}

}
