package com.model.PJS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class CM_AllYearPay {
	Map<Integer, Integer> dedPayRs = new HashMap<>();
	Map<Integer, Integer> itemPayrs = new HashMap<>();
	List<Integer> allPayList = new ArrayList<Integer>(12);
	List<Float> calPerList = new ArrayList<Float>(12);
	Map<Integer, Integer> empCount = new HashMap<>();
	public Map<Integer, Integer> getDedPayRs() {
		return dedPayRs;
	}
	public void setDedPayRs(String data, String idata) {
		if(idata == null)
			return;
		dedPayRs.put(Integer.parseInt(data), Integer.parseInt(idata));
	}
	public Map<Integer, Integer> getItemPayrs() {
		return itemPayrs;
	}
	public void setItemPayrs(String data, String idata) {
		if(idata == null)
			return;
		itemPayrs.put(Integer.parseInt(data), Integer.parseInt(idata));
	}
	
	public Map<Integer, Integer> getEmpCount() {
		return empCount;
	}
	public void setEmpCount(int data, String idata) {
		if(idata == null)
			return;
		empCount.put(data, Integer.parseInt(idata));
	}
	
	
	public List<Integer> getallPayList() {
		
		for(Map.Entry<Integer, Integer>entry : itemPayrs.entrySet()) {
			allPayList.add(entry.getValue());
		}
		for(int i=0; i<allPayList.size(); i++) {
			int temp = allPayList.get(i);
			allPayList.set(i, temp - dedPayRs.get(i+1));
		}
		return allPayList;
	}
	
	public List<Float> getcalPerList() {
		calPerList.add(0, 0.0f);
		for(int i=1; i<allPayList.size(); i++) {
			int itemp =  allPayList.get(i);
			float fTemp = (float)itemp / (float)allPayList.get(i-1);
			if(fTemp >=0.999999999 && fTemp <1.000001)
				fTemp = 0.0f;
			calPerList.add(i, fTemp);
		}
		//calPerList.add(11, 0.0f);
		return calPerList;
	}
}
