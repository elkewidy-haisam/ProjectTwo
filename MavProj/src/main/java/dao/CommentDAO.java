package dao;

import java.util.List;

import model.Comment;
import model.UserComment;

public interface CommentDAO {

	//add
	public void addUserComment(UserComment myUserComment);
	//update
	public void updateUserComment(UserComment myUserComment);
	//delete
	public void deleteUserComment(UserComment myUserComment);
	
	public UserComment getUserComment(int usersID, int commentsID);
	
	public List<UserComment> getAllUserComments();
	
	
	//comments table
	//add
	public void addComment(Comment myComment);
	//delete
	public void deleteComment();
	
	public void getComment();
	
}
