package integrationtests;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BlogConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeletingUserCommentTest {

	
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
	public void A_SessionFactoryShouldNotBeNull(){
		
		assertNotNull(sessionFactory);
		
	}
	
	@Test
	public void B_CommentDAOImplShouldNotBeNull(){
		
		assertNotNull(commentdaoimpl);
		
	}
	
	@Test
	public void C_BlogPostDAOImplShouldNotBeNull(){
		
		assertNotNull(blogpostdaoimpl);
		
	}
	
	@Test
	public void D_UserDAOImplShouldNotBeNull(){
		
		assertNotNull(userdaoimpl);
		
	}
	
	@Test
	public void E_DeleteUserCommentTest() {
		
		System.out.println("*********************");
		System.out.println("USER_COMMENT");
		System.out.println(userComment);
		System.out.println(userComment.getCommentID());
		System.out.println(userComment.getCommentContent());
		System.out.println(userComment.getUsersID());
		commentdaoimpl.deleteUserComment(userComment);
		
	}
	
	@Test
	public void F_DeleteCommentTest() {
		
		System.out.println("*********************");
		System.out.println("COMMENT");
		System.out.println(comment);
		System.out.println(comment.getBlogpost_id());
		System.out.println(comment.getComment_id());
		System.out.println(comment.getUser_id());
		commentdaoimpl.deleteComment(comment);
		
	}
	
	@Test
	public void G_DeleteBlogPostTest(){
		
		System.out.println("*********************");
		System.out.println("BLOGPOST");
		System.out.println(blogpost);
		System.out.println(blogpost.getBlogpost_content());
		System.out.println(blogpost.getBlogpost_id());
		System.out.println(blogpost.getBlogpost_user_id());
		System.out.println(blogpost.getBlogpost_timestamp());
		
		blogpostdaoimpl.deleteBlogPost(blogpost);
		
	}
	
	@Test
	public void H_DeleteUserTest(){
		
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
		
		userdaoimpl.delete(user);
		
	}
	

	

	
	

	
	
	
	
	
	
}
