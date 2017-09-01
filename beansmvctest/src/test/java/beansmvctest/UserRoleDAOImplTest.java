package beansmvctest;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.positivity.dao.BlogConfig;
import com.positivity.dao.UserRoleDAO;
import com.positivity.model.UserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BlogConfig.class)
public class UserRoleDAOImplTest {
	
	
	@Autowired
	UserRoleDAO userroledaoimpl;
	
	@Autowired
	private UserRole userRole;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void SessionFactoryShouldNotBeNull(){
		
		assertNotNull(sessionFactory);
		
	}
	
	@Test
	public void UserRoleDAOImplShouldNotBeNull(){
		
		assertNotNull(userroledaoimpl);
		
	}
	
	@Test
	public void UserRoleShouldNotBeNull(){
		
		assertNotNull(userroledaoimpl);
		
	}
	
	@Test
	public void getRoleByIDTest() {
		
		int user_role_id = 1000100;
		userroledaoimpl.getRoleByID(user_role_id);
		
		System.out.println("User Role is: " + userRole.getDescription());
		
		
	}
	
	
	
	
	
	
	

}
