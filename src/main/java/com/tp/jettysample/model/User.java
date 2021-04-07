package com.tp.jettysample.model;

import javax.xml.bind.annotation.XmlRootElement;

public class User {
	
	private String username;
	private String password;
	private String fullname;
	private int age;
	private long balance;
	
	public User(String username, String password, String fullname, int age, long balance) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.age = age;
		this.balance = balance;
	}

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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	
}
