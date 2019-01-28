package com.ats.triladmin.model.mrn;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_mrn_header")
public class MrnHeader {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mrn_id")
	private int mrnId;
	
	private String mrnNo;
	
	private Date mrnDate;
	
	private int mrnType;
	
	private String vendorId;
	
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
	
	
	@Transient
	List<MrnDetail> mrnDetailList;


	public int getMrnId() {
		return mrnId;
	}


	public String getMrnNo() {
		return mrnNo;
	}


	public Date getMrnDate() {
		return mrnDate;
	}


	public int getMrnType() {
		return mrnType;
	}


	public String getVendorId() {
		return vendorId;
	}


	public String getGateEntryNo() {
		return gateEntryNo;
	}


	public Date getGateEntryDate() {
		return gateEntryDate;
	}


	public String getDocNo() {
		return docNo;
	}


	public Date getDocDate() {
		return docDate;
	}


	public String getBillNo() {
		return billNo;
	}


	public Date getBillDate() {
		return billDate;
	}


	public int getUserId() {
		return userId;
	}


	public String getTransport() {
		return transport;
	}


	public String getLrNo() {
		return lrNo;
	}


	public Date getLrDate() {
		return lrDate;
	}


	public String getRemark1() {
		return remark1;
	}


	public String getRemark2() {
		return remark2;
	}


	public int getMrnStatus() {
		return mrnStatus;
	}


	public int getDelStatus() {
		return delStatus;
	}


	public List<MrnDetail> getMrnDetailList() {
		return mrnDetailList;
	}


	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}


	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}


	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}


	public void setMrnType(int mrnType) {
		this.mrnType = mrnType;
	}


	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}


	public void setGateEntryNo(String gateEntryNo) {
		this.gateEntryNo = gateEntryNo;
	}


	public void setGateEntryDate(Date gateEntryDate) {
		this.gateEntryDate = gateEntryDate;
	}


	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}


	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}


	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}


	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public void setTransport(String transport) {
		this.transport = transport;
	}


	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}


	public void setLrDate(Date lrDate) {
		this.lrDate = lrDate;
	}


	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}


	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}


	public void setMrnStatus(int mrnStatus) {
		this.mrnStatus = mrnStatus;
	}


	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}


	public void setMrnDetailList(List<MrnDetail> mrnDetailList) {
		this.mrnDetailList = mrnDetailList;
	}


	@Override
	public String toString() {
		return "MrnHeader [mrnId=" + mrnId + ", mrnNo=" + mrnNo + ", mrnDate=" + mrnDate + ", mrnType=" + mrnType
				+ ", vendorId=" + vendorId + ", gateEntryNo=" + gateEntryNo + ", gateEntryDate=" + gateEntryDate
				+ ", docNo=" + docNo + ", docDate=" + docDate + ", billNo=" + billNo + ", billDate=" + billDate
				+ ", userId=" + userId + ", transport=" + transport + ", lrNo=" + lrNo + ", lrDate=" + lrDate
				+ ", remark1=" + remark1 + ", remark2=" + remark2 + ", mrnStatus=" + mrnStatus + ", delStatus="
				+ delStatus + ", mrnDetailList=" + mrnDetailList + "]";
	}
	

}
