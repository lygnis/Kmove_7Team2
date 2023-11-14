package com.model.PJS;

import java.util.Date;


public class CM_EmpPayData {
	private Date paymentData;
	private String emp_no;
	private int nationPen;
	private int healInsur;
	private int elderInsur;
	private int incomeTex;
	private int localeIncomeTex;
	private int mutualAid;
	private int basicPay;
	private int foodExp;
	private int childAllow;
	private int posAllow;
	private int vehMainten;
	private int servAllow;
	private int callAllow;
	private int bonus;
	private int holiBonus;
	
	
	public CM_EmpPayData(Date paymentData, String emp_no, int nationPen, int healInsur, int elderInsur, int incomeTex,
			int localeIncomeTex, int mutualAid, int basicPay, int foodExp, int childAllow, int posAllow, int vehMainten,
			int servAllow, int callAllow, int bonus, int holiBonus) {
		super();
		this.paymentData = paymentData;
		this.emp_no = emp_no;
		this.nationPen = nationPen;
		this.healInsur = healInsur;
		this.elderInsur = elderInsur;
		this.incomeTex = incomeTex;
		this.localeIncomeTex = localeIncomeTex;
		this.mutualAid = mutualAid;
		this.basicPay = basicPay;
		this.foodExp = foodExp;
		this.childAllow = childAllow;
		this.posAllow = posAllow;
		this.vehMainten = vehMainten;
		this.servAllow = servAllow;
		this.callAllow = callAllow;
		this.bonus = bonus;
		this.holiBonus = holiBonus;
	}
	
	public Date getPaymentData() {
		return paymentData;
	}
	public String getEmp_no() {
		return emp_no;
	}
	public int getNationPen() {
		return nationPen;
	}
	public int getHealInsur() {
		return healInsur;
	}
	public int getElderInsur() {
		return elderInsur;
	}
	public int getIncomeTex() {
		return incomeTex;
	}
	public int getLocaleIncomeTex() {
		return localeIncomeTex;
	}
	public int getMutualAid() {
		return mutualAid;
	}
	public int getBasicPay() {
		return basicPay;
	}
	public int getFoodExp() {
		return foodExp;
	}
	public int getChildAllow() {
		return childAllow;
	}
	public int getPosAllow() {
		return posAllow;
	}
	public int getVehMainten() {
		return vehMainten;
	}
	public int getServAllow() {
		return servAllow;
	}
	public int getCallAllow() {
		return callAllow;
	}
	public int getBonus() {
		return bonus;
	}
	public int getHoliBonus() {
		return holiBonus;
	}
	
}
