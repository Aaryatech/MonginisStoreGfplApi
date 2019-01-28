package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MonthSubDeptWiseIssueReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "sr")
	private int sr;
	
	@Column(name = "sub_dept_id")
	private int subDeptId;

	@Column(name = "sub_dept_code")
	private String subDeptCode;
	
	@Column(name = "month_no")
	private int monthNo;

	@Column(name = "month_name")
	private String monthName;
   
	@Column(name = "issue_qty")
	private float issueQty;
	
	@Column(name = "issue_qty_value")
	private float issueQtyValue;
	
	@Column(name = "issue_landing_value")
	private float issueLandingValue;

	public int getSr() {
		return sr;
	}

	public void setSr(int sr) {
		this.sr = sr;
	}

	public int getSubDeptId() {
		return subDeptId;
	}

	public void setSubDeptId(int subDeptId) {
		this.subDeptId = subDeptId;
	}

	public String getSubDeptCode() {
		return subDeptCode;
	}

	public void setSubDeptCode(String subDeptCode) {
		this.subDeptCode = subDeptCode;
	}

	public int getMonthNo() {
		return monthNo;
	}

	public void setMonthNo(int monthNo) {
		this.monthNo = monthNo;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public float getIssueQty() {
		return issueQty;
	}

	public void setIssueQty(float issueQty) {
		this.issueQty = issueQty;
	}

	public float getIssueQtyValue() {
		return issueQtyValue;
	}

	public void setIssueQtyValue(float issueQtyValue) {
		this.issueQtyValue = issueQtyValue;
	}

	public float getIssueLandingValue() {
		return issueLandingValue;
	}

	public void setIssueLandingValue(float issueLandingValue) {
		this.issueLandingValue = issueLandingValue;
	}

	@Override
	public String toString() {
		return "MonthSubDeptWiseIssueReport [sr=" + sr + ", subDeptId=" + subDeptId + ", subDeptCode=" + subDeptCode
				+ ", monthNo=" + monthNo + ", monthName=" + monthName + ", issueQty=" + issueQty + ", issueQtyValue="
				+ issueQtyValue + ", issueLandingValue=" + issueLandingValue + "]";
	}
	
	

}
