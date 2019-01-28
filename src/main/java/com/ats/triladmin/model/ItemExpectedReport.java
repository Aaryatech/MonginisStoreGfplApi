package com.ats.triladmin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ItemExpectedReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "po_detail_id")
	private int poDetailId;
	
	@Column(name = "po_id")
	private int poId;

	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_qty")
	private float itemQty;

	@Column(name = "item_uom")
	private String uom;
   
	@Column(name = "sch_date")
	private Date schDate;
	
	@Column(name = "po_no")
	private String poNo;
	
	@Column(name = "po_date")
	private Date poDate;
	
	@Column(name = "vend_id")
	private int vendId;
	 
	@Column(name = "item_code")
	private String itemCode; 
	
	@Column(name = "item_desc")
	private String itemDesc;
	
	@Column(name = "vendor_code")
	private String vendorCode;
	
	@Column(name = "vendor_name")
	private String vendorName;

	public int getPoDetailId() {
		return poDetailId;
	}

	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getItemQty() {
		return itemQty;
	}

	public void setItemQty(float itemQty) {
		this.itemQty = itemQty;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSchDate() {
		return schDate;
	}

	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public int getVendId() {
		return vendId;
	}

	public void setVendId(int vendId) {
		this.vendId = vendId;
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

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Override
	public String toString() {
		return "ItemExpectedReport [poDetailId=" + poDetailId + ", poId=" + poId + ", itemId=" + itemId + ", itemQty="
				+ itemQty + ", uom=" + uom + ", schDate=" + schDate + ", poNo=" + poNo + ", poDate=" + poDate
				+ ", vendId=" + vendId + ", itemCode=" + itemCode + ", itemDesc=" + itemDesc + ", vendorCode="
				+ vendorCode + ", vendorName=" + vendorName + "]";
	}
	 

}
