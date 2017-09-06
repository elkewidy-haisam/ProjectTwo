package com.positivity.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.positivity.model.BlogPost;
import com.positivity.model.User;


@Repository("userdaoimpl")
public class UserDAOImpl implements UserDAO{
	
	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void create(User user) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().save(user);
		System.out.println("User created.");
		
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public User getUserByID(int user_id) {
		// TODO Auto-generated method stub
		
		System.out.println("Acquiring user by id: " + user_id);
		
		return (User) sessionFactory.getCurrentSession()
				.createQuery("FROM User WHERE user_id =:user_id").setParameter("user_id", user_id).uniqueResult();
		
		
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void update(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		System.out.println("User updated.");
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void delete(User user) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(user);
		System.out.println("User deleted.");
	}

}
