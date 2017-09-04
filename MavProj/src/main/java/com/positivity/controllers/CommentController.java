package com.positivity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.positivity.dao.*;
import com.positivity.model.*;

@Controller
public class CommentController {

	@Autowired
	private CommentDAO myCommentDAO;
	//not 100% about these mappings
	
	public void setCommentDao( CommentDAO myCommentDAO){
		
		this.myCommentDAO = myCommentDAO;
		
	}
	
	@RequestMapping(value="/UserComment/create", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void createUserComment(@RequestBody UserComment myUserComment){
		
		myCommentDAO.addUserComment(myUserComment);
		
		
	}
	
	@RequestMapping(value="/UserComment/update", method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateUserComment(@RequestBody UserComment myUserComment){
		
		myCommentDAO.updateUserComment(myUserComment);
		
	}
	
	@RequestMapping(value="/UserComment/delete", method=RequestMethod.DELETE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteUserComment(@RequestBody UserComment myUserComment){
		
		myCommentDAO.deleteUserComment(myUserComment);
		
	}
	
	@RequestMapping(value="/UserComment/all",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void findAllUserComment(){
		
		System.out.println("Method has been called.");
		
	}
	
	
	//the rest of methods only for the base comment table
	@RequestMapping(value="Comment/create", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public void createComment(@RequestBody Comment myComment){
		
		myCommentDAO.addComment(myComment);
		
	}
	
	@RequestMapping(value="Comment/update", method = RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateComment(@RequestBody Comment myComment){
		
		myCommentDAO.updateComment(myComment);
		
	}
	
	@RequestMapping(value="Comment/delete", method=RequestMethod.DELETE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteComment(@RequestBody Comment myComment){
		
		myCommentDAO.deleteComment(myComment);
		
	}
	
	//don't need a find all comment for the base table
}