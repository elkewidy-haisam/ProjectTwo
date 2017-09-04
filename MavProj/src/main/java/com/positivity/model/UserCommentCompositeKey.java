package com.positivity.model;

import java.io.Serializable;

public class UserCommentCompositeKey implements Serializable{
	
	private int usersID;
	private int commentID;
	
	public UserCommentCompositeKey(){
		super();
		
	}
	
	public UserCommentCompositeKey(int usersID, int commentID){
		super();
		this.usersID = usersID;
		this.commentID = commentID;
	}
}
