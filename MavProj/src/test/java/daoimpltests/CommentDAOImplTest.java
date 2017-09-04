package daoimpltests;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.positivity.dao.CommentDAO;
import com.positivity.model.Comment;
import com.positivity.model.UserComment;
import com.positivity.servlets.BlogConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BlogConfig.class)
public class CommentDAOImplTest {
	
	@Autowired
	@Qualifier("commentdaoimpl")
	CommentDAO commentdaoimpl;
	
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
	public void BlogPostDAOImplShouldNotBeNull(){
		
		assertNotNull(commentdaoimpl);
		
	}
	
	@Test
	public void CommentShouldNotBeNull(){
		
		assertNotNull(comment);
		
	}
	
	
	// userComment tests
	
	@Test
	public void addUserCommentTest() {
		
		System.out.println(userComment);
		commentdaoimpl.addUserComment(userComment);
		
	}
	
	@Test
	@Ignore
	public void getUserCommentTest() {
		
		System.out.println(userComment);
		commentdaoimpl.getAllUserComments();
		
	}
	
	@Test
	@Ignore
	public void updateUserCommentTest() {
		
		System.out.println(comment);
		commentdaoimpl.updateComment(comment);
		
	}
	
	
	@Test
	@Ignore
	public void deleteUserCommentTest() {
		
		System.out.println(comment);
		commentdaoimpl.deleteComment(comment);
		
	}
	
	// comment tests
	
	@Test
	public void addCommentTest() {
		
		System.out.println(comment);
		commentdaoimpl.addComment(comment);
		
	}
	
	@Test
	@Ignore
	public void getCommentTest() {
		
		commentdaoimpl.getComment(0);
		
	}
	
	@Test
	@Ignore
	public void updateCommentTest() {
		
		commentdaoimpl.updateComment(comment);
		
	}
	

	
	@Test
	@Ignore
	public void deleteCommentTest() {
		
		commentdaoimpl.deleteComment(comment);
		
	}
	
	
}
