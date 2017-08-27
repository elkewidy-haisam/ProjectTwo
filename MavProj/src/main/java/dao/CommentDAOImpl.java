package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Comment;
import model.User;
import model.UserComment;

public class CommentDAOImpl implements CommentDAO{
	SessionFactory mySessionFactory;
	Session mySession;
	
	public CommentDAOImpl(){
		mySessionFactory = new 
			Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		mySession = mySessionFactory.openSession();
	}
	//add
	//done-
	public void addUserComment(UserComment myUserCommentBean){
		//public void addComment(int commentId, int usersId, byte[] myArr){
		/*
		 * open
		 * begin transaction
		 * save transaction
		 * commit transaction
		 * close session
		 */
		//open
		mySession = mySessionFactory.openSession();
		//begin T
		Transaction myTransaction = mySession.beginTransaction();
		//save our Bean
		mySession.save(myUserCommentBean);
		//commit T
		mySession.close();
		
		//String first = "Insert into comments values (?,?)";
		
	}

	//update
	//done-
	public void updateUserComment(UserComment myUserCommentBean){
	//public void updateComment(int commentId, int usersId, byte[] myArr){
		//being transaction
		Transaction myTransaction = mySession.beginTransaction();
		//update the database with the change
		mySession.saveOrUpdate(myUserCommentBean);
		//commit the transaction
		myTransaction.commit();
		//String second = "Update user_comments set comments_content = ? where comments_id = ? and users_id = ?";
		
	}
	
	//delete
	//done-
	public void deleteUserComment(UserComment myUserCommentBean){
		//public void deleteComment(int commentId, int usersId){
		//begin transaction
		Transaction myTransaction = mySession.beginTransaction();
		//delete
		mySession.delete(myUserCommentBean);
		//String third = "Delete from user_comments where comments_id=? and users_id=?";
		
	}
	
	//stub
	//-
	public UserComment getUserComment(int usersID, int commentsID){
		//open session
		
		//Comment myCommentBean = (Comment) mySession.get(Comment.class, );
		return new UserComment();
	}
	//done-
	public List<UserComment> getAllUserComments(){
		List<UserComment> myListnew = new ArrayList<UserComment>();
		//String myAllQuery = "Select * from user_comments";
		String myAllQuery = "from user_comments";
		Query myQuery = mySession.createQuery(myAllQuery);
		return myListnew;
	}
	
	//comments Table Section
	
	//add comment
	//done
	public void addComment(Comment myComment){
		//open
		//begin transaction
		//save transaction
		//commit transaction
		//close
		mySession = mySessionFactory.openSession();
		Transaction myTransaction = mySession.beginTransaction();
		
	}
	//delete comment
	//done
	public void deleteComment(Comment myComment){
		//transaction
		Transaction myTransaction = mySession.beginTransaction();
		//delete
		mySession.delete(myComment);
		//commit
		myTransaction.commit();
	}
	//done
	public Comment getComment(int commentID){
		
		//shortcuts the sql argument with a session load statement
		
		Comment myComment = (Comment)mySession.load(Comment.class, commentID);
		
		return myComment;
	}
	//done
	public void updateComment(Comment myComment){
		//begin transaction
		Transaction myTransaction = mySession.beginTransaction();
		//update the bean
		mySession.saveOrUpdate(myComment);
	}
}