package com.positivity.dao;


import org.springframework.stereotype.Repository;

import com.positivity.model.*;

@Repository
public interface UserRoleDAO {
	
	public UserRole getRoleByID(int user_role_id);

}
