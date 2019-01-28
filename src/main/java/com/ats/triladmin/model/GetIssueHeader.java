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
public class GetIssueHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "issue_id")
	private int issueId;

	@Column(name = "issue_no")
	private String issueNo;

	@Column(name = "item_category")
	private int itemCategory;

	@Column(name = "issue_date")
	private Date issueDate;

	@Column(name = "delete_status")
	private int deleteStatus;
	
	@Column(name = "dept_id")
	private int deptId;
	
	@Column(name = "sub_dept_id")
	private int subDeptId;
	
	@Column(name = "acc_head")
	private int accHead;

	@Column(name = "status")
	private int status;
	
	@Column(name = "dept_code")
	private String deptCode;
	
	@Column(name = "sub_dept_code")
	private String subDeptCode;
	
	@Column(name = "acc_head_desc")
	private String accHeadDesc;
	
	@Column(name = "issue_slip_no")
	private String issueSlipNo;
	
	@Transient
	List<GetIssueDetail> issueDetailList;

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public int getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(int itemCategory) {
		this.itemCategory = itemCategory;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public int getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<GetIssueDetail> getIssueDetailList() {
		return issueDetailList;
	}

	public void setIssueDetailList(List<GetIssueDetail> issueDetailList) {
		this.issueDetailList = issueDetailList;
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

	public int getAccHead() {
		return accHead;
	}

	public void setAccHead(int accHead) {
		this.accHead = accHead;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getSubDeptCode() {
		return subDeptCode;
	}

	public void setSubDeptCode(String subDeptCode) {
		this.subDeptCode = subDeptCode;
	}

	public String getAccHeadDesc() {
		return accHeadDesc;
	}

	public void setAccHeadDesc(String accHeadDesc) {
		this.accHeadDesc = accHeadDesc;
	}

	public String getIssueSlipNo() {
		return issueSlipNo;
	}

	public void setIssueSlipNo(String issueSlipNo) {
		this.issueSlipNo = issueSlipNo;
	}

	@Override
	public String toString() {
		return "GetIssueHeader [issueId=" + issueId + ", issueNo=" + issueNo + ", itemCategory=" + itemCategory
				+ ", issueDate=" + issueDate + ", deleteStatus=" + deleteStatus + ", deptId=" + deptId + ", subDeptId="
				+ subDeptId + ", accHead=" + accHead + ", status=" + status + ", deptCode=" + deptCode
				+ ", subDeptCode=" + subDeptCode + ", accHeadDesc=" + accHeadDesc + ", issueSlipNo=" + issueSlipNo
				+ ", issueDetailList=" + issueDetailList + "]";
	}

	 
	

}
