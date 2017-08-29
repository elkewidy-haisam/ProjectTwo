package dao;

import org.springframework.stereotype.Repository;

import model.UserRole;

@Repository
public interface UserRoleDAO {
	
	public UserRole getRoleByID(int user_role_id);

}
