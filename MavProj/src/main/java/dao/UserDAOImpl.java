package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.User;
import utilities.DAOUtilities;

public class UserDAOImpl implements UserDAO{

	Session session = null;
	
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		
		if (user !=null) {
			
			try {
			
			Session session = DAOUtilities.getSessionFactory().openSession();
			
			session.beginTransaction();
			
			session.save(user);
			
			session.getTransaction().commit();
			
			return true;
			
			} catch (Exception e) {
			
			e.printStackTrace();
			
			session.getTransaction().rollback();
			
			return false;
			
			}
			
		} else {
			
			return false;
			
		}
		
	}

	public User updateUser(User user) {
		// TODO Auto-generated method stub
		
		if (user != null) {
			
			try {
			
				Session session = DAOUtilities.getSessionFactory().openSession();
				
				session.beginTransaction();
				
				Query query = session.createQuery("UPDATE User SET firstname := firstname, lastname := lastname, email := email, password := password");
				
				query.executeUpdate();
				session.save(user);
				
				session.getTransaction().commit();
				
				return true;
			
			} catch (Exception e) {
			
				e.printStackTrace();
				session.getTransaction().rollback();
				
				return false;
			
			}
			
			} else {
			
			return false;
			
			}
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		if (user !=null) {
			
			try {
			
				Session session = DAOUtilities.getSessionFactory().openSession();	
					
				session.beginTransaction();
				
				session.delete(user);
				
				session.getTransaction().commit();
			
			} catch (Exception e) {
				
				e.printStackTrace();
				
				session.getTransaction().rollback();
				
			}
		}
	}

	public List<String> getFullName(User user) {
		// TODO Auto-generated method stub
		if (user !=null) {
			
			try {
				
				Session session = DAOUtilities.getSessionFactory().openSession();
				
				session.beginTransaction();
				
				Query query = session.createQuery("firstname, lastname FROM User WHERE user_id := user_id");
				
				List<String> fullname = (ArrayList<String>) query.list();
				
				session.getTransaction().commit();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				session.getTransaction().rollback();
				
			}
			
		}
		
	}

}
