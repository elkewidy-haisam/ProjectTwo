package daoimpltests;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.positivity.servlets.BlogConfig;
import com.positivity.dao.*;
import com.positivity.model.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BlogConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddingUserCommentTest {
	
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
	public void AddUserTest(){
		
		System.out.println("*********************");
		System.out.println("USER");
		System.out.println(user);
		System.out.println(user.getEmail());
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		System.out.println(user.getPassword());
		System.out.println(user.getUser_id());
		System.out.println(user.getUsername());
		System.out.println(user.getUserrole_id());
		
		userdaoimpl.create(user);
		
	}
	
	@Test
	public void BlogPostTestAdd(){
		
		System.out.println("*********************");
		System.out.println("BLOGPOST");
		System.out.println(blogpost);
		System.out.println(blogpost.getBlogpost_content());
		System.out.println(blogpost.getBlogpost_id());
		System.out.println(blogpost.getBlogpost_user_id());
		System.out.println(blogpost.getBlogpost_timestamp());
		
		blogpostdaoimpl.addBlogPost(blogpost);
		
	}
	
	@Test
	public void CommentTestAdd() {
		
		System.out.println("*********************");
		System.out.println("COMMENT");
		System.out.println(comment);
		System.out.println(comment.getBlogpost_id());
		System.out.println(comment.getComment_id());
		System.out.println(comment.getUser_id());
		
		commentdaoimpl.addComment(comment);
		
	}
	
	
	@Test
	public void UserCommentTestAdd() {
		
		System.out.println("*********************");
		System.out.println("USER_COMMENT");
		System.out.println(userComment);
		System.out.println(userComment.getCommentID());
		System.out.println(userComment.getCommentContent());
		System.out.println(userComment.getUsersID());
		
		commentdaoimpl.addUserComment(userComment);
		
	}
	

}
