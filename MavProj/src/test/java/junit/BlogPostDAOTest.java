package junit;

import static org.junit.Assert.*;

import org.junit.*;

import dao.BlogPostDAOImpl;
import model.BlogPost;

public class BlogPostDAOTest {
	
	BlogPost blogpost = new BlogPost();
	BlogPostDAOImpl blogpostdaoimpl = new BlogPostDAOImpl();
	
	@Test
	public void addBlogPostTest(){
		
		
		blogpostdaoimpl.addBlogPost(blogpost);
		
		System.out.println("Blog post added successfully.");
		
	}
	
	@Test
	public void getBlogPostByIDTest(){
	
		int blogpost_id = blogpost.getBlogpost_id();
		BlogPost bp2 = blogpostdaoimpl.getBlogPostByID(blogpost_id);
		
		org.junit.Assert.assertNotNull("Placeholder blogpost acquired.", bp2);
		
	}
	
	@Test 
	public void editBlogPostTest(){
		
		blogpost.setBlogpost_content("Updated content.");
		blogpostdaoimpl.editBlogPost(blogpost);
		
	}
	
	@Test
	public void deleteBlogPostTest(){
		
		blogpostdaoimpl.deleteBlogPost(blogpost);
		System.out.println("Blog post deleted.");
		
	}

}
