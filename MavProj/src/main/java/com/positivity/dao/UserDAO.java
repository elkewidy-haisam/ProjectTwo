package com.positivity.dao;

import org.springframework.stereotype.Repository;

import com.positivity.model.User;

@Repository
public interface UserDAO {
	
	public void create(User user);
	
	public User getUserByID(int user_id);
	
	public void update(User user);
	
	public void delete(User user);

}
