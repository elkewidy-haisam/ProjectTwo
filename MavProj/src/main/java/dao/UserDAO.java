package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.User;

@Repository
public interface UserDAO {
	
	public void createUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	public String getFullName(User user);

}
