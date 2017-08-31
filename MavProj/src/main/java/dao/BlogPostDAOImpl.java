package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.BlogPost;


public class BlogPostDAOImpl implements BlogPostDAO{
	
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void addBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().save(blogpost);
		
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public BlogPost getBlogPostByID(int blogpost_id) {
		// TODO Auto-generated method stub
				
		return (BlogPost)  sessionFactory.getCurrentSession()
				.createQuery("FROM BlogPost WHERE blogpost_id := blogpost_id").uniqueResult();
		
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void editBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		session.beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(blogpost);
		session.getTransaction().commit();
			
	}
		
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deleteBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		session.beginTransaction();
		sessionFactory.getCurrentSession().delete(blogpost);
		session.getTransaction().commit();
	}
}
