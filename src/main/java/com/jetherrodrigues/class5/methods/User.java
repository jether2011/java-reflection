package com.jetherrodrigues.class5.methods;

import javax.xml.bind.annotation.XmlRootElement;

import com.jetherrodrigues.util.GsonSingleton;

@XmlRootElement
public class User {
	
	private String name;
	private String email;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isValidEmail(){
		return email.contains("@");
	}
	
	public boolean isValidPasswordLength(){
		return password.length() >= 8;
	}

	@Override
	public String toString() {
		return GsonSingleton.getInstance().toJson(this);
	}

}
