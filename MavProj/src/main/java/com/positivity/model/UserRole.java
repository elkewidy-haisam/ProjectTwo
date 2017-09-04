package com.positivity.model;

import javax.persistence.*;
import com.positivity.model.*;

@Entity
@Table(name="USERROLE")
public class UserRole {
	
	@Id
	@Column(name="USERROLE_ID")
	private int user_role_id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToOne
	@JoinColumn(name="user_role_id")
	private User user;
	
	
	
	public UserRole() {
		super();
	}

	public UserRole(int user_role_id, String description) {
		super();
		this.user_role_id = user_role_id;
		this.description = description;
	}

	
	
	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
