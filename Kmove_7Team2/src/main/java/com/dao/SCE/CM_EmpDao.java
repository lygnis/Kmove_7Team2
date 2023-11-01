package com.dao.SCE;

public class CM_EmpDao {
	private static CM_EmpDao instance = new CM_EmpDao();
	private CM_EmpDao () {}
	public static CM_EmpDao getInstance() {
		return instance;
	}
}
