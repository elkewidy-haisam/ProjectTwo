package dao;

import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Reimbursement;

public class ReimbursementDAO {
	
	private static HashMap<Integer, Reimbursement> reimbursements = new HashMap<>();
	
	public void create(Reimbursement reimbursement);
	
	public Collection<Reimbursement> getAll();
	
	public Collection<Reimbursement> getPending();
	
	public void update(Reimbursement reimbursement);
	
	//in case you need it
	public void delete(Reimbursement reimbursement);

}
