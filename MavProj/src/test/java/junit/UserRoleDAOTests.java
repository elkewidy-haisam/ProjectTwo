package junit;

import static org.junit.Assert.*;

import org.junit.*;

import dao.UserRoleDAOImpl;
import model.UserRole;

public class UserRoleDAOTests {
	
	UserRole userrole = new UserRole();
	UserRoleDAOImpl userroledaoimpl = new UserRoleDAOImpl();
	
	@Test
	public void getUserRoleByIDTest() {
		
		int user_role_id = 20;
		userrole = userroledaoimpl.getRoleByID(user_role_id);
		
		assertNotNull(userrole);
		
	}

}
