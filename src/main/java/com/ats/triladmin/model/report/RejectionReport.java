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
public class RejectionReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rejectionId;

	private String rejectionNo;

	private int vendorId;
	private int mrnId;
	private String mrnNo;
	private Date rejectionDate;
	private int dcoId;
	private Date dcoDate;
	private String rejectionRemark;
	private String rejectionRemark1;
	private int status;
	private int isUsed;

	private String vendorName;
	private String vendorCode;
	private String vendorAdd1;

	@Transient
	List<RejectionReportDetail> rejReportDetailList;

	public int getRejectionId() {
		return rejectionId;
	}

	public void setRejectionId(int rejectionId) {
		this.rejectionId = rejectionId;
	}

	public String getRejectionNo() {
		return rejectionNo;
	}

	public void setRejectionNo(String rejectionNo) {
		this.rejectionNo = rejectionNo;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

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
	public Date getRejectionDate() {
		return rejectionDate;
	}

	public void setRejectionDate(Date rejectionDate) {
		this.rejectionDate = rejectionDate;
	}

	public int getDcoId() {
		return dcoId;
	}

	public void setDcoId(int dcoId) {
		this.dcoId = dcoId;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDcoDate() {
		return dcoDate;
	}

	public void setDcoDate(Date dcoDate) {
		this.dcoDate = dcoDate;
	}

	public String getRejectionRemark() {
		return rejectionRemark;
	}

	public void setRejectionRemark(String rejectionRemark) {
		this.rejectionRemark = rejectionRemark;
	}

	public String getRejectionRemark1() {
		return rejectionRemark1;
	}

	public void setRejectionRemark1(String rejectionRemark1) {
		this.rejectionRemark1 = rejectionRemark1;
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

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorAdd1() {
		return vendorAdd1;
	}

	public void setVendorAdd1(String vendorAdd1) {
		this.vendorAdd1 = vendorAdd1;
	}

	public List<RejectionReportDetail> getRejReportDetailList() {
		return rejReportDetailList;
	}

	public void setRejReportDetailList(List<RejectionReportDetail> rejReportDetailList) {
		this.rejReportDetailList = rejReportDetailList;
	}

	@Override
	public String toString() {
		return "RejectionReport [rejectionId=" + rejectionId + ", rejectionNo=" + rejectionNo + ", vendorId=" + vendorId
				+ ", mrnId=" + mrnId + ", mrnNo=" + mrnNo + ", rejectionDate=" + rejectionDate + ", dcoId=" + dcoId
				+ ", dcoDate=" + dcoDate + ", rejectionRemark=" + rejectionRemark + ", rejectionRemark1="
				+ rejectionRemark1 + ", status=" + status + ", isUsed=" + isUsed + ", vendorName=" + vendorName
				+ ", vendorCode=" + vendorCode + ", vendorAdd1=" + vendorAdd1 + ", rejReportDetailList="
				+ rejReportDetailList + "]";
	}

}
