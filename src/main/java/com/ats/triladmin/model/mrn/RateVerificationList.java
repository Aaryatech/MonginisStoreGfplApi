package com.ats.triladmin.model.mrn;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RateVerificationList {
@Id
	private int rmId;
	private int rmRateVerId;
	private int suppId;
	private String itemDesc;
	public int getRmId() {
		return rmId;
	}
	public void setRmId(int rmId) {
		this.rmId = rmId;
	}
	
	public int getSuppId() {
		return suppId;
	}
	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public int getRmRateVerId() {
		return rmRateVerId;
	}
	public void setRmRateVerId(int rmRateVerId) {
		this.rmRateVerId = rmRateVerId;
	}
	@Override
	public String toString() {
		return "RateVerificationList [rmId=" + rmId + ", rmRateVerId=" + rmRateVerId + ", suppId=" + suppId
				+ ", itemDesc=" + itemDesc + "]";
	}
	
}
