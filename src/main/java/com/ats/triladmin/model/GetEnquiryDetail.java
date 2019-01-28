package com.ats.triladmin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetEnquiryDetail {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enq_detail_id")
	private int enqDetailId;

	@Column(name = "enq_id")
	private int enqId;

	@Column(name = "enq_detail_date")
	private Date enqDetailDate;

	@Column(name = "ind_id")
	private int indId;

	@Column(name = "vend_id")
	private int vendId;
	
	@Column(name = "vendor_name")
	private String vendorName;
	
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_code")
	private String itemCode;
	
	@Column(name = "enq_qty")
	private float enqQty;
	
	@Column(name = "enq_uom")
	private String enqUom;
	
	@Column(name = "enq_item_desc")
	private String enqItemDesc;
	
	@Column(name = "enq_remark")
	private String enqRemark;
	
	@Column(name = "ind_no")
	private String indNo;
	
	@Column(name = "del_status")
	private int delStatus;

	public int getEnqDetailId() {
		return enqDetailId;
	}

	public void setEnqDetailId(int enqDetailId) {
		this.enqDetailId = enqDetailId;
	}

	public int getEnqId() {
		return enqId;
	}

	public void setEnqId(int enqId) {
		this.enqId = enqId;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getEnqDetailDate() {
		return enqDetailDate;
	}

	public void setEnqDetailDate(Date enqDetailDate) {
		this.enqDetailDate = enqDetailDate;
	}

	public int getIndId() {
		return indId;
	}

	public void setIndId(int indId) {
		this.indId = indId;
	}

	public int getVendId() {
		return vendId;
	}

	public void setVendId(int vendId) {
		this.vendId = vendId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getEnqQty() {
		return enqQty;
	}

	public void setEnqQty(float enqQty) {
		this.enqQty = enqQty;
	}

	public String getEnqUom() {
		return enqUom;
	}

	public void setEnqUom(String enqUom) {
		this.enqUom = enqUom;
	}

	public String getEnqItemDesc() {
		return enqItemDesc;
	}

	public void setEnqItemDesc(String enqItemDesc) {
		this.enqItemDesc = enqItemDesc;
	}

	public String getEnqRemark() {
		return enqRemark;
	}

	public void setEnqRemark(String enqRemark) {
		this.enqRemark = enqRemark;
	}

	public String getIndNo() {
		return indNo;
	}

	public void setIndNo(String indNo) {
		this.indNo = indNo;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Override
	public String toString() {
		return "GetEnquiryDetail [enqDetailId=" + enqDetailId + ", enqId=" + enqId + ", enqDetailDate=" + enqDetailDate
				+ ", indId=" + indId + ", vendId=" + vendId + ", vendorName=" + vendorName + ", itemId=" + itemId
				+ ", itemCode=" + itemCode + ", enqQty=" + enqQty + ", enqUom=" + enqUom + ", enqItemDesc="
				+ enqItemDesc + ", enqRemark=" + enqRemark + ", indNo=" + indNo + ", delStatus=" + delStatus + "]";
	}
	
	

}
