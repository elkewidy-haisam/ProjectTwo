package com.positivity.model;

import java.io.Serializable;
import javax.persistence.*;

@IdClass(UserCommentCompositeKey.class)
@Entity
@Table(name="USERS_COMMENTS")
public class UserComment implements Serializable{
	
	
	@Id
	@Column(name = "USERS_USER_ID")
	private int usersID;
	
	@Id
	@Column(name = "COMMENT_ID")
	private int commentID;
	
	@Column(name = "COMMENT_CONTENT")
	private String commentContent;

	public UserComment() {
		super();
	}
	
	public UserComment(int usersID, int commentID, String commentContent) {
		super();
		this.usersID = usersID;
		this.commentID = commentID;
		this.commentContent = commentContent;
	}

	public int getUsersID() {
		return usersID;
	}

	public void setUsersID(int usersID) {
		this.usersID = usersID;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	
}