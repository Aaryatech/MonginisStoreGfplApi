package com.ats.triladmin.model.mrn;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class VendorItemPurchaseReport {
@Id
private String id;

	private int itemId;
	private String itemDesc;
	private String mrnNo;
	private Date mrnDate;
	private String billNo;
	private int approveQty;
	private float basicValue;
	private float taxValue;
	private float landingCost;
	private String vendorName;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getMrnNo() {
		return mrnNo;
	}
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getMrnDate() {
		return mrnDate;
	}
	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}
	public int getApproveQty() {
		return approveQty;
	}
	public void setApproveQty(int approveQty) {
		this.approveQty = approveQty;
	}
	public float getBasicValue() {
		return basicValue;
	}
	public void setBasicValue(float basicValue) {
		this.basicValue = basicValue;
	}
	public float getTaxValue() {
		return taxValue;
	}
	public void setTaxValue(float taxValue) {
		this.taxValue = taxValue;
	}
	public float getLandingCost() {
		return landingCost;
	}
	public void setLandingCost(float landingCost) {
		this.landingCost = landingCost;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "VendorItemPurchaseReport [id=" + id + ", itemId=" + itemId + ", itemDesc=" + itemDesc + ", mrnNo="
				+ mrnNo + ", mrnDate=" + mrnDate + ", billNo=" + billNo + ", approveQty=" + approveQty + ", basicValue="
				+ basicValue + ", taxValue=" + taxValue + ", landingCost=" + landingCost + ", vendorName=" + vendorName
				+ "]";
	}
	
	
	
	
}
