package daoimpltests;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.positivity.dao.BlogPostDAO;
import com.positivity.dao.CommentDAO;
import com.positivity.dao.UserDAO;
import com.positivity.model.BlogPost;
import com.positivity.model.Comment;
import com.positivity.model.User;
import com.positivity.model.UserComment;
import com.positivity.servlets.BlogConfig;

//this is still a work in progress

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BlogConfig.class)
public class TestsToRetrieveEverything {
	
	@Autowired
	@Qualifier("userdaoimpl")
	UserDAO userdaoimpl;
	
	@Autowired
	@Qualifier("blogpostdaoimpl")
	BlogPostDAO blogpostdaoimpl;
	
	@Autowired
	@Qualifier("commentdaoimpl")
	CommentDAO commentdaoimpl;
	
	@Autowired
	private User user;
	
	@Autowired
	private BlogPost blogpost;
	
	@Autowired
	private Comment comment;
	
	@Autowired
	private UserComment userComment;
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void SessionFactoryShouldNotBeNull(){
		
		assertNotNull(sessionFactory);
		
	}
	
	@Test
	public void UserDAOImplShouldNotBeNull(){
		
		assertNotNull(userdaoimpl);
		
	}
	
	@Test
	public void BlogPostDAOImplShouldNotBeNull(){
		
		assertNotNull(blogpostdaoimpl);
		
	}
	
	@Test
	public void CommentDAOImplShouldNotBeNull(){
		
		assertNotNull(commentdaoimpl);
		
	}
	
	
	@Test
	public void GetUserByIDTest(){
		
		userdaoimpl.getUserByID();
		
	}
	
	@Test
	public void GetBlogPostByIDTest(){
		
		blogpostdaoimpl.getBlogPostByID(1);
		
	}
	
	@Test
	public void GetUserCommentByIDTest(){
		
		commentdaoimpl.getAllUserComments();
		
	}
	
	
}
