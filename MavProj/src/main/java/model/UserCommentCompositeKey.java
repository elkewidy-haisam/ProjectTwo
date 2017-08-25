package model;

import java.io.Serializable;

public class UserCommentCompositeKey implements Serializable{
	private int usersID;
	private int commentID;
	
	public UserCommentCompositeKey(int usersID, int commentID){
		this.usersID = usersID;
		this.commentID = commentID;
	}
}