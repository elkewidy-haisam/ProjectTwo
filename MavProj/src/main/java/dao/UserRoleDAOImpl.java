package dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.UserRole;


public class UserRoleDAOImpl implements UserRoleDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	
	
	public UserRole getRoleByID(int user_role_id) {
		// TODO Auto-generated method stub
		
		return (UserRole) sessionFactory.getCurrentSession()
				.createQuery("from UserRole where user_role_id := user_role_id").uniqueResult();
			
	}
		

}
