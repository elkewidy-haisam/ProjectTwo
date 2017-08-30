package dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.User;


public class UserDAOImpl implements UserDAO{

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void createUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
		
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void updateUser(User user) {
		// TODO Auto-generated method stub
	
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
	
		sessionFactory.getCurrentSession().delete(user);
		
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public String getFullName(User user) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession()
				.createQuery("firstname, lastname FROM User WHERE user_id := user_id").uniqueResult();
		
	}


}
