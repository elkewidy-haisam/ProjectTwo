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

@Controller
public class UserController {
	

	@Autowired
	private UserDAO daoimpl;
	
	
	//Test method for controller to make sure it works
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		
		return "home";
		
	}
	
	
	public void setDaoImpl(UserDAOImpl daoimpl) {
		this.daoimpl = daoimpl;
	}
	
	@RequestMapping(value="/user/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void create(@Valid @RequestBody User user){
		
		daoimpl.create(user);
		
	}
	
	@RequestMapping(value="/user/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void update(@RequestBody User user){
		
		daoimpl.update();
		
	}
	
	@RequestMapping(value="/user/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void delete(@RequestBody User user){
		
		daoimpl.delete(user);
		
	}
	
	@RequestMapping(value="/user/fullname", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void getFullName(@RequestBody User user){
		
		daoimpl.getUserByID();
		
	}

}
