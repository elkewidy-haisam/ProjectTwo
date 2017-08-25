package dao;

import org.hibernate.SessionFactory;

import model.BlogPost;

public class BlogPostDAOImpl implements BlogPostDAO{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}

	public void addBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().save(blogpost);
		
	}

	public BlogPost getBlogPostByID(int blogpost_id) {
		// TODO Auto-generated method stub
				
		return (BlogPost)  sessionFactory.getCurrentSession()
				.createQuery("FROM BlogPost WHERE blogpost_id := blogpost_id").uniqueResult();
		
	}

	public void editBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(blogpost);
			
	}
		

	public void deleteBlogPost(BlogPost blogpost) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(blogpost);
	}
}
