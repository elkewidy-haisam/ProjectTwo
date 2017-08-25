package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

public class UserDAOImpl implements UserDAO{

	private SessionFactory sessionFactory;
	private Session session;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	
	public void createUser(User user) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		sessionFactory.getCurrentSession().save(user);
		session.getTransaction().commit();
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
			
		session.beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		session.getTransaction().commit();
		
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
		session.beginTransaction();
		sessionFactory.getCurrentSession().delete(user);
		session.getTransaction().commit();
		
	}

	public String getFullName(User user) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession()
				.createQuery("firstname, lastname FROM User WHERE user_id := user_id").uniqueResult();
		
		
	}

}
