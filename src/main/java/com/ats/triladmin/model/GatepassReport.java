package com.ats.triladmin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GatepassReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gpDetailId;
	private int gpId;
	private String gpNo;
	private int gpVendor;
	private Date gpDate;
	private Date gpReturnDate;

	private int gpItemId;
	private float gpQty;
	private int gpNoDays;

	private float gpRemQty;
	private float gpRetQty;

	private int gpStatus;

	private String vendorName;
	private String vendorCode;
	private String itemCode;
	private String itemDesc;

	public int getGpDetailId() {
		return gpDetailId;
	}

	public void setGpDetailId(int gpDetailId) {
		this.gpDetailId = gpDetailId;
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

	public int getGpVendor() {
		return gpVendor;
	}

	public void setGpVendor(int gpVendor) {
		this.gpVendor = gpVendor;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGpDate() {
		return gpDate;
	}

	public void setGpDate(Date gpDate) {
		this.gpDate = gpDate;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGpReturnDate() {
		return gpReturnDate;
	}

	public void setGpReturnDate(Date gpReturnDate) {
		this.gpReturnDate = gpReturnDate;
	}

	public int getGpItemId() {
		return gpItemId;
	}

	public void setGpItemId(int gpItemId) {
		this.gpItemId = gpItemId;
	}

	public float getGpQty() {
		return gpQty;
	}

	public void setGpQty(float gpQty) {
		this.gpQty = gpQty;
	}

	public int getGpNoDays() {
		return gpNoDays;
	}

	public void setGpNoDays(int gpNoDays) {
		this.gpNoDays = gpNoDays;
	}

	public float getGpRemQty() {
		return gpRemQty;
	}

	public void setGpRemQty(float gpRemQty) {
		this.gpRemQty = gpRemQty;
	}

	public float getGpRetQty() {
		return gpRetQty;
	}

	public void setGpRetQty(float gpRetQty) {
		this.gpRetQty = gpRetQty;
	}

	public int getGpStatus() {
		return gpStatus;
	}

	public void setGpStatus(int gpStatus) {
		this.gpStatus = gpStatus;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	@Override
	public String toString() {
		return "GatepassReport [gpDetailId=" + gpDetailId + ", gpId=" + gpId + ", gpNo=" + gpNo + ", gpVendor="
				+ gpVendor + ", gpDate=" + gpDate + ", gpReturnDate=" + gpReturnDate + ", gpItemId=" + gpItemId
				+ ", gpQty=" + gpQty + ", gpNoDays=" + gpNoDays + ", gpRemQty=" + gpRemQty + ", gpRetQty=" + gpRetQty
				+ ", gpStatus=" + gpStatus + ", vendorName=" + vendorName + ", vendorCode=" + vendorCode + ", itemCode="
				+ itemCode + ", itemDesc=" + itemDesc + "]";
	}

}
