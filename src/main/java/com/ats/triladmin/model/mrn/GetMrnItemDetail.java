package com.ats.triladmin.model.mrn;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetMrnItemDetail {


	@Id
	private int mrnDetailId;
	
	private String batchNo;
	
	private String itemDesc;
	
	private String itemUom;
	
	private float remainingQty;
	
	private String expDate; //

	

	
	
	
	
	
	
	public int getMrnDetailId() {
		return mrnDetailId;
	}

	public void setMrnDetailId(int mrnDetailId) {
		this.mrnDetailId = mrnDetailId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom2(String itemUom2) {
		this.itemUom = itemUom2;
	}

	public float getRemainingQty() {
		return remainingQty;
	}

	public void setRemainingQty(float remainingQty) {
		this.remainingQty = remainingQty;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "GetMrnItemDetail [mrnDetailId=" + mrnDetailId + ", batchNo=" + batchNo + ", itemDesc=" + itemDesc
				+ ", itemUom=" + itemUom + ", remainingQty=" + remainingQty + ", expDate=" + expDate + "]";
	}


	
	
	
	
	
}
