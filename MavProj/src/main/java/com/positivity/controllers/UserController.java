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

@Controller("/user")
public class UserController {
	

	@Autowired
	private UserDAO dao;
	
	public void setDAO(UserDAO daoimpl) {
		this.dao = daoimpl;
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void create(@Valid @RequestBody User user){
		
		dao.create(user);
		
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void update(@RequestBody User user){
		
		dao.update(user);
		
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void delete(@RequestBody User user){
		
		dao.delete(user);
		
	}
	
	@RequestMapping(value="/FullName", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getFullName(@RequestBody User user){
		
		return(user.getFirstname() + user.getLastname()).toString();
		
	}
	
	@RequestMapping(value="/id", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void getUserByID(@RequestBody User user){
		
		
	}

}
