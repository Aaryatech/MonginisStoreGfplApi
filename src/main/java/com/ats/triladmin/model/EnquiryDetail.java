package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enq_detail")
public class EnquiryDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enq_detail_id")
	private int enqDetailId;

	@Column(name = "enq_id")
	private int enqId;

	@Column(name = "enq_detail_date")
	private String enqDetailDate;

	@Column(name = "ind_id")
	private int indId;

	@Column(name = "vend_id")
	private int vendId;
	
	@Column(name = "item_id")
	private int itemId;
	
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

	public String getEnqDetailDate() {
		return enqDetailDate;
	}

	public void setEnqDetailDate(String enqDetailDate) {
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

	@Override
	public String toString() {
		return "EnquiryDetail [enqDetailId=" + enqDetailId + ", enqId=" + enqId + ", enqDetailDate=" + enqDetailDate
				+ ", indId=" + indId + ", vendId=" + vendId + ", itemId=" + itemId + ", enqQty=" + enqQty + ", enqUom="
				+ enqUom + ", enqItemDesc=" + enqItemDesc + ", enqRemark=" + enqRemark + ", indNo=" + indNo
				+ ", delStatus=" + delStatus + "]";
	}
	
	

}
