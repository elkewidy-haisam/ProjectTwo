package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import model.User;
import utilities.DAOUtilities;

public class UserDAOImpl implements UserDAO{
	
	Connection connection = null;
	PreparedStatement stmt = null;
	
	/*---------------------------------------------------------*/
	
	
	@Override
	public User getUserCredentials(String username, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		
		try {
			
			// JBCrypt API for hashing individual user passwords.
			String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
						
			//establish connection to the database			
			connection = DAOUtilities.getConnection();
			
			//query to select user with given username and password
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";
			stmt = connection.prepareStatement(sql);
			
			//setting the username and hashed password as parameters for the PreparedStatement
			stmt.setString(1, username);
			stmt.setString(2,  hashed);
			ResultSet rs = stmt.executeQuery();
			
			//check to see if hashed password and actual password match.
			if (BCrypt.checkpw(password, hashed))
				System.out.println("It matches.");
			else
				System.out.println("It does not match.");
						
			if (rs != null) {

				System.out.println("Credentials found.");
							
							
				} else {
							
				System.out.println("User credentials not found.");
							
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			closeResources();
			
		}
		
		return user;
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

