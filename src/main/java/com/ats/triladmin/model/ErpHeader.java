package com.ats.triladmin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ErpHeader {
	
	@Id
	private int mrnId; 
	@Column(name="mrn_date")
	private Date mrnDate; 
	@Column(name="mrn_no")
	private String MrnNo; 
 
	@Column(name="bill_no")
	private String BillNo; 
	@Column(name="bill_date")
	private Date Billdate; 
	@Column(name="mrn_status")
	private int MrnStatus;
	@Column(name="vendor_id")
	private int vendorId; 
	@Column(name="vendor_name")
	private String vendorName; 
	
	
	
	public int getMrnId() {
		return mrnId;
	}
	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getMrnDate() {
		return mrnDate;
	}
	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}
	public String getMrnNo() {
		return MrnNo;
	}
	public void setMrnNo(String mrnNo) {
		MrnNo = mrnNo;
	}
	
	public String getBillNo() {
		return BillNo;
	}
	public void setBillNo(String billNo) {
		BillNo = billNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBilldate() {
		return Billdate;
	}
	public void setBilldate(Date billdate) {
		Billdate = billdate;
	}
	public int getMrnStatus() {
		return MrnStatus;
	}
	public void setMrnStatus(int mrnStatus) {
		MrnStatus = mrnStatus;
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
	
	
	@Override
	public String toString() {
		return "ERPHeader [mrnId=" + mrnId + ", mrnDate=" + mrnDate + ", MrnNo=" + MrnNo +" BillNo=" + BillNo + ", Billdate=" + Billdate + ", MrnStatus=" + MrnStatus + ", vendorid="
				+ vendorId + ", vendorName=" + vendorName + "]";
	}

}
