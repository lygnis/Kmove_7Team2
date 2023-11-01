package com.model.SCE;

public class CM_MajInsur {

	private String empNo; // 사원번호
	private int nation_pens; // 국민연금
	private int heal_insur; // 건강보험
	private int elder_insur; // 노인장기요양보험
	private int employ_insur; // 고용보험

	public CM_MajInsur(String empNo, int nation_pens, int heal_insur, int elder_insur, int employ_insur) {
		super();
		this.empNo = empNo;
		this.nation_pens = nation_pens;
		this.heal_insur = heal_insur;
		this.elder_insur = elder_insur;
		this.employ_insur = employ_insur;
	}

	public String getEmpNo() {
		return empNo;
	}

	public int getNation_pens() {
		return nation_pens;
	}

	public int getHeal_insur() {
		return heal_insur;
	}

	public int getElder_insur() {
		return elder_insur;
	}

	public int getEmploy_insur() {
		return employ_insur;
	}

}