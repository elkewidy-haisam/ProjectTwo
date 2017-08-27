package dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;

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
	
	//done
	//actual class tested is not completed
	@Test
	@Ignore
	public void testGetUserComment(){
		//create a new dao
		CommentDAOImpl myCommentDAO = new CommentDAOImpl();
		//create a new bean
		UserComment expected = new UserComment(1,1,"Example");
		//retrieve the result from the database and compare to your
		//expected data
		UserComment actual = myCommentDAO.getUserComment(1, 1);
		//run the assertion statements for the comparison
		assertEquals(expected.getUsersID(), actual.getUsersID());
		assertEquals(expected.getCommentID(), actual.getCommentID());
	}
	
	//done
	@Test
	public void testGetAllUserComments(){
		//create a new dao
		CommentDAOImpl myCommDao = new CommentDAOImpl();
		//very big shortcut
		//List<UserComment> myUserCommentList = new ArrayList<UserComment>();
		List<UserComment> myUserCommentList = myCommDao.getAllUserComments();
	}
	
	//done
	@Test
	public void testAddComment(){
		//new dao
		CommentDAOImpl myCommentDAOImpl = new CommentDAOImpl();
		//create a new bean to insert
		Comment myComment = new Comment();
		myComment.setComment_id(4);
		myComment.setUser_id(4);
		//call the add function
		myCommentDAOImpl.addComment(myComment);
		
	}
	
	//done
	@Test
	public void testDeleteComment(){
		//create dao
		CommentDAOImpl myCommentDAOImpl = new CommentDAOImpl();
		//create bean
		Comment myComment = new Comment();
		//add the bean
		myCommentDAOImpl.addComment(myComment);
		//delete the bean
		myCommentDAOImpl.deleteComment(myComment);
	}
	
	//done
	@Test
	public void testGetComment(){
		//create dao
		CommentDAOImpl myCommentDAOImpl = new CommentDAOImpl();
		//create an expected bean
		Comment expected = new Comment();
		expected.setComment_id(1);
		expected.setUser_id(1);
		//find the actual
		Comment actual = myCommentDAOImpl.getComment(1);
		//run the assertion tests
		assertEquals(expected.getComment_id(), actual.getComment_id());
		assertEquals(expected.getUser_id(), actual.getUser_id());
		
	}
	
	//done
	@Test
	public void testUpdateComment(){
		//create a dao
		CommentDAOImpl myCommentDAOImpl = new CommentDAOImpl();
		//get a bean from the database
		Comment myComment = myCommentDAOImpl.getComment(1);
		//modify the bean
		myComment.setComment_id(10);
		//add the bean back to the database
		myCommentDAOImpl.updateComment(myComment);
	}
	
}
