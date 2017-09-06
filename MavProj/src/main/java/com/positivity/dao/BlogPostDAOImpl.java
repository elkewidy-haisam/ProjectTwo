package com.positivity.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.positivity.model.*;

@Repository("blogpostdaoimpl")
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
				
		return (BlogPost) sessionFactory.getCurrentSession()
				.createQuery("FROM BlogPost WHERE blogpost_id =:blogpost_id").setParameter("blogpost_id", blogpost_id).uniqueResult();
		
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void editBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().createQuery("UPDATE BlogPost SET blogpost_content =:blogpost_content WHERE blogpost_user_id =:blogpost_user_id");
			
	}
		

	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deleteBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(blogpost);
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<BlogPost> viewAllBlogPosts() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM BlogPost").list();
		
	}
	
	
}
