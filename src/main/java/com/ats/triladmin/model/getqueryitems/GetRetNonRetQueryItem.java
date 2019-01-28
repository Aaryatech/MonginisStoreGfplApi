package com.ats.triladmin.model.getqueryitems;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetRetNonRetQueryItem {
	
	@Id
	@Column(name = "gp_detail_id")
	private int gpDetailId;
	
	
	private int gpType;
	
	private String gpNo;
	
	private Date gpDate;
	
	
	private Date gpReturnDate;
	
	private float gpQty;
	
	private int gpStatus;
	
	
	private String reason ;//for remark;
	
	private String vendorCode;
	private String vendorName;
	
	private String itemDesc;
	private String itemCode;
	private String itemUom;
	public int getGpDetailId() {
		return gpDetailId;
	}
	public int getGpType() {
		return gpType;
	}
	public String getGpNo() {
		return gpNo;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGpDate() {
		return gpDate;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGpReturnDate() {
		return gpReturnDate;
	}
	public float getGpQty() {
		return gpQty;
	}
	public int getGpStatus() {
		return gpStatus;
	}
	public String getReason() {
		return reason;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public String getVendorName() {
		return vendorName;
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
	public void setGpDetailId(int gpDetailId) {
		this.gpDetailId = gpDetailId;
	}
	public void setGpType(int gpType) {
		this.gpType = gpType;
	}
	public void setGpNo(String gpNo) {
		this.gpNo = gpNo;
	}
	public void setGpDate(Date gpDate) {
		this.gpDate = gpDate;
	}
	public void setGpReturnDate(Date gpReturnDate) {
		this.gpReturnDate = gpReturnDate;
	}
	public void setGpQty(float gpQty) {
		this.gpQty = gpQty;
	}
	public void setGpStatus(int gpStatus) {
		this.gpStatus = gpStatus;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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
	@Override
	public String toString() {
		return "GetRetNonRetQueryItem [gpDetailId=" + gpDetailId + ", gpType=" + gpType + ", gpNo=" + gpNo + ", gpDate="
				+ gpDate + ", gpReturnDate=" + gpReturnDate + ", gpQty=" + gpQty + ", gpStatus=" + gpStatus
				+ ", reason=" + reason + ", vendorCode=" + vendorCode + ", vendorName=" + vendorName + ", itemDesc="
				+ itemDesc + ", itemCode=" + itemCode + ", itemUom=" + itemUom + "]";
	}
	
	
	
	
	
	
	
	

}
