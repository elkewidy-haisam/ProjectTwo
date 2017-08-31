package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Reimbursement;
import model.ReimbursementStatus;
import model.ReimbursementType;
import utilities.DAOUtilities;

public class ReimbursementStatusDAOImpl implements ReimbursementStatusDAO{

	Connection connection = null;
	PreparedStatement stmt = null;
	
	//----------------------------------------------------------------------------------------------
	
	
	//acquires reimbursement status by the reimbursement id
	//this should allow us to see on the tables that the status is actually "APPROVED", "DENIED", or "PENDING" as opposed to just numbers
	@Override
	public ReimbursementStatus getReimbursementStatusByID(Reimbursement reimbursement) {
		ReimbursementStatus reimburseStatus = new ReimbursementStatus();
		
		try {
			
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, reimbursement.getReimb_type_id());
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				reimburseStatus.setReimb_status(rs.getString("REIMB_TYPE"));
				reimburseStatus.setReimb_status_id(rs.getInt("REIMB_TYPE_ID"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			closeResources();
		}
		
		
		return reimburseStatus;
	}
	
	
	
	
	
//--------------------------------------------------------------------------------------------------------------------/
	
	//closes resources in order to conserve them
	private void closeResources() {
		
		try {
			
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
		
	}

}
