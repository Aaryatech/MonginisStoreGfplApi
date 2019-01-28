package com.ats.triladmin.model.mrn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_mrn_detail")
public class MrnDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mrnDetailId;
	
	private int mrnId;
	
	private int itemId;
	
	private float indentQty;
	
	private float poQty;
	
	private float mrnQty;
	
	private float approveQty;
	
	private float rejectQty;
	
	private int rejectRemark;
	
	private String batchNo;
	
	private float issueQty;
	
	private float remainingQty;
	
	private int poId;
	
	private String poNo;
	
	private int poDetailId;
	
	private int mrnDetailStatus;
	
	private int delStatus;
	
	private float chalanQty;//added on 13 aug


	public float getChalanQty() {
	return chalanQty;
}

public void setChalanQty(float chalanQty) {
	this.chalanQty = chalanQty;
}
	@Transient
	private float mrnQtyBeforeEdit;
	
	


	public float getMrnQtyBeforeEdit() {
		return mrnQtyBeforeEdit;
	}

	public void setMrnQtyBeforeEdit(float mrnQtyBeforeEdit) {
		this.mrnQtyBeforeEdit = mrnQtyBeforeEdit;
	}

	public int getMrnId() {
		return mrnId;
	}

	public int getItemId() {
		return itemId;
	}

	public float getIndentQty() {
		return indentQty;
	}

	public float getPoQty() {
		return poQty;
	}

	public float getMrnQty() {
		return mrnQty;
	}

	public float getApproveQty() {
		return approveQty;
	}

	public float getRejectQty() {
		return rejectQty;
	}

	public int getRejectRemark() {
		return rejectRemark;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public float getIssueQty() {
		return issueQty;
	}

	public float getRemainingQty() {
		return remainingQty;
	}

	public int getPoId() {
		return poId;
	}

	public String getPoNo() {
		return poNo;
	}

	public int getMrnDetailStatus() {
		return mrnDetailStatus;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setIndentQty(float indentQty) {
		this.indentQty = indentQty;
	}

	public void setPoQty(float poQty) {
		this.poQty = poQty;
	}

	public void setMrnQty(float mrnQty) {
		this.mrnQty = mrnQty;
	}

	public void setApproveQty(float approveQty) {
		this.approveQty = approveQty;
	}

	public void setRejectQty(float rejectQty) {
		this.rejectQty = rejectQty;
	}

	public void setRejectRemark(int rejectRemark) {
		this.rejectRemark = rejectRemark;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public void setIssueQty(float issueQty) {
		this.issueQty = issueQty;
	}

	public void setRemainingQty(float remainingQty) {
		this.remainingQty = remainingQty;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public void setMrnDetailStatus(int mrnDetailStatus) {
		this.mrnDetailStatus = mrnDetailStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getPoDetailId() {
		return poDetailId;
	}

	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
	}


	public int getMrnDetailId() {
		return mrnDetailId;
	}

	public void setMrnDetailId(int mrnDetailId) {
		this.mrnDetailId = mrnDetailId;
	}

	@Override
	public String toString() {
		return "MrnDetail [mrnDetailId=" + mrnDetailId + ", mrnId=" + mrnId + ", itemId=" + itemId + ", indentQty="
				+ indentQty + ", poQty=" + poQty + ", mrnQty=" + mrnQty + ", approveQty=" + approveQty + ", rejectQty="
				+ rejectQty + ", rejectRemark=" + rejectRemark + ", batchNo=" + batchNo + ", issueQty=" + issueQty
				+ ", remainingQty=" + remainingQty + ", poId=" + poId + ", poNo=" + poNo + ", poDetailId=" + poDetailId
				+ ", mrnDetailStatus=" + mrnDetailStatus + ", delStatus=" + delStatus + ", mrnQtyBeforeEdit="
				+ mrnQtyBeforeEdit + "]";
	}


}
