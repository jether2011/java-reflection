package com.jetherrodrigues.class1;

import java.io.Serializable;

import com.jetherrodrigues.util.GsonSingleton;

/**
 * 
 * @author JETHER ROIS
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8325312961937637396L;
	
	private String name;
	private String username;
	private String email;
	private String password;

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return GsonSingleton.getInstance().toJson(this);
	}

}
