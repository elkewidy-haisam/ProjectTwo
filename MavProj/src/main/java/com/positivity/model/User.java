package com.positivity.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="USERS")
public class User {
	
	//fields
	
	@Id
	@Column(name="USER_ID")
	private int user_id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="USERROLE_USERROLE_ID")
	private int userrole_id;
	
	/*@OneToMany(mappedBy="user")
	private Set<BlogPost> blogposts; */
	
	public User(){
		super();
		
	}
	
	public User(int user_id, String username, String firstname, String lastname, String email, String password, int userrole_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.userrole_id = userrole_id;
	
	}
	
	
	public int getUser_id() {
		
		return user_id;
		
	}
	
	public void setUser_id(int user_id) {
		
		this.user_id = user_id;
		
	}
	
	public String getUsername() {
		
		return username;
		
	}
	
	public void setUsername(String username) {
		
		this.username = username;
		
	}
	
	public String getFirstname() {
		
		return firstname;
		
	}
	
	public void setFirstname(String firstname) {
		
		this.firstname = firstname;
		
	}
	
	public String getLastname() {
		
		return lastname;
		
	}
	
	public void setLastname(String lastname) {
		
		this.lastname = lastname;
		
	}
	
	public String getEmail() {
		
		return email;
		
	}
	
	public void setEmail(String email) {
		
		this.email = email;
		
	}
	
	public String getPassword() {
		
		return password;
		
	}
	
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
	public int getUserrole_id() {
		
		return userrole_id;
		
	}
	
	public void setUserrole_id(int userrole_id) {
		
		this.userrole_id = userrole_id;
		
	}
	

}
