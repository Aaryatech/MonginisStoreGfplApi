package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_general_grn_detail")
public class GeneralGrnDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_detail_id")
	private int grnDetailId;

	@Column(name = "grn_id")
	private int grnId;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "grn_qty")
	private float grnQty;

	@Column(name = "rate")
	private float rate;
	
	@Column(name = "approve_qty")
	private float approveQty; 
	
	@Column(name = "reject_qty")
	private float rejectQty;
	
	@Column(name = "reject_remark")
	private String rejectRemark;
	
	@Column(name = "mrn_detail_status")
	private int mrnDetailStatus;
	
	@Column(name = "cat_id")
	private int catId;
	
	@Column(name = "batch_no")
	private String batchNo;
	
	@Column(name = "issue_qty")
	private float issueQty;
	
	@Column(name = "remaining_qty")
	private float remainingQty;
	
	@Column(name = "del_status")
	private int delStatus; 
	
	@Column(name = "chalan_qty")
	private float chalanQty;
	
	@Column(name = "grp_id")
	private int grpId;
	
	@Column(name = "general_remark")
	private String generalRemark;

	public int getGrnDetailId() {
		return grnDetailId;
	}

	public void setGrnDetailId(int grnDetailId) {
		this.grnDetailId = grnDetailId;
	}

	public int getGrnId() {
		return grnId;
	}

	public void setGrnId(int grnId) {
		this.grnId = grnId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getGrnQty() {
		return grnQty;
	}

	public void setGrnQty(float grnQty) {
		this.grnQty = grnQty;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getApproveQty() {
		return approveQty;
	}

	public void setApproveQty(float approveQty) {
		this.approveQty = approveQty;
	}

	public float getRejectQty() {
		return rejectQty;
	}

	public void setRejectQty(float rejectQty) {
		this.rejectQty = rejectQty;
	}

	public String getRejectRemark() {
		return rejectRemark;
	}

	public void setRejectRemark(String rejectRemark) {
		this.rejectRemark = rejectRemark;
	}

	public int getMrnDetailStatus() {
		return mrnDetailStatus;
	}

	public void setMrnDetailStatus(int mrnDetailStatus) {
		this.mrnDetailStatus = mrnDetailStatus;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public float getIssueQty() {
		return issueQty;
	}

	public void setIssueQty(float issueQty) {
		this.issueQty = issueQty;
	}

	public float getRemainingQty() {
		return remainingQty;
	}

	public void setRemainingQty(float remainingQty) {
		this.remainingQty = remainingQty;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public float getChalanQty() {
		return chalanQty;
	}

	public void setChalanQty(float chalanQty) {
		this.chalanQty = chalanQty;
	}

	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public String getGeneralRemark() {
		return generalRemark;
	}

	public void setGeneralRemark(String generalRemark) {
		this.generalRemark = generalRemark;
	}

	@Override
	public String toString() {
		return "GeneralGrnDetail [grnDetailId=" + grnDetailId + ", grnId=" + grnId + ", itemId=" + itemId + ", grnQty="
				+ grnQty + ", rate=" + rate + ", approveQty=" + approveQty + ", rejectQty=" + rejectQty
				+ ", rejectRemark=" + rejectRemark + ", mrnDetailStatus=" + mrnDetailStatus + ", catId=" + catId
				+ ", batchNo=" + batchNo + ", issueQty=" + issueQty + ", remainingQty=" + remainingQty + ", delStatus="
				+ delStatus + ", chalanQty=" + chalanQty + ", grpId=" + grpId + ", generalRemark=" + generalRemark
				+ "]";
	}
	
	

}
