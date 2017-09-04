package com.positivity.dao;

import java.util.List;

import com.positivity.model.*;


public interface CommentDAO {

	//add
	public void addUserComment(UserComment myUserComment);
	//update
	public void updateUserComment(UserComment myUserComment);
	//delete
	public void deleteUserComment(UserComment myUserComment);
	
	//getFullName
	//public UserComment getUserComment(int usersID, int commentsID);
	
	public List<UserComment> getAllUserComments();
	
	//comments table
	//add
	public void addComment(Comment myComment);
	//delete
	public void deleteComment(Comment myComment);
	//get-
	public Comment getComment(int commentID);
	//update-
	public void updateComment(Comment myComment);
	
}
