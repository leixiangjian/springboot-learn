package com.springboot.learn.web.controller.bean;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String password;
	private String email;
	private Date dob;

	public User() {}
	public User(Integer id, String userName, String password) {
		super();
		this.id = id;
		this.name = userName;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", dob=" + dob
				+ "]";
	}

}
