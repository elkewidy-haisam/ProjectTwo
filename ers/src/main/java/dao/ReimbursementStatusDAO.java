package dao;

import model.Reimbursement;
import model.ReimbursementStatus;

public interface ReimbursementStatusDAO {
	
	public ReimbursementStatus getReimbursementStatusByID(Reimbursement reimbursement);
	

}
