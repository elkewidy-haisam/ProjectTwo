package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserRole {
	
	@Id
	@Column(name="USERROLE_ID")
	private int user_role_id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	
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
