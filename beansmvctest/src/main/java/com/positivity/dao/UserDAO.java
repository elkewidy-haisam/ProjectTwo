package com.positivity.dao;

import com.positivity.model.User;

public interface UserDAO {
	
	public void create(User user);
	
	public void getUserByID();
	
	public void update();
	
	public void delete(User user);

}
