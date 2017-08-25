package dao;

//import java.util.logging.Logger;

import org.junit.Test;

import model.Comment;
import model.UserComment;

public class CommentDAOTest {

	//Logge myLogger = Logger.getLogger(name);
	
	/*log.trace("trace log");
	
	log.debug("debug log");
	
	log.info("information log");
	
	log.warn("warning log");
	
	log.error("error log");
	
	log.fatal("worst case log");
	*/
	
	@Test
	public void addUserComment(){
		//modeling the success of getting output
		CommentDAOImpl myCommentDAO = new CommentDAOImpl();
		UserComment myUserCommentBean = new UserComment();
		
		myUserCommentBean.setUsersID(1);
		myUserCommentBean.setCommentID(1);
		myCommentDAO.addUserComment(myUserCommentBean);
		
		//myLogger.debug("Successful insertion into Comment Table");
		
		System.out.println("Successful insertion into Comment Table");
		
	}
	
	@Test
	public void updateUserComment(){
		//to update we would add an entry into the database
		CommentDAOImpl myCommentDAO = new CommentDAOImpl();
		//to output success we would get no error out of the database
		//short cut to call another method in testing
		UserComment myUserCommentBean = myCommentDAO.getUserComment(1, 1);
		myUserCommentBean.setCommentContent("New Content String");
		
	}
	
	//to test the deletion, create a new bean, add it, then delete it
	public void deleteComment(){
		CommentDAOImpl myCommentDAO = new CommentDAOImpl();
		UserComment myUserCommentBean = new UserComment(1,1,"Example");
		myCommentDAO.addUserComment(myUserCommentBean);
		myCommentDAO.deleteUserComment(myUserCommentBean);
		
	}
	
	public void getComment(){
		
	}
	
	public void getAllComments(){
		
	}
	
}
