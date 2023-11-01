package com.dao.SDJ;

public class CM_PayDao {
	private static CM_PayDao instance = new CM_PayDao();
	private CM_PayDao() {}
	public static CM_PayDao getInstance() {
		return instance;
	}
}
