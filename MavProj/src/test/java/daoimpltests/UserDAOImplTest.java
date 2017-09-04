package daoimpltests;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.positivity.dao.*;
import com.positivity.model.User;
import com.positivity.servlets.BlogConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BlogConfig.class)
public class UserDAOImplTest {
	
	
	@Autowired
	@Qualifier("userdaoimpl")
	UserDAO userdaoimpl;
	
	@Autowired
	private User user;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void SessionFactoryShouldNotBeNull(){
		
		assertNotNull(sessionFactory);
		
	}
	
	@Test
	public void UserDAOImplShouldNotBeNull(){
		
		assertNotNull(userdaoimpl);
		
	}
	
	@Test
	public void UserShouldNotBeNull(){
		
		assertNotNull(user);
		
	}
	
	@Test
	public void CreateUserTest(){
		
		System.out.println(user);
		System.out.println(user.getEmail());
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		System.out.println(user.getPassword());
		System.out.println(user.getUser_id());
		System.out.println(user.getUsername());
		System.out.println(user.getUserrole_id());
		
		userdaoimpl.create(user);
		
	}
	
	@Test
	@Ignore
	public void UpdateUserTest(){
		
		user.setFirstname("Dan");
		user.setLastname("Pickles");
		userdaoimpl.update();
		
	}
	
	@Test
	public void DeleteUserTest(){
		
		System.out.println(user);
		userdaoimpl.delete(user);
	}
	
	@Test
	@Ignore
	public void GetUserTest(){
		
		userdaoimpl.getUserByID();
		
	}
	

}
