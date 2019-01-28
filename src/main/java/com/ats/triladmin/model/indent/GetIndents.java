package com.ats.triladmin.model.indent;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetIndents {

	@Id
	@Column(name = "ind_m_id")
	private int indMId;

	@Column(name = "ind_m_no")
	private String indMNo;
	
	@Column(name = "ind_m_date")
	private Date indMDate;

	@Column(name = "ind_m_type")
	private int indMType;
	
	private String indIsdev;
	
	private int indIsmonthly;

	private String catDesc;
	
	private int achdId;
	
	private String accountHead;
	
	@Column(name = "ind_m_status")
	private int indMStatus;
	
	private int deptId;
	
	private int subDeptId;

	@Transient
	List<DashIndentDetails> dashIndentDetailList;
	
	public String getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}

	public List<DashIndentDetails> getDashIndentDetailList() {
		return dashIndentDetailList;
	}

	public void setDashIndentDetailList(List<DashIndentDetails> dashIndentDetailList) {
		this.dashIndentDetailList = dashIndentDetailList;
	}

	public int getIndMId() {
		return indMId;
	}

	public void setIndMId(int indMId) {
		this.indMId = indMId;
	}

	public String getIndMNo() {
		return indMNo;
	}

	public void setIndMNo(String indMNo) {
		this.indMNo = indMNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIndMDate() {
		return indMDate;
	}

	public void setIndMDate(Date indMDate) {
		this.indMDate = indMDate;
	}

	public int getIndMType() {
		return indMType;
	}

	public void setIndMType(int indMType) {
		this.indMType = indMType;
	}

	public String getIndIsdev() {
		return indIsdev;
	}

	public void setIndIsdev(String indIsdev) {
		this.indIsdev = indIsdev;
	}

	public int getIndIsmonthly() {
		return indIsmonthly;
	}

	public void setIndIsmonthly(int indIsmonthly) {
		this.indIsmonthly = indIsmonthly;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public int getAchdId() {
		return achdId;
	}

	public void setAchdId(int achdId) {
		this.achdId = achdId;
	}

	public int getIndMStatus() {
		return indMStatus;
	}

	public void setIndMStatus(int indMStatus) {
		this.indMStatus = indMStatus;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getSubDeptId() {
		return subDeptId;
	}

	public void setSubDeptId(int subDeptId) {
		this.subDeptId = subDeptId;
	}

	@Override
	public String toString() {
		return "GetIndents [indMId=" + indMId + ", indMNo=" + indMNo + ", indMDate=" + indMDate + ", indMType="
				+ indMType + ", indIsdev=" + indIsdev + ", indIsmonthly=" + indIsmonthly + ", catDesc=" + catDesc
				+ ", achdId=" + achdId + ", accountHead=" + accountHead + ", indMStatus=" + indMStatus + ", deptId="
				+ deptId + ", subDeptId=" + subDeptId + ", dashIndentDetailList=" + dashIndentDetailList + "]";
	}
    
}
