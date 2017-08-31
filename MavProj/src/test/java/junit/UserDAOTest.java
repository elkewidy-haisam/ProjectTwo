package junit;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.XmlWebApplicationContext;

import dao.UserDAOImpl;
import model.User;


public class UserDAOTest {
	
	@Autowired
	private static ApplicationContext context;
	
	@BeforeClass
	public static void setup(){
		context = new XmlWebApplicationContext();
	}
	
	@Test
	public void createUserTest(){

		User user = new User();
		UserDAOImpl userdaoimpl = (UserDAOImpl) context.getBean("UserDAOImpl"); 
		
		if (userdaoimpl != null) {
			
			System.out.println("User context acquired.");
			
		} else {
			
			System.out.println("User context not acquired.");
		}
		user.setUsername("bye.felicia");
		user.setFirstname("Bye");
		user.setLastname("Felicia");
		user.setEmail("bye.felicia@gmail.com");
		user.setUserrole_id(1000100);
		user.setPassword("$2a$10$0wePKtcuhxZSGDPnAivqeO26KsdOEqk86D.7TaptT5JKcoLq4McT6");
		
		userdaoimpl.createUser(user);
		
		System.out.println("User " + user.getFirstname() + " " + user.getLastname() + " has been created.");
		
	}
	
	@Test
	public void updateUserTest(){

		User user = new User();
		UserDAOImpl userdaoimpl = (UserDAOImpl) context.getBean("UserDAOImpl"); 
		user.setEmail("haisam99@gmail.com");
		userdaoimpl.updateUser(user);
		
		System.out.println("User " + user.getFirstname() + " " + user.getLastname() + "has been updated.");
		
	}
	

	
	@Test
	public void getFullNameTest(){

		User user = new User();
		UserDAOImpl userdaoimpl = (UserDAOImpl) context.getBean("UserDAOImpl"); 
		String fullname = userdaoimpl.getFullName(user);
		
		System.out.println(fullname);
	
	}
	
	@Test
	public void deleteUserTest(){

		User user = new User();
		UserDAOImpl userdaoimpl = (UserDAOImpl) context.getBean("UserDAOImpl"); 
		userdaoimpl.deleteUser(user);
		
		System.out.println("User deleted.");
		
	}
	
	
	
	

}
