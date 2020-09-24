package com.ats.triladmin.model.mrn;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetMrnHeaderWithAmt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mrn_id")
	private int mrnId;
	
	private String mrnNo;
	
	private Date mrnDate;
	
	private int mrnType;
	
	private int vendorId;
	
	private String vendorName;
	
	private String gateEntryNo;
	
	private Date gateEntryDate;
	
	private String docNo;//chalan no
	
	private Date docDate;//chalan Date
	
	private String billNo;
	
	private Date billDate;

	private int userId;
	
	private String transport;
	
	private String lrNo;
	
	private Date lrDate;
	
	private String remark1;
	
	private String remark2;
	
	private int mrnStatus;
	
	private int delStatus;
	
	private float total;

	public int getMrnId() {
		return mrnId;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}

	public int getMrnType() {
		return mrnType;
	}

	public void setMrnType(int mrnType) {
		this.mrnType = mrnType;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getGateEntryNo() {
		return gateEntryNo;
	}

	public void setGateEntryNo(String gateEntryNo) {
		this.gateEntryNo = gateEntryNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGateEntryDate() {
		return gateEntryDate;
	}

	public void setGateEntryDate(Date gateEntryDate) {
		this.gateEntryDate = gateEntryDate;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getLrDate() {
		return lrDate;
	}

	public void setLrDate(Date lrDate) {
		this.lrDate = lrDate;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public int getMrnStatus() {
		return mrnStatus;
	}

	public void setMrnStatus(int mrnStatus) {
		this.mrnStatus = mrnStatus;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "GetMrnHeaderWithAmt [mrnId=" + mrnId + ", mrnNo=" + mrnNo + ", mrnDate=" + mrnDate + ", mrnType="
				+ mrnType + ", vendorId=" + vendorId + ", vendorName=" + vendorName + ", gateEntryNo=" + gateEntryNo
				+ ", gateEntryDate=" + gateEntryDate + ", docNo=" + docNo + ", docDate=" + docDate + ", billNo="
				+ billNo + ", billDate=" + billDate + ", userId=" + userId + ", transport=" + transport + ", lrNo="
				+ lrNo + ", lrDate=" + lrDate + ", remark1=" + remark1 + ", remark2=" + remark2 + ", mrnStatus="
				+ mrnStatus + ", delStatus=" + delStatus + ", total=" + total + "]";
	}
	
	

}
