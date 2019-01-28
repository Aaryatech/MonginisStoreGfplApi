package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_rm_rate_verif")
public class RmRateVerificationList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rm_rate_ver_id")
	private int rmRateVerId;

	@Column(name = "rm_id")
	private int rmId;

	@Column(name = "supp_id")
	private int suppId;

	@Column(name = "rate_date")
	private String rateDate;

	@Column(name = "rate_tax_extra")
	private float rateTaxExtra;
	
	@Column(name = "rate_tax_incl")
	private float rateTaxIncl;
	
	@Column(name = "tax_id")
	private int taxId;
	
	@Column(name = "date1")
	private String date1;
	
	@Column(name = "rate_1_tax_extra")
	private float rate1TaxExtra;
	
	@Column(name = "rate_1_tax_incl")
	private float rate1TaxIncl;
	
	@Column(name = "date2")
	private String date2;
	
	@Column(name = "rate_2_tax_extra")
	private float rate2TaxExtra;
	
	@Column(name = "rate_2_tax_incl")
	private float rate2TaxIncl;
	
	@Column(name = "grp_id")
	private int grpId;

	public int getRmRateVerId() {
		return rmRateVerId;
	}

	public void setRmRateVerId(int rmRateVerId) {
		this.rmRateVerId = rmRateVerId;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public String getRateDate() {
		return rateDate;
	}

	public void setRateDate(String rateDate) {
		this.rateDate = rateDate;
	}

	public float getRateTaxExtra() {
		return rateTaxExtra;
	}

	public void setRateTaxExtra(float rateTaxExtra) {
		this.rateTaxExtra = rateTaxExtra;
	}

	public float getRateTaxIncl() {
		return rateTaxIncl;
	}

	public void setRateTaxIncl(float rateTaxIncl) {
		this.rateTaxIncl = rateTaxIncl;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public float getRate1TaxExtra() {
		return rate1TaxExtra;
	}

	public void setRate1TaxExtra(float rate1TaxExtra) {
		this.rate1TaxExtra = rate1TaxExtra;
	}

	public float getRate1TaxIncl() {
		return rate1TaxIncl;
	}

	public void setRate1TaxIncl(float rate1TaxIncl) {
		this.rate1TaxIncl = rate1TaxIncl;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public float getRate2TaxExtra() {
		return rate2TaxExtra;
	}

	public void setRate2TaxExtra(float rate2TaxExtra) {
		this.rate2TaxExtra = rate2TaxExtra;
	}

	public float getRate2TaxIncl() {
		return rate2TaxIncl;
	}

	public void setRate2TaxIncl(float rate2TaxIncl) {
		this.rate2TaxIncl = rate2TaxIncl;
	}

	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	@Override
	public String toString() {
		return "RmRateVerificationList [rmRateVerId=" + rmRateVerId + ", rmId=" + rmId + ", suppId=" + suppId
				+ ", rateDate=" + rateDate + ", rateTaxExtra=" + rateTaxExtra + ", rateTaxIncl=" + rateTaxIncl
				+ ", taxId=" + taxId + ", date1=" + date1 + ", rate1TaxExtra=" + rate1TaxExtra + ", rate1TaxIncl="
				+ rate1TaxIncl + ", date2=" + date2 + ", rate2TaxExtra=" + rate2TaxExtra + ", rate2TaxIncl="
				+ rate2TaxIncl + ", grpId=" + grpId + "]";
	}
	
	

}
