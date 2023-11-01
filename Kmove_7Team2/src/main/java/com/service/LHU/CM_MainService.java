package com.service.LHU;

public class CM_MainService {
	private static CM_MainService instance = new CM_MainService();
	private CM_MainService() {}
	public static CM_MainService getInstance() {
		return instance;
	}
}
