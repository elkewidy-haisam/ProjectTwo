package com.positivity.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.positivity.dao.UserRoleDAO;
import com.positivity.dao.UserRoleDAOImpl;


@Controller("/role")
public class UserRoleController {
	
	@Autowired
	private UserRoleDAO dao;
	
	public void setDao(UserRoleDAO daoimpl) {
		this.dao = daoimpl;
		
	}
	
	@RequestMapping(value="/getUserRole", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void getRole(@Valid @RequestBody int user_role_id) {
		
		dao.getRoleByID(user_role_id);
		
	}
	
	
}
