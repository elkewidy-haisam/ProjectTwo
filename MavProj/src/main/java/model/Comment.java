package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Comment {
	
	@Id
	@Column
	private int comment_id;
	
	@Column
	private int user_id;
	
	@Column
	private byte[] comment_content;
	
	
	public Comment() {
		super();
	}

	public Comment(int comment_id, int user_id, byte[] comment_content) {
		super();
		this.comment_id = comment_id;
		this.user_id = user_id;
		this.comment_content = comment_content;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public byte[] getComment_content() {
		return comment_content;
	}

	public void setComment_content(byte[] comment_content) {
		this.comment_content = comment_content;
	}
	
	
}
