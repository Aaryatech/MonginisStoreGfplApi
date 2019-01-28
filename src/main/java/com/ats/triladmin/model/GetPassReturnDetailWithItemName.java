package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetPassReturnDetailWithItemName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "return_detail_id")
	private int returnDetailId;
	
	@Column(name = "return_id")
	private int returnId;
	
	@Column(name = "gp_item_id")
	private int gpItemId;

	@Column(name = "gp_qty")
	private float gpQty;
	
	@Column(name = "return_qty")
	private float returnQty;
	
	@Column(name = "rem_qty")
	private float remQty;

	@Column(name = "remark")
	private String remark;
	
	@Column(name = "remark1")
	private String remark1;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "is_used")
	private int isUsed;
	
	@Column(name = "item_code")
	private String itemCode;

	public int getReturnDetailId() {
		return returnDetailId;
	}

	public void setReturnDetailId(int returnDetailId) {
		this.returnDetailId = returnDetailId;
	}

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
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

	public float getReturnQty() {
		return returnQty;
	}

	public void setReturnQty(float returnQty) {
		this.returnQty = returnQty;
	}

	public float getRemQty() {
		return remQty;
	}

	public void setRemQty(float remQty) {
		this.remQty = remQty;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Override
	public String toString() {
		return "GetPassReturnDetailWithItemName [returnDetailId=" + returnDetailId + ", returnId=" + returnId
				+ ", gpItemId=" + gpItemId + ", gpQty=" + gpQty + ", returnQty=" + returnQty + ", remQty=" + remQty
				+ ", remark=" + remark + ", remark1=" + remark1 + ", status=" + status + ", isUsed=" + isUsed
				+ ", itemCode=" + itemCode + "]";
	}
	
	
	

}
