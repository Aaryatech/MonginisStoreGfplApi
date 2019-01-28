package com.ats.triladmin.model.report;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ApproveStatusMrnReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mrnId;

	private String mrnNo;

	private Date mrnDate;

	private int mrnType;

	private String vendorId;

	private String gateEntryNo;
	private Date gateEntryDate;

	private String docNo;// chalan no
	private Date docDate;// chalan Date

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

	private String vendorCode;
	private String vendorName;
	private String vendorAdd1;

	@Transient
	List<ApproveStatusMrnReportDetail> ApproveStatusMrnReportDetail;

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

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
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

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
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

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
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

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAdd1() {
		return vendorAdd1;
	}

	public void setVendorAdd1(String vendorAdd1) {
		this.vendorAdd1 = vendorAdd1;
	}

	public List<ApproveStatusMrnReportDetail> getApproveStatusMrnReportDetail() {
		return ApproveStatusMrnReportDetail;
	}

	public void setApproveStatusMrnReportDetail(List<ApproveStatusMrnReportDetail> approveStatusMrnReportDetail) {
		ApproveStatusMrnReportDetail = approveStatusMrnReportDetail;
	}

	@Override
	public String toString() {
		return "ApproveStatusMrnReport [mrnId=" + mrnId + ", mrnNo=" + mrnNo + ", mrnDate=" + mrnDate + ", mrnType="
				+ mrnType + ", vendorId=" + vendorId + ", gateEntryNo=" + gateEntryNo + ", gateEntryDate="
				+ gateEntryDate + ", docNo=" + docNo + ", docDate=" + docDate + ", billNo=" + billNo + ", billDate="
				+ billDate + ", userId=" + userId + ", transport=" + transport + ", lrNo=" + lrNo + ", lrDate=" + lrDate
				+ ", remark1=" + remark1 + ", remark2=" + remark2 + ", mrnStatus=" + mrnStatus + ", delStatus="
				+ delStatus + ", vendorCode=" + vendorCode + ", vendorName=" + vendorName + ", vendorAdd1=" + vendorAdd1
				+ ", ApproveStatusMrnReportDetail=" + ApproveStatusMrnReportDetail + "]";
	}

}
