package com.ats.triladmin.model.rejection;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetRejectionMemoDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rej_detail_id")
	private int rejDetailId;

	private int rejectionId;

	private int itemId;

	private String itemCode;

	private float rejectionQty;

	private float memoQty;

	private String mrnNo;

	private Date mrnDate;

	private int status;
	private int isUsed;

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

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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
	public Date getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(Date mrnDate) {
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

	@Override
	public String toString() {
		return "GetRejectionMemoDetail [rejDetailId=" + rejDetailId + ", rejectionId=" + rejectionId + ", itemId="
				+ itemId + ", itemCode=" + itemCode + ", rejectionQty=" + rejectionQty + ", memoQty=" + memoQty
				+ ", mrnNo=" + mrnNo + ", mrnDate=" + mrnDate + ", status=" + status + ", isUsed=" + isUsed + "]";
	}

}
