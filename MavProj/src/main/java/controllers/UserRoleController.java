package controllers;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserRoleDAO;
import dao.UserRoleDAOImpl;

public class UserRoleController {
	
	private UserRoleDAOImpl daoimpl;
	
	public void setDaoImpl(UserRoleDAOImpl daoimpl) {
		this.daoimpl = daoimpl;
		
	}
	
	@RequestMapping(value="/role/get", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void getRole(@Valid @RequestBody int user_role_id) {
		
		daoimpl.getRoleByID(user_role_id);
		
	}
	
	
}
