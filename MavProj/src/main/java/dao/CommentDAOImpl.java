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
import model.UserComment;

public class CommentDAOImpl implements CommentDAO{
	
	private SessionFactory sessionFactory;
	private Session session;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	
	public CommentDAOImpl(){
		sessionFactory = new 
			Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
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
		session = sessionFactory.openSession();
		//begin T
		Transaction myTransaction = session.beginTransaction();
		//save our Bean
		session.save(myUserCommentBean);
		//commit T
		session.close();
		
		//String first = "Insert into comments values (?,?)";
		
	}

	//update
	//done-
	public void updateUserComment(UserComment myUserCommentBean){
	//public void updateComment(int commentId, int usersId, byte[] myArr){
		//being transaction
		Transaction myTransaction = session.beginTransaction();
		//update the database with the change
		session.saveOrUpdate(myUserCommentBean);
		//commit the transaction
		myTransaction.commit();
		//String second = "Update user_comments set comments_content = ? where comments_id = ? and users_id = ?";
		
	}
	
	//delete
	//done-
	public void deleteUserComment(UserComment myUserCommentBean){
		//public void deleteComment(int commentId, int usersId){
		//begin transaction
		Transaction myTransaction = session.beginTransaction();
		//delete
		session.delete(myUserCommentBean);
		//String third = "Delete from user_comments where comments_id=? and users_id=?";
		
	}
	
	//stub
	//-
	public UserComment getUserComment(int usersID, int commentsID){
		//open session
		
		//Comment myCommentBean = (Comment) session.get(Comment.class, );
		return new UserComment();
	}
	//done-
	public List<UserComment> getAllUserComments(){
		List<UserComment> myListnew = new ArrayList<UserComment>();
		//String myAllQuery = "Select * from user_comments";
		String myAllQuery = "from user_comments";
		Query myQuery = session.createQuery(myAllQuery);
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
		session = sessionFactory.openSession();
		Transaction myTransaction = session.beginTransaction();
		
	}
	//delete comment
	//done
	public void deleteComment(Comment myComment){
		//transaction
		Transaction myTransaction = session.beginTransaction();
		//delete
		session.delete(myComment);
		//commit
		myTransaction.commit();
	}
	//done
	public Comment getComment(int commentID){
		
		//shortcuts the sql argument with a session load statement
		
		Comment myComment = (Comment)session.load(Comment.class, commentID);
		
		return myComment;
	}
	//done
	public void updateComment(Comment myComment){
		//begin transaction
		Transaction myTransaction = session.beginTransaction();
		//update the bean
		session.saveOrUpdate(myComment);
	}
}