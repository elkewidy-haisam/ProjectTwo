package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

@Controller
public class UserController {
	
	private UserDAOImpl daoimpl;
	
	public void setDaoImpl(UserDAOImpl daoimpl) {
		this.daoimpl = daoimpl;
	}
	
	@RequestMapping(value="/user/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void create(@Valid @RequestBody User user){
		
		daoimpl.createUser(user);
		
	}
	
	@RequestMapping(value="/user/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void update(@RequestBody User user){
		
		daoimpl.updateUser(user);
		
	}
	
	@RequestMapping(value="/user/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void delete(@RequestBody User user){
		
		daoimpl.deleteUser(user);
		
	}
	
	@RequestMapping(value="/user/fullname", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getFullName(@RequestBody User user){
		
		return daoimpl.getFullName(user);
		
	}

}
