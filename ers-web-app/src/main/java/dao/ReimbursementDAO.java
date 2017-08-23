package dao;

import java.util.Collection;
import java.util.HashMap;

import model.Reimbursement;

public class ReimbursementDAO {
	
	private static HashMap<Integer, Reimbursement> reimbursements = new HashMap<>();
	
	public void create(Reimbursement reimbursement){
		
		int pk = reimbursements.keySet().size() + 1;
		reimbursement.setReimb_id(pk);
		reimbursements.putIfAbsent(reimbursement.getReimb_id(), reimbursement);
		
	}
	
	public Collection<Reimbursement> getAll(){
		
		return reimbursements.values();
		
	}
	
	public Collection<Reimbursement> getPending(){
		
		reimbursements.put(reimbursement.getReimb_id(), reimbursement);
		
	};
	
	public void update(Reimbursement reimbursement){
		
		reimbursements.put(reimbursement.getReimb_id(), reimbursement);
		
	};
	
	//in case you need it
	public void delete(Reimbursement reimbursement){
		
		
	};

}
