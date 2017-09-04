package com.positivity.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.positivity.model.*;

@Service("commentdaoimpl")
public class CommentDAOImpl implements CommentDAO{
	
	private SessionFactory sessionFactory;
	//private Session session;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		//System.out.println("Session Created");
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
		sessionFactory.getCurrentSession().save(myUserCommentBean);
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
		
		sessionFactory.getCurrentSession().saveOrUpdate(myUserCommentBean);
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
		
		sessionFactory.getCurrentSession().delete(myUserCommentBean);
		
	}
	
	//stub
	@SuppressWarnings("Supressed Unchecked Exception in CommentDAO")
	@Transactional(isolation=Isolation.READ_COMMITTED,
	propagation=Propagation.REQUIRED,
	rollbackFor=Exception.class)
	public UserComment getUserComment(UserComment myUserComment){
		
		Query myQuery = sessionFactory.getCurrentSession().
				createQuery("From UserComment where UserId := first"+
		" AND commentID := second");
		
		myQuery.setInteger("first", myUserComment.getUsersID());
		myQuery.setInteger("second", myUserComment.getCommentID());
		
		List<UserComment> myResult = myQuery.list();
		UserComment myCommentBean = myResult.get(0);
		return myCommentBean;

	}
	//done-
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	@SuppressWarnings("Supressed Unchecked Exception in CommentDAO")
	public List<UserComment> getAllUserComments(){
		//List<UserComment> myListnew = new ArrayList<UserComment>();
		//String myAllQuery = "Select * from user_comments";
		//String myAllQuery = "from user_comments";
		//Query myQuery = session.createQuery(myAllQuery);
		//return myListnew;
		
		return sessionFactory.getCurrentSession().createQuery("FROM UserComment").list();
	}
	
	//comments Table Section
	
	//add comment
	//done
	
	@Transactional(isolation = Isolation.READ_COMMITTED,
			propagation = Propagation.REQUIRED,
			rollbackFor = Exception.class)
	public void addComment(Comment myComment){
		//open
		//begin transaction
		//save transaction
		//commit transaction
		//close
		//session = sessionFactory.openSession();
		//Transaction myTransaction = session.beginTransaction();
		
		sessionFactory.getCurrentSession().save(myComment);
		
	}
	//delete comment
	//done
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void deleteComment(Comment myComment){
		//transaction
		//Transaction myTransaction = session.beginTransaction();
		//delete
		//session.delete(myComment);
		//commit
		//myTransaction.commit();
		
		sessionFactory.getCurrentSession().delete(myComment);
	}
	//done
	@SuppressWarnings("Supressed Unchecked Exception in CommentDAO")
	@Transactional(isolation=Isolation.READ_COMMITTED,
	propagation=Propagation.REQUIRED,
	rollbackFor=Exception.class)
	public Comment getComment(int commentID){
		
		//shortcuts the sql argument with a session load statement
		
		//Comment myComment = (Comment)session.load(Comment.class, commentID);
		
		//return myComment;
		
		Query myQuery = sessionFactory.getCurrentSession().
				createQuery("From Comment where CommentId := first");
		
		myQuery.setInteger("first", commentID);
		
		List<Comment> myResult = myQuery.list();
		Comment myCommentBean = myResult.get(0);
		return myCommentBean;
		
	}
	
	//done
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void updateComment(Comment myComment){
		//begin transaction
		//Transaction myTransaction = session.beginTransaction();
		//update the bean
		//session.saveOrUpdate(myComment);
		
		sessionFactory.getCurrentSession().saveOrUpdate(myComment);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public UserComment getUserComment(int usersID, int commentsID) {
		// TODO Auto-generated method stub
		return null;
	}
}