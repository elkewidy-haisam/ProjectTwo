package junit;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.XmlWebApplicationContext;

import dao.BlogPostDAOImpl;
import model.BlogPost;


public class BlogPostDAOTest {
	
	@Autowired
	private static ApplicationContext context;
	
	@BeforeClass
	public static void setup(){
		context = new XmlWebApplicationContext();
	}
	
	@Test
	public void addBlogPostTest(){
		
		BlogPost blogpost = new BlogPost();
		blogpost.setBlogpost_content("Blogpost Content.");
		blogpost.setBlogpost_id(99999);
		blogpost.setBlogpost_user_id(1234);
		
		BlogPostDAOImpl blogpostdaoimpl = context.getBean(BlogPostDAOImpl.class);
		
		if(blogpostdaoimpl != null) {
			
			System.out.println("Context acquired.");
			
		}
		
		blogpostdaoimpl.addBlogPost(blogpost);
		
		System.out.println("Blog post added successfully.");
		
	}
	
	@Test
	public void getBlogPostByIDTest(){
	
		int blogpost_id = 5;
		
		BlogPostDAOImpl blogpostdaoimpl = context.getBean(BlogPostDAOImpl.class);
		BlogPost blogpost = blogpostdaoimpl.getBlogPostByID(blogpost_id);
		
		org.junit.Assert.assertNotNull("Placeholder blogpost acquired.", blogpost);
		
	}
	
	@Test 
	public void editBlogPostTest(){
		
		BlogPost blogpost = new BlogPost();
		
		BlogPostDAOImpl blogpostdaoimpl = context.getBean(BlogPostDAOImpl.class);
		
		blogpost.setBlogpost_content("Updated content.");
		blogpostdaoimpl.editBlogPost(blogpost);
		
	}
	
	@Test
	public void deleteBlogPostTest(){
		
		BlogPost blogpost = new BlogPost();
		
		BlogPostDAOImpl blogpostdaoimpl = context.getBean(BlogPostDAOImpl.class);
		blogpostdaoimpl.deleteBlogPost(blogpost);
		System.out.println("Blog post deleted.");
		
	}

}
