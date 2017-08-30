package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;
import dao.ReimbursementStatusDAO;
import dao.ReimbursementStatusDAOImpl;
import dao.ReimbursementTypeDAO;
import dao.ReimbursementTypeDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;

public class DAOUtilities {
	
	private static final String URL = "jdbc:oracle:thin:@chinook-1707-java.crwnhws3xbwv.us-east-2.rds.amazonaws.com:1521:orcl";
	private static final String CONNECTION_PASSWORD = "texas123";
	private static final String CONNECTION_USERNAME = "elkewidyhaisam";
	
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		System.out.println(connection);
		return connection;
	}
	
	
	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	}
	
	public static ReimbursementDAO getReimbursementDAO() {
		return new ReimbursementDAOImpl();
	}
	
	public static ReimbursementTypeDAO getReimbursementTypeDAO() {
		return new ReimbursementTypeDAOImpl();
	}
	
	public static ReimbursementStatusDAO getReimbursementStatusDAO() {
		return new ReimbursementStatusDAOImpl();
	}

}
