package com.positivity.dao;

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
	
	@RequestMapping(value="/user/create", method=RequestMethod.POST)
	@ResponseBody
	public String create(@Valid @RequestBody User user){
		
		return "user/create";
		
	}
	
	@RequestMapping(value="/user/update", method=RequestMethod.PUT)
	@ResponseBody
	public String update(@RequestBody User user){
		
		return "user/update";
		
	}
	
	@RequestMapping(value="/user/delete", method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestBody User user){
		
		return "user/delete";
		
	}
	
	@RequestMapping(value="/user/fullname", method=RequestMethod.GET)
	@ResponseBody
	public String getFullName(@RequestBody User user){
		
		return "user/fullname";
		
	}

}
