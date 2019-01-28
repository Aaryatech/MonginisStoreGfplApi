package com.ats.triladmin.model.report;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class RejectionReportDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rejDetailId;

	private int rejectionId;

	private int itemId;

	private float rejectionQty;

	private float memoQty;

	private String mrnNo;

	private String mrnDate;

	private int status;
	private int isUsed;

	private String itemCode;
	private String itemDesc;
	private String itemUom;

	public int getRejDetailId() {
		return rejDetailId;
	}

	public void setRejDetailId(int rejDetailId) {
		this.rejDetailId = rejDetailId;
	}

	public int getRejectionId() {
		return rejectionId;
	}

	public void setRejectionId(int rejectionId) {
		this.rejectionId = rejectionId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getRejectionQty() {
		return rejectionQty;
	}

	public void setRejectionQty(float rejectionQty) {
		this.rejectionQty = rejectionQty;
	}

	public float getMemoQty() {
		return memoQty;
	}

	public void setMemoQty(float memoQty) {
		this.memoQty = memoQty;
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public String getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(String mrnDate) {
		this.mrnDate = mrnDate;
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

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}

	@Override
	public String toString() {
		return "RejectionReportDetail [rejDetailId=" + rejDetailId + ", rejectionId=" + rejectionId + ", itemId="
				+ itemId + ", rejectionQty=" + rejectionQty + ", memoQty=" + memoQty + ", mrnNo=" + mrnNo + ", mrnDate="
				+ mrnDate + ", status=" + status + ", isUsed=" + isUsed + ", itemCode=" + itemCode + ", itemDesc="
				+ itemDesc + ", itemUom=" + itemUom + "]";
	}

}
