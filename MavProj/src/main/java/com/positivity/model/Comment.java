package com.positivity.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="COMMENTS")
public class Comment{
	
	@Id
	@Column(name="COMMENT_ID")
	private int comment_id;
	
	@Column(name="USER_USER_ID")
	private int user_id;
	
	@Column(name="BLOGPOST_BLOGPOSTID")
	private int blogpost_id;
	
	/*
	@Column(name="COMMENTS_COTENT")
	private String comment_content;
	*/
	
	public Comment() {
		super();
	}

	public Comment(int comment_id, int user_id, String comment_content) {
		super();
		this.comment_id = comment_id;
		this.user_id = user_id;
		//this.comment_content = comment_content;
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
	
	public int getBlogpost_id() {
		return blogpost_id;
	}

	public void setBlogpost_id(int blogpost_id) {
		this.blogpost_id = blogpost_id;
	}
/*
	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	*/
	
}
