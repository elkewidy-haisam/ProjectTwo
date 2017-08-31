package utilities;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;



public class TestConnection {
	
		private static final String url = "jdbc:oracle:thin:@chinook-1707-java.crwnhws3xbwv.us-east-2.rds.amazonaws.com:1521:ORCL";
		private static final String pass = "texas123";
		private static final String user = "elkewidyhaisam";
	
	public static void main(String[] args) {
		
		try {
			
			//loading OJDBC jar driver.
			Class.forName("oracle.jdbc.OracleDriver");
			
			//acquire database connection
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			DatabaseMetaData meta = conn.getMetaData();
			
			//reveal that the connection was acquired
			System.out.println(meta.getDatabaseProductVersion());
			System.out.println(conn);
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}