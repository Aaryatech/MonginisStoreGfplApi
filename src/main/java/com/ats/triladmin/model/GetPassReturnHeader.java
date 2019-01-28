package com.ats.triladmin.model;

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
public class GetPassReturnHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "return_id")
	private int returnId;
	
	@Column(name = "return_no")
	private String returnNo;
	
	@Column(name = "gp_id")
	private int gpId;
	
	@Column(name = "gp_no")
	private String gpNo;
	
	@Column(name = "vendor_id")
	private int vendorId;
	
	@Column(name = "gp_return_date")
	private Date gpReturnDate;
	
	@Column(name = "gp_remark")
	private String gpRemark;
	
	@Column(name = "gp_remark1")
	private String gpRemark1;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "is_used")
	private int isUsed;
	
	@Column(name = "vendor_name")
	private String vendorName;
	 
	@Transient
	List<GetPassReturnDetailWithItemName> getPassReturnDetailList;

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public String getReturnNo() {
		return returnNo;
	}

	public void setReturnNo(String returnNo) {
		this.returnNo = returnNo;
	}

	public int getGpId() {
		return gpId;
	}

	public void setGpId(int gpId) {
		this.gpId = gpId;
	}

	public String getGpNo() {
		return gpNo;
	}

	public void setGpNo(String gpNo) {
		this.gpNo = gpNo;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGpReturnDate() {
		return gpReturnDate;
	}

	public void setGpReturnDate(Date gpReturnDate) {
		this.gpReturnDate = gpReturnDate;
	}

	public String getGpRemark() {
		return gpRemark;
	}

	public void setGpRemark(String gpRemark) {
		this.gpRemark = gpRemark;
	}

	public String getGpRemark1() {
		return gpRemark1;
	}

	public void setGpRemark1(String gpRemark1) {
		this.gpRemark1 = gpRemark1;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public List<GetPassReturnDetailWithItemName> getGetPassReturnDetailList() {
		return getPassReturnDetailList;
	}

	public void setGetPassReturnDetailList(List<GetPassReturnDetailWithItemName> getPassReturnDetailList) {
		this.getPassReturnDetailList = getPassReturnDetailList;
	}

	@Override
	public String toString() {
		return "GetPassReturnHeader [returnId=" + returnId + ", returnNo=" + returnNo + ", gpId=" + gpId + ", gpNo="
				+ gpNo + ", vendorId=" + vendorId + ", gpReturnDate=" + gpReturnDate + ", gpRemark=" + gpRemark
				+ ", gpRemark1=" + gpRemark1 + ", status=" + status + ", isUsed=" + isUsed + ", vendorName="
				+ vendorName + ", getPassReturnDetailList=" + getPassReturnDetailList + "]";
	}
	
	

}
