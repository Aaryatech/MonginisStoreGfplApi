package com.ats.triladmin.model;
 
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
 
@Entity
@Table(name = "t_general_grn_header")
public class GeneralGrnHeader {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_id")
	private int grnId;

	@Column(name = "grn_no")
	private String grnNo;

	@Column(name = "grn_type")
	private int grnType;

	@Column(name = "grn_date")
	private String grnDate;

	@Column(name = "vendor_id")
	private int vendorId;
	
	@Column(name = "gate_entry_no")
	private String gateEntryNo;
	
	@Column(name = "gate_entry_date")
	private String gateEntryDate;
	
	@Column(name = "doc_no")
	private String docNo;
	
	@Column(name = "doc_date")
	private String docDate;
	
	@Column(name = "bill_no")
	private String billNo;
	
	@Column(name = "bill_date")
	private String billDate;
	
	@Column(name = "lr_no")
	private String lrNo;
	
	@Column(name = "lr_date")
	private String lrDate;
	
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
	
	@Transient
	List<GeneralGrnDetail> generalGrnDetailList;

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

	public String getGrnDate() {
		return grnDate;
	}

	public void setGrnDate(String grnDate) {
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

	public String getGateEntryDate() {
		return gateEntryDate;
	}

	public void setGateEntryDate(String gateEntryDate) {
		this.gateEntryDate = gateEntryDate;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getDocDate() {
		return docDate;
	}

	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}

	public String getLrDate() {
		return lrDate;
	}

	public void setLrDate(String lrDate) {
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

	public List<GeneralGrnDetail> getGeneralGrnDetailList() {
		return generalGrnDetailList;
	}

	public void setGeneralGrnDetailList(List<GeneralGrnDetail> generalGrnDetailList) {
		this.generalGrnDetailList = generalGrnDetailList;
	}

	@Override
	public String toString() {
		return "GeneralGrnHeader [grnId=" + grnId + ", grnNo=" + grnNo + ", grnType=" + grnType + ", grnDate=" + grnDate
				+ ", vendorId=" + vendorId + ", gateEntryNo=" + gateEntryNo + ", gateEntryDate=" + gateEntryDate
				+ ", docNo=" + docNo + ", docDate=" + docDate + ", billNo=" + billNo + ", billDate=" + billDate
				+ ", lrNo=" + lrNo + ", lrDate=" + lrDate + ", catId=" + catId + ", remark1=" + remark1 + ", remark2="
				+ remark2 + ", transport=" + transport + ", userId=" + userId + ", mrnStatus=" + mrnStatus
				+ ", delStatus=" + delStatus + ", generalGrnDetailList=" + generalGrnDetailList + "]";
	}
	
	

}
