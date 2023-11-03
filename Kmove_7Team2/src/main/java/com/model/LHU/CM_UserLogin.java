package com.model.LHU;

public class CM_UserLogin {
    private String id;
    private String password;
    private String manager;

    public CM_UserLogin(String id, String password, String manager) {
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
}
	
	
	



