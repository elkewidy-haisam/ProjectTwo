package com.positivity.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.positivity.dao.*;
import com.positivity.model.*;

@Controller("/blogpost")
public class BlogPostController {
	
	@Autowired
	private BlogPostDAO dao;
	
	public void setDao(BlogPostDAO daoimpl) {
		
		this.dao = daoimpl;
		
	}
	
	@RequestMapping(value="/createBlogPost", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void create(@Valid @RequestBody BlogPost blogpost) {
		
		dao.addBlogPost(blogpost);
		
	}
	
	@RequestMapping(value="/updateBlogPost", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void update(@RequestBody BlogPost blogpost) {
		
		dao.editBlogPost(blogpost);
		
	}
	
	@RequestMapping(value="/deleteBlogPost", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void delete(@RequestBody BlogPost blogpost) {
		
		dao.deleteBlogPost(blogpost);
		
	}
	
	@RequestMapping(value="/getById", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void getByBlogPostID(@RequestBody int blogpost_id) {
		
		dao.getBlogPostByID(blogpost_id);
	
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void getAllBlogPosts() {
		
		dao.viewAllBlogPosts();
		
	}

}
