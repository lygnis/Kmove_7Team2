package com.model.LHU;

public class CM_User {
	
	private String id;
	private String password;
	private String manager;
	
	public CM_User(String id, String password, String manager) {
	
		this.id = id;
		this.password = password;
		this.manager = manager;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	
	  public String getManager() { 
		  return manager; 
	  }
	 
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}
}