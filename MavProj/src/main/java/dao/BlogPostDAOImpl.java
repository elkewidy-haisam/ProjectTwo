package dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import model.BlogPost;
import utilities.DAOUtilities;

public class BlogPostDAOImpl implements BlogPostDAO{
	
	

	public boolean addBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		try {
		
		Session session = DAOUtilities.getSessionFactory().openSession();
			
		session.beginTransaction();
		session.save(blogpost);
		session.getTransaction().commit();
		
		return true;
		
		} catch (Exception e) {
			
		e.printStackTrace();
		session.getTransaction().rollback();
			
		return false;
			
		}
	}

	public BlogPost getBlogPostByID(int blogpost_id) {
		// TODO Auto-generated method stub
		
		BlogPost blogpost = new BlogPost();
		
		if (blogpost != null) {
			
			try {
				
			Session session = DAOUtilities.getSessionFactory().openSession();
				
			session.beginTransaction();
				
			blogpost = (BlogPost) session.createCriteria(BlogPost.class)
					.add( Restrictions.eq("blogpost_id", blogpost_id))
					.uniqueResult();
				
			session.getTransaction().commit();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				session.getTransaction().rollback();
				
			}
			
			return blogpost;
			
		}
		
	}

	public boolean editBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		if (blogpost != null) {
			
			try {
				
				Session session = DAOUtilities.getSessionFactory().openSession();
				
				session.beginTransaction();
				Query query = session.createQuery("UPDATE BlogPost SET blogpost_timestamp := blogpost_timestamp, blogpost_content := blogpost_content WHERE blogpost_id := blogpost_id");
				query.setParameter("blogpost_timestamp", blogpost.getBlogpost_timestamp());
				query.setParameter("blogpost_content", blogpost.getBlogpost_content());
				query.setParameter("blogpost_id", blogpost.getBlogpost_id());
				
				query.executeUpdate();
				session.save(blogpost);
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
		

	public boolean deleteBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		if (blogpost !=null) {
			
			try {
			
			Session session = DAOUtilities.getSessionFactory().openSession();	
				
			session.beginTransaction();
			
			session.delete(blogpost);
			
			session.getTransaction().commit();
			
			} catch (Exception e) {
				
			e.printStackTrace();
			
			session.getTransaction().rollback();
				
			}
		}
	}
}
