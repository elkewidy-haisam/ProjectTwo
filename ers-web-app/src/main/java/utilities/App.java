package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	
	private static String url = "jdbc:oracle:thin:@chinook-1707-java.crwnhws3xbwv.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String pass = "texas123";
	private static String user = "elkewidyhaisam";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. Load Driver (reflection API)
		Class.forName("oracle.jdbc.OracleDriver");
		// 2. Get Connection
		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println(conn);
		
	}
}