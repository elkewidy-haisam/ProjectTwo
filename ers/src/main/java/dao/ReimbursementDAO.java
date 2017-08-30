package dao;

import java.sql.Timestamp;
import java.util.List;

import model.Reimbursement;

public interface ReimbursementDAO {

	
	public boolean addReimbursement(Reimbursement reimbursement);
	public boolean approveReimbursement(Reimbursement reimbursement);
	public boolean denyReimbursement(Reimbursement reimbursement);
	
	
	public List<Reimbursement> viewPendingRequests();
	public List<Reimbursement> viewReimbursements();
	public List<Reimbursement> filterByStatus(int reimb_status_id);
	public List<Reimbursement> viewPastReimbursements();
	
	
	
}
