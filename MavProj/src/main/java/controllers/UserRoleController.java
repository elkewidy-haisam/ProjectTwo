package controllers;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserRoleDAO;

public class UserRoleController {
	
	private UserRoleDAO dao;
	
	public void setDao(UserRoleDAO dao) {
		this.dao = dao;
		
	}
	
	@RequestMapping(value="/role/get", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void getRole(@Valid @RequestBody int user_role_id) {
		
		dao.getRoleByID(user_role_id);
		
	}
	
	
}
