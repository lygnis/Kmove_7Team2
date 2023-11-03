package com.dao.LHU;

public class CM_MainDao {
	private static CM_MainDao instance = new CM_MainDao();
	private CM_MainDao() {}
	public static CM_MainDao getInstance() {
		return instance;
	}
}
