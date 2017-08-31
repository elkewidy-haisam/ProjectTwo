package testing;

import static org.junit.Assert.*;

import org.junit.Test;
import utilities.DAOUtilities;
import java.sql.Connection;

public class ConnectionTest {
	
	@Test
	public void Connection() throws Exception {
			
		Connection conn = DAOUtilities.getConnection();	
		assertNotNull(conn);	
			
		}

}
