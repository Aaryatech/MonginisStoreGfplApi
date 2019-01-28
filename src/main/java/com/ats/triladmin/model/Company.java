package com.ats.triladmin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "m_company")
public class Company {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "com_id")
	private int comId;
	
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "office_add")
	private String officeAdd;

	@Column(name = "factory_add")
	private String factoryAdd;

	@Column(name = "other_address")
	private String otherAddress;
	
	@Column(name = "other_address2")
	private String otherAddress2;
	
	@Column(name = "office_phone_number")
	private String officePhoneNumber;
	
	@Column(name = "office_fax_number")
	private String officeFaxNumber; 
	
	@Column(name = "factory_phone_number")
	private String factoryPhoneNumber;

	@Column(name = "factory_fax_number")
	private String factoryFaxNumber;

	@Column(name = "other_phone_number")
	private String otherPhoneNumber;

	@Column(name = "other_fax_number")
	private String otherFaxNumber;
	
	@Column(name = "sale_email")
	private String saleEmail;
	
	@Column(name = "corporate_email")
	private String corporateEmail;
	
	@Column(name = "purchase_email")
	private String purchaseEmail;
	
	@Column(name = "cin_number")
	private String cinNumber;
	
	@Column(name = "gst_number")
	private String gstNumber;
	
	@Column(name = "pan_number")
	private String panNumber; 
	
	@Column(name = "food_licence")
	private String foodLicence;

	@Column(name = "drug_licence")
	private String drugLicence;

	@Column(name = "company_logo")
	private String companyLogo;

	@Column(name = "from_date")
	private Date fromDate;
	
	@Column(name = "to_date")
	private Date toDate;

	public int getComId() {
		return comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOfficeAdd() {
		return officeAdd;
	}

	public void setOfficeAdd(String officeAdd) {
		this.officeAdd = officeAdd;
	}

	public String getFactoryAdd() {
		return factoryAdd;
	}

	public void setFactoryAdd(String factoryAdd) {
		this.factoryAdd = factoryAdd;
	}

	public String getOtherAddress() {
		return otherAddress;
	}

	public void setOtherAddress(String otherAddress) {
		this.otherAddress = otherAddress;
	}

	public String getOtherAddress2() {
		return otherAddress2;
	}

	public void setOtherAddress2(String otherAddress2) {
		this.otherAddress2 = otherAddress2;
	}

	public String getOfficePhoneNumber() {
		return officePhoneNumber;
	}

	public void setOfficePhoneNumber(String officePhoneNumber) {
		this.officePhoneNumber = officePhoneNumber;
	}

	public String getOfficeFaxNumber() {
		return officeFaxNumber;
	}

	public void setOfficeFaxNumber(String officeFaxNumber) {
		this.officeFaxNumber = officeFaxNumber;
	}

	public String getFactoryPhoneNumber() {
		return factoryPhoneNumber;
	}

	public void setFactoryPhoneNumber(String factoryPhoneNumber) {
		this.factoryPhoneNumber = factoryPhoneNumber;
	}

	public String getFactoryFaxNumber() {
		return factoryFaxNumber;
	}

	public void setFactoryFaxNumber(String factoryFaxNumber) {
		this.factoryFaxNumber = factoryFaxNumber;
	}

	public String getOtherPhoneNumber() {
		return otherPhoneNumber;
	}

	public void setOtherPhoneNumber(String otherPhoneNumber) {
		this.otherPhoneNumber = otherPhoneNumber;
	}

	public String getOtherFaxNumber() {
		return otherFaxNumber;
	}

	public void setOtherFaxNumber(String otherFaxNumber) {
		this.otherFaxNumber = otherFaxNumber;
	}

	public String getSaleEmail() {
		return saleEmail;
	}

	public void setSaleEmail(String saleEmail) {
		this.saleEmail = saleEmail;
	}

	public String getCorporateEmail() {
		return corporateEmail;
	}

	public void setCorporateEmail(String corporateEmail) {
		this.corporateEmail = corporateEmail;
	}

	public String getPurchaseEmail() {
		return purchaseEmail;
	}

	public void setPurchaseEmail(String purchaseEmail) {
		this.purchaseEmail = purchaseEmail;
	}

	public String getCinNumber() {
		return cinNumber;
	}

	public void setCinNumber(String cinNumber) {
		this.cinNumber = cinNumber;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getFoodLicence() {
		return foodLicence;
	}

	public void setFoodLicence(String foodLicence) {
		this.foodLicence = foodLicence;
	}

	public String getDrugLicence() {
		return drugLicence;
	}

	public void setDrugLicence(String drugLicence) {
		this.drugLicence = drugLicence;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "Company [comId=" + comId + ", companyName=" + companyName + ", officeAdd=" + officeAdd + ", factoryAdd="
				+ factoryAdd + ", otherAddress=" + otherAddress + ", otherAddress2=" + otherAddress2
				+ ", officePhoneNumber=" + officePhoneNumber + ", officeFaxNumber=" + officeFaxNumber
				+ ", factoryPhoneNumber=" + factoryPhoneNumber + ", factoryFaxNumber=" + factoryFaxNumber
				+ ", otherPhoneNumber=" + otherPhoneNumber + ", otherFaxNumber=" + otherFaxNumber + ", saleEmail="
				+ saleEmail + ", corporateEmail=" + corporateEmail + ", purchaseEmail=" + purchaseEmail + ", cinNumber="
				+ cinNumber + ", gstNumber=" + gstNumber + ", panNumber=" + panNumber + ", foodLicence=" + foodLicence
				+ ", drugLicence=" + drugLicence + ", companyLogo=" + companyLogo + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}
	
	
	

}
