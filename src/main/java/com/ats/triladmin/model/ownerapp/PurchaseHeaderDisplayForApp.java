package com.ats.triladmin.model.ownerapp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PurchaseHeaderDisplayForApp {

	@Id
	private int mrnId;
	private int poId;
	private Date mrnDate;
	private String vendorId;
	private String vendorName;
	private String billNo;
	private String mrnNo;
	private String poNo;
	private int mrnStatus;
	private float total_taxable_amt;
	private float total_tax_amt;
	private float grandTotal;
	private float total_disc_value;
	private float total_other_charges_before;
	private float total_other_charges_after;

	public int getMrnId() {
		return mrnId;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public Date getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public int getMrnStatus() {
		return mrnStatus;
	}

	public void setMrnStatus(int mrnStatus) {
		this.mrnStatus = mrnStatus;
	}

	public float getTotal_taxable_amt() {
		return total_taxable_amt;
	}

	public void setTotal_taxable_amt(float total_taxable_amt) {
		this.total_taxable_amt = total_taxable_amt;
	}

	public float getTotal_tax_amt() {
		return total_tax_amt;
	}

	public void setTotal_tax_amt(float total_tax_amt) {
		this.total_tax_amt = total_tax_amt;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public float getTotal_disc_value() {
		return total_disc_value;
	}

	public void setTotal_disc_value(float total_disc_value) {
		this.total_disc_value = total_disc_value;
	}

	public float getTotal_other_charges_before() {
		return total_other_charges_before;
	}

	public void setTotal_other_charges_before(float total_other_charges_before) {
		this.total_other_charges_before = total_other_charges_before;
	}

	public float getTotal_other_charges_after() {
		return total_other_charges_after;
	}

	public void setTotal_other_charges_after(float total_other_charges_after) {
		this.total_other_charges_after = total_other_charges_after;
	}

	@Override
	public String toString() {
		return "PurchaseHeaderDisplayForApp [mrnId=" + mrnId + ", poId=" + poId + ", mrnDate=" + mrnDate + ", vendorId="
				+ vendorId + ", vendorName=" + vendorName + ", billNo=" + billNo + ", mrnNo=" + mrnNo + ", poNo=" + poNo
				+ ", mrnStatus=" + mrnStatus + ", total_taxable_amt=" + total_taxable_amt + ", total_tax_amt="
				+ total_tax_amt + ", grandTotal=" + grandTotal + ", total_disc_value=" + total_disc_value
				+ ", total_other_charges_before=" + total_other_charges_before + ", total_other_charges_after="
				+ total_other_charges_after + "]";
	}

}
