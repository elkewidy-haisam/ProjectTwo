package com.positivity.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.positivity.model.*;


@Repository("userroledaoimpl")
public class UserRoleDAOImpl implements UserRoleDAO{

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public UserRole getRoleByID(int user_role_id) {
		// TODO Auto-generated method stub
		
		return (UserRole) sessionFactory.getCurrentSession()
				.createQuery("from UserRole where user_role_id =:role_id").uniqueResult();
			
	}
		

}
