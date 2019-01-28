package com.ats.triladmin.model.report;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class IndentReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ind_m_id")
	private int indMId;

	@Column(name = "ind_m_no")
	private String indMNo;
	@Column(name = "ind_m_date")
	private Date indMDate;

	@Column(name = "ind_m_type")
	private int indMType;

	private int catId;

	private int achdId;
	@Column(name = "ind_isdev")
	private int indIsdev;// change to int

	private String indRemark;

	private int indIsmonthly;

	@Column(name = "ind_m_status")

	private int indMStatus;

	private int indFyr;

	private int deptId;
	private int subDeptId;

	private String deptDesc;
	private String subDeptDesc;
	private String catDesc;
	private String accHeadDesc;
	private String typeName;
	@Transient
	List<IndentReportDetail> indentReportDetailList;

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

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
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

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getAchdId() {
		return achdId;
	}

	public void setAchdId(int achdId) {
		this.achdId = achdId;
	}

	public int getIndIsdev() {
		return indIsdev;
	}

	public void setIndIsdev(int indIsdev) {
		this.indIsdev = indIsdev;
	}

	public String getIndRemark() {
		return indRemark;
	}

	public void setIndRemark(String indRemark) {
		this.indRemark = indRemark;
	}

	public int getIndIsmonthly() {
		return indIsmonthly;
	}

	public void setIndIsmonthly(int indIsmonthly) {
		this.indIsmonthly = indIsmonthly;
	}

	public int getIndMStatus() {
		return indMStatus;
	}

	public void setIndMStatus(int indMStatus) {
		this.indMStatus = indMStatus;
	}

	public int getIndFyr() {
		return indFyr;
	}

	public void setIndFyr(int indFyr) {
		this.indFyr = indFyr;
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

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public String getSubDeptDesc() {
		return subDeptDesc;
	}

	public void setSubDeptDesc(String subDeptDesc) {
		this.subDeptDesc = subDeptDesc;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public String getAccHeadDesc() {
		return accHeadDesc;
	}

	public void setAccHeadDesc(String accHeadDesc) {
		this.accHeadDesc = accHeadDesc;
	}

	public List<IndentReportDetail> getIndentReportDetailList() {
		return indentReportDetailList;
	}

	public void setIndentReportDetailList(List<IndentReportDetail> indentReportDetailList) {
		this.indentReportDetailList = indentReportDetailList;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "IndentReport [indMId=" + indMId + ", indMNo=" + indMNo + ", indMDate=" + indMDate + ", indMType="
				+ indMType + ", catId=" + catId + ", achdId=" + achdId + ", indIsdev=" + indIsdev + ", indRemark="
				+ indRemark + ", indIsmonthly=" + indIsmonthly + ", indMStatus=" + indMStatus + ", indFyr=" + indFyr
				+ ", deptId=" + deptId + ", subDeptId=" + subDeptId + ", deptDesc=" + deptDesc + ", subDeptDesc="
				+ subDeptDesc + ", catDesc=" + catDesc + ", accHeadDesc=" + accHeadDesc + ", typeName=" + typeName
				+ ", indentReportDetailList=" + indentReportDetailList + "]";
	}

}
