package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.BlogPostDAO;
import dao.BlogPostDAOImpl;
import model.BlogPost;

@Controller
public class BlogPostController {
	
	@Autowired
	private BlogPostDAOImpl daoimpl;
	
	public void setDaoImpl(BlogPostDAOImpl daoimpl) {
		
		this.daoimpl = daoimpl;
		
	}
	
	@RequestMapping(value="/blogpost/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void create(@Valid @RequestBody BlogPost blogpost) {
		
		daoimpl.addBlogPost(blogpost);
		
	}
	
	@RequestMapping(value="/blogpost/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void update(@RequestBody BlogPost blogpost) {
		
		daoimpl.editBlogPost(blogpost);
		
	}
	
	@RequestMapping(value="/blogpost/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void delete(@RequestBody BlogPost blogpost) {
		
		daoimpl.deleteBlogPost(blogpost);
		
	}
	
	@RequestMapping(value="/blogpost/getbyid", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void getByBlogPostID(@RequestBody int blogpost_id) {
		
		daoimpl.getBlogPostByID(blogpost_id);
	
	}

}
