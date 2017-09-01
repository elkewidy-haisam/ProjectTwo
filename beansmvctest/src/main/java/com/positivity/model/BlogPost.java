package com.positivity.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="BLOGPOST")
public class BlogPost {
	
	@Id
	@Column(name="BLOGPOSTID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="blogpost_id")
	@SequenceGenerator(name="blogpost_id", sequenceName="BLOGPOST_ID_SEQ")
	private int blogpost_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIMESTAMP")
	private Date blogpost_timestamp;
	
	@Column(name="BLOGPOST_CONTENT")
	private String blogpost_content;
	
	@Column(name="USERS_USER_ID")
	private int blogpost_user_id;
	
	@ManyToOne
	@JoinColumn(name="blogpost_user_id")
	private User user;
	
	/*@OneToMany(mappedBy="blogpost")
	private List<Comment> comments; */
	
	

	public BlogPost() {
		super();
	}

	public BlogPost(int blogpost_id, Date blogpost_timestamp, User user,
			String blogpost_content) {
		super();
		this.blogpost_id = blogpost_id;
		this.blogpost_timestamp = blogpost_timestamp;
		this.blogpost_content = blogpost_content;
		this.user = user;
		
	}
	
	
	public int getBlogpost_id() {
		return blogpost_id;
	}

	public void setBlogpost_id(int blogpost_id) {
		this.blogpost_id = blogpost_id;
	}

	public Date getBlogpost_timestamp() {
		return blogpost_timestamp;
	}

	public void setBlogpost_timestamp(Date blogpost_timestamp) {
		this.blogpost_timestamp = blogpost_timestamp;
	}

	public String getBlogpost_content() {
		return blogpost_content;
	}

	public void setBlogpost_content(String blogpost_content) {
		this.blogpost_content = blogpost_content;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}