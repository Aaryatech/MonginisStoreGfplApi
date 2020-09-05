package com.ats.triladmin.model.mrn;

import javax.persistence.Entity;
import javax.persistence.Id;

//Sachin 31-08-2020 changed on 03-09-2020
@Entity
public class TempMrnItemDetail {

	@Id
	private int mrnDetailId;

	private int mrnId;

	private int itemId;

	private String itemName;

	private String itemCode;

	private String itemUom; 
	
	private float mrnQty;

	private float approveQty;
	
	private String expDate;
	
	private int detailStatus; //Its header item or detail item 1/0 
	
	private String uuid; //03-09-2020
	
	private String batchNo; //03-09-2020
	

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getMrnDetailId() {
		return mrnDetailId;
	}

	public void setMrnDetailId(int mrnDetailId) {
		this.mrnDetailId = mrnDetailId;
	}

	public int getMrnId() {
		return mrnId;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}

	public float getMrnQty() {
		return mrnQty;
	}

	public void setMrnQty(float mrnQty) {
		this.mrnQty = mrnQty;
	}

	public float getApproveQty() {
		return approveQty;
	}

	public void setApproveQty(float approveQty) {
		this.approveQty = approveQty;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	public int getDetailStatus() {
		return detailStatus;
	}

	public void setDetailStatus(int detailStatus) {
		this.detailStatus = detailStatus;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	@Override
	public String toString() {
		return "TempMrnItemDetail [mrnDetailId=" + mrnDetailId + ", mrnId=" + mrnId + ", itemId=" + itemId
				+ ", itemName=" + itemName + ", itemCode=" + itemCode + ", itemUom=" + itemUom + ", mrnQty=" + mrnQty
				+ ", approveQty=" + approveQty + ", expDate=" + expDate + ", detailStatus=" + detailStatus + ", uuid="
				+ uuid + ", batchNo=" + batchNo + "]";
	}
}
