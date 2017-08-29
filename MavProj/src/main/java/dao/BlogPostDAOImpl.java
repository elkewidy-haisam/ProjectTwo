package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.BlogPost;

@Repository
public class BlogPostDAOImpl implements BlogPostDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}

	public void addBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		session.beginTransaction();
		sessionFactory.getCurrentSession().save(blogpost);
		session.getTransaction().commit();
	}

	public BlogPost getBlogPostByID(int blogpost_id) {
		// TODO Auto-generated method stub
				
		return (BlogPost)  sessionFactory.getCurrentSession()
				.createQuery("FROM BlogPost WHERE blogpost_id := blogpost_id").uniqueResult();
		
	}

	public void editBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		session.beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(blogpost);
		session.getTransaction().commit();
			
	}
		

	public void deleteBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		session.beginTransaction();
		sessionFactory.getCurrentSession().delete(blogpost);
		session.getTransaction().commit();
	}
}
