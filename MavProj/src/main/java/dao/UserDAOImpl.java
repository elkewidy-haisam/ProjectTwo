package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserDAOImpl implements UserDAO{

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	
	public void createUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
	
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
	
		sessionFactory.getCurrentSession().delete(user);
		
	}

	public String getFullName(User user) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession()
				.createQuery("firstname, lastname FROM User WHERE user_id := user_id").uniqueResult();
		
		
	}

}
