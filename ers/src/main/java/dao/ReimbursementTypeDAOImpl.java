package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Reimbursement;
import model.ReimbursementType;
import utilities.DAOUtilities;

public class ReimbursementTypeDAOImpl implements ReimbursementTypeDAO {

	Connection connection = null;
	PreparedStatement stmt = null;
	
	/*---------------------------------------------------------------------------------*/
	
	// gets the reimbursement type for selected request by its ID number.
	@Override
	public ReimbursementType getReimbursementTypeByID(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		ReimbursementType reimburseType = new ReimbursementType();
		
		try {
			
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, reimbursement.getReimb_type_id());
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				reimburseType.setReimb_type(rs.getString("REIMB_TYPE"));
				reimburseType.setReimb_type_id(rs.getInt("REIMB_TYPE_ID"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			closeResources();
		}
		
		
		return reimburseType;
}





//-------------------------------------------------------------------------------/

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
		
	}}
