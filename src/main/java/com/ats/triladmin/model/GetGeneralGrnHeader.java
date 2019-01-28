package com.ats.triladmin.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetGeneralGrnHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_id")
	private int grnId;

	@Column(name = "grn_no")
	private String grnNo;

	@Column(name = "grn_type")
	private int grnType;

	@Column(name = "grn_date")
	private Date grnDate;

	@Column(name = "vendor_id")
	private int vendorId;
	
	@Column(name = "gate_entry_no")
	private String gateEntryNo;
	
	@Column(name = "gate_entry_date")
	private Date gateEntryDate;
	
	@Column(name = "doc_no")
	private String docNo;
	
	@Column(name = "doc_date")
	private Date docDate;
	
	@Column(name = "bill_no")
	private String billNo;
	
	@Column(name = "bill_date")
	private Date billDate;
	
	@Column(name = "lr_no")
	private String lrNo;
	
	@Column(name = "lr_date")
	private Date lrDate;
	
	@Column(name = "cat_id")
	private int catId;
	
	@Column(name = "remark1")
	private String remark1;
	
	@Column(name = "remark2")
	private String remark2;
	
	@Column(name = "transport")
	private String transport;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "mrn_status")
	private int mrnStatus;
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "vendor_name")
	private String vendorName;
	
	@Column(name = "cat_desc")
	private String catDesc;
	
	@Transient
	List<GetGeneralGrnDetail> getGeneralGrnDetailList;

	public int getGrnId() {
		return grnId;
	}

	public void setGrnId(int grnId) {
		this.grnId = grnId;
	}

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}

	public int getGrnType() {
		return grnType;
	}

	public void setGrnType(int grnType) {
		this.grnType = grnType;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGrnDate() {
		return grnDate;
	}

	public void setGrnDate(Date grnDate) {
		this.grnDate = grnDate;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getGateEntryNo() {
		return gateEntryNo;
	}

	public void setGateEntryNo(String gateEntryNo) {
		this.gateEntryNo = gateEntryNo;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
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
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
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
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getLrDate() {
		return lrDate;
	}

	public void setLrDate(Date lrDate) {
		this.lrDate = lrDate;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
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

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public List<GetGeneralGrnDetail> getGetGeneralGrnDetailList() {
		return getGeneralGrnDetailList;
	}

	public void setGetGeneralGrnDetailList(List<GetGeneralGrnDetail> getGeneralGrnDetailList) {
		this.getGeneralGrnDetailList = getGeneralGrnDetailList;
	}

	@Override
	public String toString() {
		return "GetGeneralGrnHeader [grnId=" + grnId + ", grnNo=" + grnNo + ", grnType=" + grnType + ", grnDate="
				+ grnDate + ", vendorId=" + vendorId + ", gateEntryNo=" + gateEntryNo + ", gateEntryDate="
				+ gateEntryDate + ", docNo=" + docNo + ", docDate=" + docDate + ", billNo=" + billNo + ", billDate="
				+ billDate + ", lrNo=" + lrNo + ", lrDate=" + lrDate + ", catId=" + catId + ", remark1=" + remark1
				+ ", remark2=" + remark2 + ", transport=" + transport + ", userId=" + userId + ", mrnStatus="
				+ mrnStatus + ", delStatus=" + delStatus + ", vendorName=" + vendorName + ", catDesc=" + catDesc
				+ ", getGeneralGrnDetailList=" + getGeneralGrnDetailList + "]";
	}
	
	

}
