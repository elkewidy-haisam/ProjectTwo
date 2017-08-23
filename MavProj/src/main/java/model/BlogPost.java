package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BLOGPOST")
public class BlogPost {
	
	@Id
	@Column(name="BLOGPOSTID")
	private int blogpost_id;
	
	@Column(name="TIMESTAMP")
	private Timestamp blogpost_timestamp;
	
	@Column(name="BLOGPOST_CONTENT")
	private byte[] blogpost_content;
	
	@Column(name="USERS_USER_ID")
	private int blogpost_user_id;
	

	public BlogPost() {
		super();
	}

	public BlogPost(int blogpost_id, Timestamp blogpost_timestamp, int blogpost_user_id,
			byte[] blogpost_content) {
		super();
		this.blogpost_id = blogpost_id;
		this.blogpost_timestamp = blogpost_timestamp;
		this.blogpost_content = blogpost_content;
		this.blogpost_user_id = blogpost_user_id;
	}
	
	
	public int getBlogpost_id() {
		return blogpost_id;
	}

	public void setBlogpost_id(int blogpost_id) {
		this.blogpost_id = blogpost_id;
	}

	public Timestamp getBlogpost_timestamp() {
		return blogpost_timestamp;
	}

	public void setBlogpost_timestamp(Timestamp blogpost_timestamp) {
		this.blogpost_timestamp = blogpost_timestamp;
	}

	public byte[] getBlogpost_content() {
		return blogpost_content;
	}

	public void setBlogpost_content(byte[] blogpost_content) {
		this.blogpost_content = blogpost_content;
	}


	
	
	
	
	

}
