package com.ats.triladmin.model.indent;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "indent")
public class Indent {

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

	private int indIsdev;// change to int

	private String indRemark;

	private int indIsmonthly;

	@Column(name = "ind_m_status")

	private int indMStatus;

	private int indFyr;

	private int deptId;
	private int subDeptId;
	
	
	//new field 21 aug
	@Column(name = "ind_apr1_date")
	private Date indApr1Date;
	
	@Column(name = "ind_apr2_date")
	private Date indApr2Date;


	public int getDeptId() {
		return deptId;
	}

	public int getSubDeptId() {
		return subDeptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public void setSubDeptId(int subDeptId) {
		this.subDeptId = subDeptId;
	}

	public int getIndMId() {
		return indMId;
	}

	public String getIndMNo() {
		return indMNo;
	}

	public Date getIndMDate() {
		return indMDate;
	}

	public int getIndMType() {
		return indMType;
	}

	public int getCatId() {
		return catId;
	}

	public int getAchdId() {
		return achdId;
	}

	public String getIndRemark() {
		return indRemark;
	}

	public int getIndIsmonthly() {
		return indIsmonthly;
	}

	public int getIndMStatus() {
		return indMStatus;
	}

	public int getIndFyr() {
		return indFyr;
	}

	public void setIndMId(int indMId) {
		this.indMId = indMId;
	}

	public void setIndMNo(String indMNo) {
		this.indMNo = indMNo;
	}

	public void setIndMDate(Date indMDate) {
		this.indMDate = indMDate;
	}

	public void setIndMType(int indMType) {
		this.indMType = indMType;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public void setAchdId(int achdId) {
		this.achdId = achdId;
	}

	public void setIndRemark(String indRemark) {
		this.indRemark = indRemark;
	}

	public void setIndIsmonthly(int indIsmonthly) {
		this.indIsmonthly = indIsmonthly;
	}

	public void setIndMStatus(int indMStatus) {
		this.indMStatus = indMStatus;
	}

	public void setIndFyr(int indFyr) {
		this.indFyr = indFyr;
	}

	@Transient
	List<IndentTrans> indentTrans;

	public List<IndentTrans> getIndentTrans() {
		return indentTrans;
	}

	public void setIndentTrans(List<IndentTrans> indentTrans) {
		this.indentTrans = indentTrans;
	}

	
	
	
	
	public int getIndIsdev() {
		return indIsdev;
	}

	public Date getIndApr1Date() {
		return indApr1Date;
	}

	public Date getIndApr2Date() {
		return indApr2Date;
	}

	public void setIndIsdev(int indIsdev) {
		this.indIsdev = indIsdev;
	}

	public void setIndApr1Date(Date indApr1Date) {
		this.indApr1Date = indApr1Date;
	}

	public void setIndApr2Date(Date indApr2Date) {
		this.indApr2Date = indApr2Date;
	}

	@Override
	public String toString() {
		return "Indent [indMId=" + indMId + ", indMNo=" + indMNo + ", indMDate=" + indMDate + ", indMType=" + indMType
				+ ", catId=" + catId + ", achdId=" + achdId + ", indIsdev=" + indIsdev + ", indRemark=" + indRemark
				+ ", indIsmonthly=" + indIsmonthly + ", indMStatus=" + indMStatus + ", indFyr=" + indFyr + ", deptId="
				+ deptId + ", subDeptId=" + subDeptId + ", indApr1Date=" + indApr1Date + ", indApr2Date=" + indApr2Date
				+ ", indentTrans=" + indentTrans + "]";
	}

}
