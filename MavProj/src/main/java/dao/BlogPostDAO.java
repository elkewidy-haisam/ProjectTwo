package dao;

import model.BlogPost;

public interface BlogPostDAO {
	
	//create blog post
	public boolean addBlogPost(BlogPost blogpost);
	
	//get blog post by ID
	public BlogPost getBlogPostByID(int blogpost_id);
	
	//update blog post by ID
	public boolean editBlogPost(BlogPost blogpost);
	
	
	//delete entire blog post
	public boolean deleteBlogPost(BlogPost blogpost);
	
	
	

}
