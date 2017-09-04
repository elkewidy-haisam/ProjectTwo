package com.positivity.dao;

import com.positivity.model.User;

public interface UserDAO {
	
	public void create(User user);
	
	public User getUserByID(int user_id);
	
	public void update(User user);
	
	public void delete(User user);

}
