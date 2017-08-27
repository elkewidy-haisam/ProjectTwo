package dao;

//import java.util.logging.Logger;

import org.junit.Test;

import model.Comment;
import model.UserComment;

public class CommentDAOTest {

	//Logger myLogger = Logger.getLogger(name);
	
	/*log.trace("trace log");
	
	log.debug("debug log");
	
	log.info("information log");
	
	log.warn("warning log");
	
	log.error("error log");
	
	log.fatal("worst case log");
	*/
	
	@Test
	//done
	public void testAddUserComment(){
		//modeling the success of getting output
		//create a new dao
		CommentDAOImpl myCommentDAO = new CommentDAOImpl();
		//create a new bean
		UserComment myUserCommentBean = new UserComment();
		myUserCommentBean.setUsersID(1);
		myUserCommentBean.setCommentID(1);
		myCommentDAO.addUserComment(myUserCommentBean);
		
		//myLogger.debug("Successful insertion into Comment Table");
		
		System.out.println("Successful insertion into Comment Table");
		
	}
	//done
	@Test
	public void testUpdateUserComment(){
		//to update we would add an entry into the database
		CommentDAOImpl myCommentDAO = new CommentDAOImpl();
		//to output success we would get no error out of the database
		//short cut to call another method in testing
		UserComment myUserCommentBean = myCommentDAO.getUserComment(1, 1);
		myUserCommentBean.setCommentContent("New Content String");
		
	}
	
	
	
	//to test the deletion, create a new bean, add it, then delete it
	//done
	@Test
	public void testDeleteUserComment(){
		CommentDAOImpl myCommentDAO = new CommentDAOImpl();
		UserComment myUserCommentBean = new UserComment(1,1,"Example");
		myCommentDAO.addUserComment(myUserCommentBean);
		myCommentDAO.deleteUserComment(myUserCommentBean);
		
	}
	
	@Test
	public void testGetUserComment(){
		
	}
	
	@Test
	public void testGetAllUserComments(){
		
	}
	
	@Test
	public void testAddComment(){
		
	}
	
}
