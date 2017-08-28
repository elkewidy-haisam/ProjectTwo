package model;

<<<<<<< HEAD
import javax.persistence.*;

@Entity
@Table(name="UsersComments")
public class UserComment {
=======
import java.io.Serializable;

import javax.persistence.*;
@IdClass(UserCommentCompositeKey.class)
@Entity
@Table(name="UsersComments")
public class UserComment implements Serializable{
>>>>>>> master
	@Id
	@Column(name = "USERS_ID")
	private int usersID;
	@Id
	@Column(name = "COMMENT_ID")
	private int commentID;
	
	@Column(name = "COMMENT_CONTENT")
	private String commentContent;
	
<<<<<<< HEAD
=======
	public UserComment() {
		super();
	}
	
>>>>>>> master
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
	
	
<<<<<<< HEAD
}
=======
}
>>>>>>> master
