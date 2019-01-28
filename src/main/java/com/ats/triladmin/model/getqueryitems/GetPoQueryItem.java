package com.ats.triladmin.model.getqueryitems;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetPoQueryItem {
	
	@Id
	@Column(name = "po_detail_id")
	private int poDetailId;
	
	private String poNo;
	
	private Date poDate;
	
	private int poType;
	
	private String vendorCode;
	
	private String vendorName;
	
	private float itemQty;//ie poQty
	
	private  float itemRate;//i.e poRate
	
	private float indedQty;//ie indentQty
	
	private String indNo;//from indent
		
	private Date indDate;//from indent
	
	
	private String itemDesc;
	private String itemCode;
	private String itemUom;

	public String getItemDesc() {
		return itemDesc;
	}

	public String getItemCode() {
		return itemCode;
	}

	public String getItemUom() {
		return itemUom;
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

	public int getPoDetailId() {
		return poDetailId;
	}

	public String getPoNo() {
		return poNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPoDate() {
		return poDate;
	}

	public int getPoType() {
		return poType;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public float getItemQty() {
		return itemQty;
	}

	public float getItemRate() {
		return itemRate;
	}

	public float getIndedQty() {
		return indedQty;
	}

	public String getIndNo() {
		return indNo;
	}

	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public void setPoType(int poType) {
		this.poType = poType;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public void setItemQty(float itemQty) {
		this.itemQty = itemQty;
	}

	public void setItemRate(float itemRate) {
		this.itemRate = itemRate;
	}

	public void setIndedQty(float indedQty) {
		this.indedQty = indedQty;
	}

	public void setIndNo(String indNo) {
		this.indNo = indNo;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIndDate() {
		return indDate;
	}

	public void setIndDate(Date indDate) {
		this.indDate = indDate;
	}

	@Override
	public String toString() {
		return "GetPoQueryItem [poDetailId=" + poDetailId + ", poNo=" + poNo + ", poDate=" + poDate + ", poType="
				+ poType + ", vendorCode=" + vendorCode + ", vendorName=" + vendorName + ", itemQty=" + itemQty
				+ ", itemRate=" + itemRate + ", indedQty=" + indedQty + ", indNo=" + indNo + ", indDate=" + indDate
				+ ", itemDesc=" + itemDesc + ", itemCode=" + itemCode + ", itemUom=" + itemUom + "]";
	}
	

}
