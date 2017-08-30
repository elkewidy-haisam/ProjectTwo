package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Comment;
import model.UserComment;

public class CommentDAOImpl implements CommentDAO{
	
	private SessionFactory mySessionFactory;
	//private Session session;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	/*
	public CommentDAOImpl(){
		sessionFactory = new 
			Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		session = sessionFactory.openSession();
	}*/
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
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
		//session = sessionFactory.openSession();
		//begin T
		//Transaction myTransaction = session.beginTransaction();
		//save our Bean
		//session.save(myUserCommentBean);
		//commit T
		//session.close();
		mySessionFactory.getCurrentSession().save(myUserCommentBean);
		//String first = "Insert into comments values (?,?)";
		
	}

	//update
	//done-
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void updateUserComment(UserComment myUserCommentBean){
	//public void updateComment(int commentId, int usersId, byte[] myArr){
		//being transaction
		//Transaction myTransaction = session.beginTransaction();
		//update the database with the change
		//session.saveOrUpdate(myUserCommentBean);
		//commit the transaction
		//myTransaction.commit();
		//String second = "Update user_comments set comments_content = ? where comments_id = ? and users_id = ?";
		
		mySessionFactory.getCurrentSession().saveOrUpdate(myUserCommentBean);
	}
	
	//delete
	//done-
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void deleteUserComment(UserComment myUserCommentBean){
		//public void deleteComment(int commentId, int usersId){
		//begin transaction
		//Transaction myTransaction = session.beginTransaction();
		//delete
		//session.delete(myUserCommentBean);
		//String third = "Delete from user_comments where comments_id=? and users_id=?";
		
		mySessionFactory.getCurrentSession().delete(myUserCommentBean);
		
	}
	
	//stub
	//-
	public UserComment getUserComment(UserComment myUserComment){
		//open session
		
		//UserComment myCommentBean = (UserComment) session.get(UserComment.class);
		Query myQuery = mySessionFactory.getCurrentSession().createQuery("From UserService where UserId = " +
		myUserComment.getUsersID() + " AND commentID = " + myUserComment.getCommentID());
		UserComment myCommentBean  = myQuery.setString("idk", "COMMENTS_CONTENT");
		return new UserComment();
	}
	//done-
	@SuppressWarnings("Supressed Unchecked Exception in CommentDAO")
	public List<UserComment> getAllUserComments(){
		//List<UserComment> myListnew = new ArrayList<UserComment>();
		//String myAllQuery = "Select * from user_comments";
		//String myAllQuery = "from user_comments";
		//Query myQuery = session.createQuery(myAllQuery);
		//return myListnew;
		
		return mySessionFactory.getCurrentSession().createQuery("From UserComments").list();
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
		//session = sessionFactory.openSession();
		//Transaction myTransaction = session.beginTransaction();
		
		mySessionFactory.getCurrentSession().save(myComment);
		
	}
	//delete comment
	//done
	public void deleteComment(Comment myComment){
		//transaction
		//Transaction myTransaction = session.beginTransaction();
		//delete
		//session.delete(myComment);
		//commit
		//myTransaction.commit();
		
		mySessionFactory.getCurrentSession().delete(myComment);
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
		//Transaction myTransaction = session.beginTransaction();
		//update the bean
		//session.saveOrUpdate(myComment);
		
		mySessionFactory.getCurrentSession().saveOrUpdate(myComment);
	}
}