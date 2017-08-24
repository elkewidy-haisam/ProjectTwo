package dao;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import model.UserRole;
import utilities.DAOUtilities;

public class UserRoleDAOImpl implements UserRoleDAO{

	public UserRole getRoleByID(int user_role_id) {
		// TODO Auto-generated method stub
		
		UserRole userRole = new UserRole();
				
		Session session = DAOUtilities.getSessionFactory().openSession();
				
		session.beginTransaction();
				
		Query query = session.createQuery("from UserRole where user_role_id := user_role_id");
		query.setParameter("user_role_id",user_role_id);
				
		userRole = query.uniqueResult();
				
		session.getTransaction().commit();
			
			
		}
		

}
