package com.model.SCE;

import java.util.ArrayList;
import java.util.List;

public class CM_EmpList {
	private List<CM_Employee> list = new ArrayList<CM_Employee>();

	public List<CM_Employee> getList() {
		return list;
	}

	public void setList(CM_Employee list) {
		this.list.add(list);
	}
	
}
