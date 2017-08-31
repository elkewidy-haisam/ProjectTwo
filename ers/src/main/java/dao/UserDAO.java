package dao;

import model.User;

public interface UserDAO {
	
	public User getUserCredentials(String username, String password);

}
