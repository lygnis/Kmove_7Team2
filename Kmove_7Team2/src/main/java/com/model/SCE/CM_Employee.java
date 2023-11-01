package com.model.SCE;

import java.util.Date;

public class CM_Employee {

	private String empNo; // 사원번호
	private String name; // 성명
	private Date joinDate; // 입사일
	private Date quitDate; // 퇴사일
	private String department; // 부서
	private String spot; // 직위
	private String secNumber; // 주민번호
	private String addr; // 주소
	private String cellPh;
	private String email;
	private String etc;
	private String account;

	public CM_Employee(String empNo, String name, Date joinDate, Date quitDate, String department, String spot,
			String secNumber, String addr, String cellPh, String email, String etc, String account) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.joinDate = joinDate;
		this.quitDate = quitDate;
		this.department = department;
		this.spot = spot;
		this.secNumber = secNumber;
		this.addr = addr;
		this.cellPh = cellPh;
		this.email = email;
		this.etc = etc;
		this.account = account;
	}

	public String getEmpNo() {
		return empNo;
	}

	public String getName() {
		return name;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public Date getQuitDate() {
		return quitDate;
	}

	public String getDepartment() {
		return department;
	}

	public String getSpot() {
		return spot;
	}

	public String getSecNumber() {
		return secNumber;
	}

	public String getAddr() {
		return addr;
	}

	public String getCellPh() {
		return cellPh;
	}

	public String getEmail() {
		return email;
	}

	public String getEtc() {
		return etc;
	}

	public String getAccount() {
		return account;
	}
}
