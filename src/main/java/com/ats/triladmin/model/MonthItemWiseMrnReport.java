package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MonthItemWiseMrnReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "sr")
	private int sr;
	
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_code")
	private String itemCode;
	
	@Column(name = "month_no")
	private int monthNo;

	@Column(name = "month_name")
	private String monthName;
   
	@Column(name = "approve_qty")
	private float approveQty;
	
	@Column(name = "approved_qty_value")
	private float approvedQtyValue;
	
	@Column(name = "approved_landing_value")
	private float ApprovedLandingValue;

	public int getSr() {
		return sr;
	}

	public void setSr(int sr) {
		this.sr = sr;
	}

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
		return ApprovedLandingValue;
	}

	public void setApprovedLandingValue(float approvedLandingValue) {
		ApprovedLandingValue = approvedLandingValue;
	}

	@Override
	public String toString() {
		return "MonthItemWiseMrnReport [sr=" + sr + ", itemId=" + itemId + ", itemCode=" + itemCode + ", monthNo="
				+ monthNo + ", monthName=" + monthName + ", approveQty=" + approveQty + ", approvedQtyValue="
				+ approvedQtyValue + ", ApprovedLandingValue=" + ApprovedLandingValue + "]";
	}
	
	

}
