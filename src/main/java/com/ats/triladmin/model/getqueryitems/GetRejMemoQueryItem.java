package com.ats.triladmin.model.getqueryitems;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetRejMemoQueryItem {

	@Id
	@Column(name = "rej_detail_id")
	private int rejDetailId;
	
	private int rejNo;
	
	private int rejectionQty;
	
	private int memoQty;
	
	public int getRejectionQty() {
		return rejectionQty;
	}
	public int getMemoQty() {
		return memoQty;
	}
	public void setRejectionQty(int rejectionQty) {
		this.rejectionQty = rejectionQty;
	}
	public void setMemoQty(int memoQty) {
		this.memoQty = memoQty;
	}
	private Date rejectionDate;
	
	private String vendorCode;
	private String vendorName;
	
	private String itemDesc;
	private String itemCode;
	private String itemUom;
	
	
	public int getRejDetailId() {
		return rejDetailId;
	}
	public int getRejNo() {
		return rejNo;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getRejectionDate() {
		return rejectionDate;
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
	public void setRejDetailId(int rejDetailId) {
		this.rejDetailId = rejDetailId;
	}
	public void setRejNo(int rejNo) {
		this.rejNo = rejNo;
	}
	public void setRejectionDate(Date rejectionDate) {
		this.rejectionDate = rejectionDate;
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
		return "GetRejMemoQueryItem [rejDetailId=" + rejDetailId + ", rejNo=" + rejNo + ", rejectionQty=" + rejectionQty
				+ ", memoQty=" + memoQty + ", rejectionDate=" + rejectionDate + ", vendorCode=" + vendorCode
				+ ", vendorName=" + vendorName + ", itemDesc=" + itemDesc + ", itemCode=" + itemCode + ", itemUom="
				+ itemUom + "]";
	}
	
	
}
