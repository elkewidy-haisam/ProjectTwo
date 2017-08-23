package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserRole {
	
	@Id
	@Column
	private int user_role_id;
	
	@Column
	private int role_id;
	
	@Column
	private String description;
	
	
	public UserRole() {
		super();
	}

	public UserRole(int user_role_id, int role_id, String description) {
		super();
		this.user_role_id = user_role_id;
		this.role_id = role_id;
		this.description = description;
	}

	
	
	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
