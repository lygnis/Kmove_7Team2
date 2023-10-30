package com.model.SCE;

import java.util.Date;

public class CM_Employee {
	
	private String empNo; //사원번호
	private String name; //성명
	private Date joinDate; //입사일
	private Date quitDate; //퇴사일
	private String department; //부서
	private String spot; //직위
	private String nation; //국적
	private String secNumber; //주민번호
	private String addr; //주소
	private String phNum;
	private String cellPh;
	private String email;
	private String sns;
	private String etc;
	private String account;
	
	
	public CM_Employee(String empNo, String name, Date joinDate, Date quitDate, String department, String spot,
			String nation, String secNumber, String addr, String phNum, String cellPh, String email, String sns,
			String etc, String account) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.joinDate = joinDate;
		this.quitDate = quitDate;
		this.department = department;
		this.spot = spot;
		this.nation = nation;
		this.secNumber = secNumber;
		this.addr = addr;
		this.phNum = phNum;
		this.cellPh = cellPh;
		this.email = email;
		this.sns = sns;
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


	public String getNation() {
		return nation;
	}


	public String getSecNumber() {
		return secNumber;
	}


	public String getAddr() {
		return addr;
	}


	public String getPhNum() {
		return phNum;
	}


	public String getCellPh() {
		return cellPh;
	}


	public String getEmail() {
		return email;
	}


	public String getSns() {
		return sns;
	}


	public String getEtc() {
		return etc;
	}


	public String getAccount() {
		return account;
	}
}
