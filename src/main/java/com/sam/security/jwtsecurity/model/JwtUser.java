package com.sam.security.jwtsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_User")
public class JwtUser {

	@Id
	@GeneratedValue
	private Long id;

	private String userName;
	private String password;
	private String role;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public Long getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
