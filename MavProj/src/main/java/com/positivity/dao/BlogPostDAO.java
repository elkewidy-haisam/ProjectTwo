package com.positivity.dao;

import org.springframework.stereotype.Repository;

import com.positivity.model.*;


public interface BlogPostDAO {
	
	//create blog post
	public void addBlogPost(BlogPost blogpost);
	
	//get blog post by ID
	public BlogPost getBlogPostByID(int blogpost_id);
	
	//update blog post by ID
	public void editBlogPost(BlogPost blogpost);
	
	
	//delete entire blog post
	public void deleteBlogPost(BlogPost blogpost);
	
	
	

}