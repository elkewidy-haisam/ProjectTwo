package dao;

import java.util.List;

import model.User;

public interface UserDAO {
	
	public boolean createUser(User user);
	
	public User updateUser(User user);
	
	public boolean deleteUser(User user);
	
	public List<String> getFullName(User user);

}
