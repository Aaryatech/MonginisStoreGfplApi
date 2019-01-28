package com.ats.triladmin.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConsumptionReportData implements Serializable{
	
	@Id
	private int sr;
	
	private int catId;
	
	private String catDesc;
	
	private float monthlyValue;
	
	private float ytd;

	public int getSr() {
		return sr;
	}

	public void setSr(int sr) {
		this.sr = sr;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public float getMonthlyValue() {
		return monthlyValue;
	}

	public void setMonthlyValue(float monthlyValue) {
		this.monthlyValue = monthlyValue;
	}

	public float getYtd() {
		return ytd;
	}

	public void setYtd(float ytd) {
		this.ytd = ytd;
	}

	@Override
	public String toString() {
		return "ConsumptionReportData [sr=" + sr + ", catId=" + catId + ", catDesc=" + catDesc + ", monthlyValue="
				+ monthlyValue + ", ytd=" + ytd + "]";
	} 

	 
	
}
