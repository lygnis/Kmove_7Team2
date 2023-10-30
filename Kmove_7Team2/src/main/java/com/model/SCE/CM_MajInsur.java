package com.model.SCE;

public class CM_MajInsur {
	
	private String empNo; //사원번호
	private int nation_pens; //국민연금
	private int heal_insur; //건강보험
	private int elder_insur; //노인장기요양보험
	private int employ_insur; //고용보험
	private int nation_pens_num; //국민연금 기호번호
	private int heal_insur_num; //건강보험 기호번호
	private int employ_insur_num; //고용보험 기호번호
	private int indu_insur_num; //산재보험 기호번호
	private int nation_startdate; // 국민연금 취득일
	private int heal_startdate; //건강보험 취득일
	private int employ_startdate;//고용보험 취득일
	private int indu_startdate; //산재보험 취득일
	private int nation_enddate;//국민연금 상실일
	private int heal_enddate;//건강보험 상실일
	private int employ_enddate; //고용보험 상실일
	private int indu_enddate; //산재보험 상실일
	
	
	public CM_MajInsur(String empNo, int nation_pens, int heal_insur, int elder_insur, int employ_insur,
			int nation_pens_num, int heal_insur_num, int employ_insur_num, int indu_insur_num, int nation_startdate,
			int heal_startdate, int employ_startdate, int indu_startdate, int nation_enddate, int heal_enddate,
			int employ_enddate, int indu_enddate) {
		super();
		this.empNo = empNo;
		this.nation_pens = nation_pens;
		this.heal_insur = heal_insur;
		this.elder_insur = elder_insur;
		this.employ_insur = employ_insur;
		this.nation_pens_num = nation_pens_num;
		this.heal_insur_num = heal_insur_num;
		this.employ_insur_num = employ_insur_num;
		this.indu_insur_num = indu_insur_num;
		this.nation_startdate = nation_startdate;
		this.heal_startdate = heal_startdate;
		this.employ_startdate = employ_startdate;
		this.indu_startdate = indu_startdate;
		this.nation_enddate = nation_enddate;
		this.heal_enddate = heal_enddate;
		this.employ_enddate = employ_enddate;
		this.indu_enddate = indu_enddate;
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


	public int getNation_pens_num() {
		return nation_pens_num;
	}


	public int getHeal_insur_num() {
		return heal_insur_num;
	}


	public int getEmploy_insur_num() {
		return employ_insur_num;
	}


	public int getIndu_insur_num() {
		return indu_insur_num;
	}


	public int getNation_startdate() {
		return nation_startdate;
	}


	public int getHeal_startdate() {
		return heal_startdate;
	}


	public int getEmploy_startdate() {
		return employ_startdate;
	}


	public int getIndu_startdate() {
		return indu_startdate;
	}


	public int getNation_enddate() {
		return nation_enddate;
	}


	public int getHeal_enddate() {
		return heal_enddate;
	}


	public int getEmploy_enddate() {
		return employ_enddate;
	}


	public int getIndu_enddate() {
		return indu_enddate;
	}
	
}
