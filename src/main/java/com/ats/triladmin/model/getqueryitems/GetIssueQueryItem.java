package com.ats.triladmin.model.getqueryitems;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetIssueQueryItem {
	
	@Id
	@Column(name = "issue_detail_id")
	private int issueDetailId;
	
	private String issueNo;
	
	private Date issueDate;
	
	private float itemIssueQty;
	
	private String itemDesc;
	private String itemCode;
	private String itemUom;
	
	private String deptCode;
	private String deptDesc;
	
	private String subDeptCode;
	private String subDeptDesc;
	public int getIssueDetailId() {
		return issueDetailId;
	}
	public String getIssueNo() {
		return issueNo;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIssueDate() {
		return issueDate;
	}
	public float getItemIssueQty() {
		return itemIssueQty;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public String getItemCode() {
		return itemCode;
	}
	public String getItemUom() {
		return itemUom;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public String getSubDeptCode() {
		return subDeptCode;
	}
	public String getSubDeptDesc() {
		return subDeptDesc;
	}
	public void setIssueDetailId(int issueDetailId) {
		this.issueDetailId = issueDetailId;
	}
	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public void setItemIssueQty(float itemIssueQty) {
		this.itemIssueQty = itemIssueQty;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public void setSubDeptCode(String subDeptCode) {
		this.subDeptCode = subDeptCode;
	}
	public void setSubDeptDesc(String subDeptDesc) {
		this.subDeptDesc = subDeptDesc;
	}
	@Override
	public String toString() {
		return "GetIssueQueryItem [issueDetailId=" + issueDetailId + ", issueNo=" + issueNo + ", issueDate=" + issueDate
				+ ", itemIssueQty=" + itemIssueQty + ", itemDesc=" + itemDesc + ", itemCode=" + itemCode + ", itemUom="
				+ itemUom + ", deptCode=" + deptCode + ", deptDesc=" + deptDesc + ", subDeptCode=" + subDeptCode
				+ ", subDeptDesc=" + subDeptDesc + "]";
	}
	
	

}
