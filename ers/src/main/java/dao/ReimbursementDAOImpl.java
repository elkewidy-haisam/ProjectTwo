package dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import model.Reimbursement;
import utilities.DAOUtilities;

public class ReimbursementDAOImpl implements ReimbursementDAO{
	
	Connection connection = null;
	PreparedStatement stmt = null;
	
	/*------------------------------------------------*/
	
	// adds the reimbursement request sent by the user to the corresponding table in the database
	// sends the reimbursement request via user-input to the system
	@Override
	public boolean addReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO ERS_REIMBURSEMENT VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			
			
			stmt.setInt(1, reimbursement.getReimb_id());
			stmt.setDouble(2,  reimbursement.getReimb_amount());
			stmt.setTimestamp(3, reimbursement.getReimb_submitted());
			stmt.setTimestamp(4,  reimbursement.getReimb_resolved());
			stmt.setString(5,  reimbursement.getReimb_description());
			stmt.setBytes(6,  reimbursement.getReimb_receipt());
			stmt.setInt(7,  reimbursement.getReimb_author());
			stmt.setInt(8,  reimbursement.getReimb_resolver());
			stmt.setInt(9,  reimbursement.getReimb_status_id());
			stmt.setInt(10,  reimbursement.getReimb_type_id());
			
			
			if (stmt.executeUpdate() != 0) {
				System.out.println("Reimbursement added.");
				return true;
			} else {
				System.out.println("Reimbursement couldn't be added.");
				return false;
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Reimbursement couldn't be added.");
			return false;
			
		} finally {
			closeResources();
		}
	}
	
	// allows the Finance Manager to approve the reimbursement request sent by the user
	// boolean value of 0 corresponds to true, meaning its been approved
	@Override
	public boolean approveReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = 0, REIMB_RESOLVER = ?, REIMB_RESOLVED = ? WHERE REIMB_ID = ?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1,  reimbursement.getReimb_resolver());
			stmt.setTimestamp(2,  reimbursement.getReimb_resolved());
			stmt.setInt(3,  reimbursement.getReimb_id());
			
			if (stmt.executeUpdate() != 0) {
				System.out.println("Reimbursement approved.");
				return true;
			} else {
				System.out.println("Reimbursement couldn't be approved.");
				return false;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
			
		} finally {
			
			closeResources();
			
		}
		
	}
	
	//allows the Finance Manager to deny a Reimbursement request sent by the user
	//boolean value of 1 corresponds to false, meaning it has been denied
	@Override
	public boolean denyReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = 1, REIMB_RESOLVER = ?, REIMB_RESOLVED = ? WHERE REIMB_ID = ?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1,  reimbursement.getReimb_resolver());
			stmt.setTimestamp(2,  reimbursement.getReimb_resolved());
			stmt.setInt(3,  reimbursement.getReimb_id());
			
			if (stmt.executeUpdate() != 0) {
				System.out.println("Reimbursement successfully denied.");
				return true;
			} else {
				System.out.println("Reimbursement could not be denied successfully.");
				return false;
			
			
		}} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
			
		} finally {
			
			closeResources();
			
		}
		
		
		
	}
	
	//allows the Finance Manager, or the User, to view a pending reimbursement request's details
	//the request is filtered from the database by searching for it using the reimbursement id
	@Override
	public List<Reimbursement> viewPendingRequests() {
		// TODO Auto-generated method stub
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try {
		connection = DAOUtilities.getConnection();
		String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = 9000 AND REIMB_STATUS_ID = 2";
		stmt = connection.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Reimbursement reimbursement = new Reimbursement();
			
			reimbursement.setReimb_id(rs.getInt("REIMB_ID"));
			reimbursement.setReimb_amount(rs.getInt("REIMB_AMOUNT"));
			reimbursement.setReimb_submitted(rs.getTimestamp("REIMB_SUBMITTED"));
			reimbursement.setReimb_resolved(rs.getTimestamp("REIMB_RESOLVED"));
			reimbursement.setReimb_description(rs.getString("REIMB_DESCRIPTION"));
			reimbursement.setReimb_receipt(rs.getBytes("REIMB_RECEIPT"));
			reimbursement.setReimb_author(rs.getInt("REIMB_AUTHOR"));
			reimbursement.setReimb_resolver(rs.getInt("REIMB_RESOLVER"));
			reimbursement.setReimb_status_id(rs.getInt("REIMB_STATUS_ID"));
			reimbursement.setReimb_type_id(rs.getInt("REIMB_TYPE_ID"));
			
			reimbursements.add(reimbursement);
			
		}
		
		rs.close();
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			closeResources();
			
		}
		
		return reimbursements;
	}
	
	//this essentially gets all the reimbursement requests inside the reimbursement table and displays them
	//the Finance Manager may find this useful (will consider creating another one where a user can display his own reimbursement requests only).
	@Override
	public List<Reimbursement> viewReimbursements() {
		// TODO Auto-generated method stub
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try {
		connection = DAOUtilities.getConnection();
		String sql = "SELECT * FROM ERS_REIMBURSEMENT";
		stmt = connection.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Reimbursement reimbursement = new Reimbursement();
			
			reimbursement.setReimb_id(rs.getInt("REIMB_ID"));
			reimbursement.setReimb_amount(rs.getInt("REIMB_AMOUNT"));
			reimbursement.setReimb_submitted(rs.getTimestamp("REIMB_SUBMITTED"));
			reimbursement.setReimb_resolved(rs.getTimestamp("REIMB_RESOLVED"));
			reimbursement.setReimb_description(rs.getString("REIMB_DESCRIPTION"));
			reimbursement.setReimb_receipt(rs.getBytes("REIMB_RECEIPT"));
			reimbursement.setReimb_author(rs.getInt("REIMB_AUTHOR"));
			reimbursement.setReimb_resolver(rs.getInt("REIMB_RESOLVER"));
			reimbursement.setReimb_status_id(rs.getInt("REIMB_STATUS_ID"));
			reimbursement.setReimb_type_id(rs.getInt("REIMB_TYPE_ID"));
			
			reimbursements.add(reimbursement);
			
		}
		
		rs.close();
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			closeResources();
			
		}
		
		return reimbursements;
	}
	
	
	//The Finance Manager can filter reimbursement requests based on status of approval.
	//If approved, should pass an integer of 0; if denied then should pass an integer of 1.
	@Override
	public List<Reimbursement> filterByStatus(int reimb_status_id) {
		// TODO Auto-generated method stub
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try {
		connection = DAOUtilities.getConnection();
		String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID = ?";
		stmt = connection.prepareStatement(sql);
		
		stmt.setInt(1, reimb_status_id);
		
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
			
			Reimbursement reimbursement = new Reimbursement();
			reimbursement.setReimb_id(rs.getInt("REIMB_ID"));
			reimbursement.setReimb_amount(rs.getInt("REIMB_AMOUNT"));
			reimbursement.setReimb_submitted(rs.getTimestamp("REIMB_SUBMITTED"));
			reimbursement.setReimb_resolved(rs.getTimestamp("REIMB_RESOLVED"));
			reimbursement.setReimb_description(rs.getString("REIMB_DESCRIPTION"));
			reimbursement.setReimb_receipt(rs.getBytes("REIMB_RECEIPT"));
			reimbursement.setReimb_author(rs.getInt("REIMB_AUTHOR"));
			reimbursement.setReimb_resolver(rs.getInt("REIMB_RESOLVER"));
			reimbursement.setReimb_status_id(rs.getInt("REIMB_STATUS_ID"));
			reimbursement.setReimb_type_id(rs.getInt("REIMB_TYPE_ID"));
			
			reimbursements.add(reimbursement);
			
		}
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			closeResources();
			
		}
		
		return reimbursements;
	}
	
	/*------------------------------------------------------*/
	
	@Override
	public List<Reimbursement> viewPastReimbursements() {
		
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try {
		connection = DAOUtilities.getConnection();
		String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = 9000 AND (REIMB_STATUS_ID = 2 OR REIMB_STATUS_ID = 1)";
		stmt = connection.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Reimbursement reimbursement = new Reimbursement();
			
			reimbursement.setReimb_id(rs.getInt("REIMB_ID"));
			reimbursement.setReimb_amount(rs.getInt("REIMB_AMOUNT"));
			reimbursement.setReimb_submitted(rs.getTimestamp("REIMB_SUBMITTED"));
			reimbursement.setReimb_resolved(rs.getTimestamp("REIMB_RESOLVED"));
			reimbursement.setReimb_description(rs.getString("REIMB_DESCRIPTION"));
			reimbursement.setReimb_receipt(rs.getBytes("REIMB_RECEIPT"));
			reimbursement.setReimb_author(rs.getInt("REIMB_AUTHOR"));
			reimbursement.setReimb_resolver(rs.getInt("REIMB_RESOLVER"));
			reimbursement.setReimb_status_id(rs.getInt("REIMB_STATUS_ID"));
			reimbursement.setReimb_type_id(rs.getInt("REIMB_TYPE_ID"));
			
			reimbursements.add(reimbursement);
			
		}
		
		rs.close();
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			closeResources();
			
		}
		
		return reimbursements;
		
	}
	
	/*------------------------------------------------------*/
	
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
