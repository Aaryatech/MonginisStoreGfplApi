package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IssueAndMrnItemWise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_code")
	private String itemCode;
 
	@Column(name = "approve_qty")
	private float approveQty;
 
	@Column(name = "approved_qty_value")
	private float approvedQtyValue;
	
	@Column(name = "approved_landing_value")
	private float approvedLandingValue;
	
	@Column(name = "issue_qty")
	private float issueQty;
	
	@Column(name = "issue_qty_value")
	private float issueQtyValue;
	
	@Column(name = "issue_landing_value")
	private float issueLandingValue;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public float getApproveQty() {
		return approveQty;
	}

	public void setApproveQty(float approveQty) {
		this.approveQty = approveQty;
	}

	public float getApprovedQtyValue() {
		return approvedQtyValue;
	}

	public void setApprovedQtyValue(float approvedQtyValue) {
		this.approvedQtyValue = approvedQtyValue;
	}

	public float getApprovedLandingValue() {
		return approvedLandingValue;
	}

	public void setApprovedLandingValue(float approvedLandingValue) {
		this.approvedLandingValue = approvedLandingValue;
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
		return "IssueAndMrnItemWise [itemId=" + itemId + ", itemCode=" + itemCode + ", approveQty=" + approveQty
				+ ", approvedQtyValue=" + approvedQtyValue + ", approvedLandingValue=" + approvedLandingValue
				+ ", issueQty=" + issueQty + ", issueQtyValue=" + issueQtyValue + ", issueLandingValue="
				+ issueLandingValue + "]";
	}
	
	

}
