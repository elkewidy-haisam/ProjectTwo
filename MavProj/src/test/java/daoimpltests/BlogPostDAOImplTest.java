package daoimpltests;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.positivity.dao.*;
import com.positivity.model.*;
import com.positivity.servlets.BlogConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BlogConfig.class)
public class BlogPostDAOImplTest {
	
	@Autowired
	@Qualifier("blogpostdaoimpl")
	BlogPostDAO blogpostdaoimpl;
	
	@Autowired
	private User user;
	
	@Autowired
	private BlogPost blogpost;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void SessionFactoryShouldNotBeNull(){
		
		assertNotNull(sessionFactory);
		
	}
	
	@Test
	public void BlogPostDAOImplShouldNotBeNull(){
		
		assertNotNull(blogpostdaoimpl);
		
	}
	
	@Test
	public void BlogPostShouldNotBeNull(){
		
		assertNotNull(blogpost);
		
	}
	
	@Test
	public void CreateBlogPostTest(){
		
		System.out.println(blogpost);
		System.out.println(blogpost.getBlogpost_content());
		System.out.println(blogpost.getBlogpost_id());
		System.out.println(blogpost.getBlogpost_timestamp());
		
		blogpostdaoimpl.addBlogPost(blogpost);
		
	}
	
	@Test
	@Ignore
	public void getBlogPostTest(){
		
		blogpostdaoimpl.getBlogPostByID(blogpost.getBlogpost_id());
		
	}
	
	
	@Test
	@Ignore
	public void UpdateBlogPostTest(){
		
		blogpost.setBlogpost_content("This is an update to the Spring Bean blogpost.");
		blogpostdaoimpl.editBlogPost(blogpost);
		
	}
	
	@Test
	@Ignore
	public void DeleteBlogPostTest(){
		
		System.out.println(blogpost);
		blogpostdaoimpl.deleteBlogPost(blogpost);
		
	}
	

	

}
