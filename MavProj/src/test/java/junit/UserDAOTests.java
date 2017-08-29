package junit;

import static org.junit.Assert.*;

import org.junit.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import dao.UserDAOImpl;
import model.User;

public class UserDAOTests {
	
	private static ApplicationContext context;
	
	@BeforeClass
	public static void setup(){
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
	}
	
	@Test
	public void createUserTest(){

		User user = new User();
		UserDAOImpl userdaoimpl = context.getBean(UserDAOImpl.class);
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
		UserDAOImpl userdaoimpl = context.getBean(UserDAOImpl.class);
		user.setEmail("haisam99@gmail.com");
		userdaoimpl.updateUser(user);
		
		System.out.println("User " + user.getFirstname() + " " + user.getLastname() + "has been updated.");
		
	}
	

	
	@Test
	public void getFullNameTest(){

		User user = new User();
		UserDAOImpl userdaoimpl = context.getBean(UserDAOImpl.class);
		String fullname = userdaoimpl.getFullName(user);
		
		System.out.println(fullname);
	
	}
	
	@Test
	public void deleteUserTest(){

		User user = new User();
		UserDAOImpl userdaoimpl = context.getBean(UserDAOImpl.class);
		userdaoimpl.deleteUser(user);
		
		System.out.println("User deleted.");
		
	}
	
	
	
	

}
