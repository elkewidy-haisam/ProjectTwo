package junit;

import static org.junit.Assert.*;

import org.junit.*;

import org.junit.Test;

import dao.UserDAOImpl;
import model.User;

public class UserDAOTests {
	
	User user = new User();
	UserDAOImpl userdaoimpl = new UserDAOImpl();
	
	@Test
	public void createUserTest(){
		
		user.setEmail("elkewidyhaisam@gmail.com");
		user.setFirstname("Haisam");
		user.setLastname("Elkewidy");
		user.setPassword("password");
		user.setUsername("elkewidy-haisam");
		userdaoimpl.createUser(user);
		
		System.out.println("User " + user.getFirstname() + " " + user.getLastname() + " has been created.");
		
	}
	
	@Test
	public void updateUserTest(){
		
		user.setEmail("haisam99@gmail.com");
		userdaoimpl.updateUser(user);
		
		System.out.println("User " + user.getFirstname() + " " + user.getLastname() + "has been updated.");
		
	}
	

	
	@Test
	public void getFullNameTest(){
		
		String fullname = userdaoimpl.getFullName(user);
		
		System.out.println(fullname);
	
	}
	
	@Test
	public void deleteUserTest(){
		
		userdaoimpl.deleteUser(user);
		
		System.out.println("User deleted.");
		
	}
	
	
	
	

}
