package com.ats.triladmin.model.report;

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
public class POReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "po_id")
	private int poId;

	@Column(name = "po_type")
	private int poType;

	@Column(name = "po_no")
	private String poNo;

	@Column(name = "po_date")
	private Date poDate;

	@Column(name = "vend_id")
	private int vendId;

	@Column(name = "vend_quation")
	private String vendQuation;

	@Column(name = "vend_quation_date")
	private Date vendQuationDate;

	@Column(name = "po_basic_value")
	private float poBasicValue;

	@Column(name = "disc_value")
	private float discValue;

	@Column(name = "po_tax_id")
	private int poTaxId;

	@Column(name = "po_tax_per")
	private float poTaxPer;

	@Column(name = "po_tax_value")
	private float poTaxValue;

	@Column(name = "po_pack_per")
	private float poPackPer;

	@Column(name = "po_pack_val")
	private float poPackVal;

	@Column(name = "po_pack_remark")
	private String poPackRemark;

	@Column(name = "po_insu_per")
	private float poInsuPer;

	@Column(name = "po_insu_val")
	private float poInsuVal;

	@Column(name = "po_insu_remark")
	private String poInsuRemark;

	@Column(name = "po_frt_per")
	private float poFrtPer;

	@Column(name = "po_frt_val")
	private float poFrtVal;

	@Column(name = "po_frt_remark")
	private String poFrtRemark;

	@Column(name = "other_charge_before")
	private float otherChargeBefore;

	@Column(name = "other_charge_before_remark")
	private String otherChargeBeforeRemark;

	@Column(name = "other_charge_after")
	private float otherChargeAfter;

	@Column(name = "other_charge_after_remark")
	private String otherChargeAfterRemark;

	@Column(name = "total_value")
	private float totalValue;

	@Column(name = "delivery_id")
	private int deliveryId;

	@Column(name = "dispatch_id")
	private int dispatchId;

	@Column(name = "payment_term_id")
	private int paymentTermId;

	@Column(name = "po_remark")
	private String poRemark;

	@Column(name = "po_status")
	private int poStatus;

	@Column(name = "prn_status")
	private int prnStatus;

	@Column(name = "prn_copies")
	private int prnCopies;

	@Column(name = "ind_id")
	private int indId;

	@Column(name = "ind_no")
	private String indNo;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "approv_status")
	private int approvStatus;

	private String vendorCode;
	private String vendorName;
	private String vendorAdd1;
	private String taxDesc;
	private String deliveryDesc;
	private String dispModeDesc;
	private String pymtDesc;

	private String vendorGstNo;
	
	@Column(name = "ind_m_date")
	private Date indDate;

	@Transient
	List<POReportDetail> pOReportDetailList;

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public int getPoType() {
		return poType;
	}

	public void setPoType(int poType) {
		this.poType = poType;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public int getVendId() {
		return vendId;
	}

	public void setVendId(int vendId) {
		this.vendId = vendId;
	}

	public String getVendQuation() {
		return vendQuation;
	}

	public void setVendQuation(String vendQuation) {
		this.vendQuation = vendQuation;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getVendQuationDate() {
		return vendQuationDate;
	}

	public void setVendQuationDate(Date vendQuationDate) {
		this.vendQuationDate = vendQuationDate;
	}

	public float getPoBasicValue() {
		return poBasicValue;
	}

	public void setPoBasicValue(float poBasicValue) {
		this.poBasicValue = poBasicValue;
	}

	public float getDiscValue() {
		return discValue;
	}

	public void setDiscValue(float discValue) {
		this.discValue = discValue;
	}

	public int getPoTaxId() {
		return poTaxId;
	}

	public void setPoTaxId(int poTaxId) {
		this.poTaxId = poTaxId;
	}

	public float getPoTaxPer() {
		return poTaxPer;
	}

	public void setPoTaxPer(float poTaxPer) {
		this.poTaxPer = poTaxPer;
	}

	public float getPoTaxValue() {
		return poTaxValue;
	}

	public void setPoTaxValue(float poTaxValue) {
		this.poTaxValue = poTaxValue;
	}

	public float getPoPackPer() {
		return poPackPer;
	}

	public void setPoPackPer(float poPackPer) {
		this.poPackPer = poPackPer;
	}

	public float getPoPackVal() {
		return poPackVal;
	}

	public void setPoPackVal(float poPackVal) {
		this.poPackVal = poPackVal;
	}

	public String getPoPackRemark() {
		return poPackRemark;
	}

	public void setPoPackRemark(String poPackRemark) {
		this.poPackRemark = poPackRemark;
	}

	public float getPoInsuPer() {
		return poInsuPer;
	}

	public void setPoInsuPer(float poInsuPer) {
		this.poInsuPer = poInsuPer;
	}

	public float getPoInsuVal() {
		return poInsuVal;
	}

	public void setPoInsuVal(float poInsuVal) {
		this.poInsuVal = poInsuVal;
	}

	public String getPoInsuRemark() {
		return poInsuRemark;
	}

	public void setPoInsuRemark(String poInsuRemark) {
		this.poInsuRemark = poInsuRemark;
	}

	public float getPoFrtPer() {
		return poFrtPer;
	}

	public void setPoFrtPer(float poFrtPer) {
		this.poFrtPer = poFrtPer;
	}

	public float getPoFrtVal() {
		return poFrtVal;
	}

	public void setPoFrtVal(float poFrtVal) {
		this.poFrtVal = poFrtVal;
	}

	public String getPoFrtRemark() {
		return poFrtRemark;
	}

	public void setPoFrtRemark(String poFrtRemark) {
		this.poFrtRemark = poFrtRemark;
	}

	public float getOtherChargeBefore() {
		return otherChargeBefore;
	}

	public void setOtherChargeBefore(float otherChargeBefore) {
		this.otherChargeBefore = otherChargeBefore;
	}

	public String getOtherChargeBeforeRemark() {
		return otherChargeBeforeRemark;
	}

	public void setOtherChargeBeforeRemark(String otherChargeBeforeRemark) {
		this.otherChargeBeforeRemark = otherChargeBeforeRemark;
	}

	public float getOtherChargeAfter() {
		return otherChargeAfter;
	}

	public void setOtherChargeAfter(float otherChargeAfter) {
		this.otherChargeAfter = otherChargeAfter;
	}

	public String getOtherChargeAfterRemark() {
		return otherChargeAfterRemark;
	}

	public void setOtherChargeAfterRemark(String otherChargeAfterRemark) {
		this.otherChargeAfterRemark = otherChargeAfterRemark;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public int getDispatchId() {
		return dispatchId;
	}

	public void setDispatchId(int dispatchId) {
		this.dispatchId = dispatchId;
	}

	public int getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(int paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getPoRemark() {
		return poRemark;
	}

	public void setPoRemark(String poRemark) {
		this.poRemark = poRemark;
	}

	public int getPoStatus() {
		return poStatus;
	}

	public void setPoStatus(int poStatus) {
		this.poStatus = poStatus;
	}

	public int getPrnStatus() {
		return prnStatus;
	}

	public void setPrnStatus(int prnStatus) {
		this.prnStatus = prnStatus;
	}

	public int getPrnCopies() {
		return prnCopies;
	}

	public void setPrnCopies(int prnCopies) {
		this.prnCopies = prnCopies;
	}

	public int getIndId() {
		return indId;
	}

	public void setIndId(int indId) {
		this.indId = indId;
	}

	public String getIndNo() {
		return indNo;
	}

	public void setIndNo(String indNo) {
		this.indNo = indNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getApprovStatus() {
		return approvStatus;
	}

	public void setApprovStatus(int approvStatus) {
		this.approvStatus = approvStatus;
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

	public String getTaxDesc() {
		return taxDesc;
	}

	public void setTaxDesc(String taxDesc) {
		this.taxDesc = taxDesc;
	}

	public String getDeliveryDesc() {
		return deliveryDesc;
	}

	public void setDeliveryDesc(String deliveryDesc) {
		this.deliveryDesc = deliveryDesc;
	}

	public String getDispModeDesc() {
		return dispModeDesc;
	}

	public void setDispModeDesc(String dispModeDesc) {
		this.dispModeDesc = dispModeDesc;
	}

	public String getPymtDesc() {
		return pymtDesc;
	}

	public void setPymtDesc(String pymtDesc) {
		this.pymtDesc = pymtDesc;
	}

	public List<POReportDetail> getpOReportDetailList() {
		return pOReportDetailList;
	}

	public void setpOReportDetailList(List<POReportDetail> pOReportDetailList) {
		this.pOReportDetailList = pOReportDetailList;
	}

	public String getVendorGstNo() {
		return vendorGstNo;
	}

	public void setVendorGstNo(String vendorGstNo) {
		this.vendorGstNo = vendorGstNo;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIndDate() {
		return indDate;
	}

	public void setIndDate(Date indDate) {
		this.indDate = indDate;
	}

	@Override
	public String toString() {
		return "POReport [poId=" + poId + ", poType=" + poType + ", poNo=" + poNo + ", poDate=" + poDate + ", vendId="
				+ vendId + ", vendQuation=" + vendQuation + ", vendQuationDate=" + vendQuationDate + ", poBasicValue="
				+ poBasicValue + ", discValue=" + discValue + ", poTaxId=" + poTaxId + ", poTaxPer=" + poTaxPer
				+ ", poTaxValue=" + poTaxValue + ", poPackPer=" + poPackPer + ", poPackVal=" + poPackVal
				+ ", poPackRemark=" + poPackRemark + ", poInsuPer=" + poInsuPer + ", poInsuVal=" + poInsuVal
				+ ", poInsuRemark=" + poInsuRemark + ", poFrtPer=" + poFrtPer + ", poFrtVal=" + poFrtVal
				+ ", poFrtRemark=" + poFrtRemark + ", otherChargeBefore=" + otherChargeBefore
				+ ", otherChargeBeforeRemark=" + otherChargeBeforeRemark + ", otherChargeAfter=" + otherChargeAfter
				+ ", otherChargeAfterRemark=" + otherChargeAfterRemark + ", totalValue=" + totalValue + ", deliveryId="
				+ deliveryId + ", dispatchId=" + dispatchId + ", paymentTermId=" + paymentTermId + ", poRemark="
				+ poRemark + ", poStatus=" + poStatus + ", prnStatus=" + prnStatus + ", prnCopies=" + prnCopies
				+ ", indId=" + indId + ", indNo=" + indNo + ", userId=" + userId + ", delStatus=" + delStatus
				+ ", approvStatus=" + approvStatus + ", vendorCode=" + vendorCode + ", vendorName=" + vendorName
				+ ", vendorAdd1=" + vendorAdd1 + ", taxDesc=" + taxDesc + ", deliveryDesc=" + deliveryDesc
				+ ", dispModeDesc=" + dispModeDesc + ", pymtDesc=" + pymtDesc + ", vendorGstNo=" + vendorGstNo
				+ ", indDate=" + indDate + ", pOReportDetailList=" + pOReportDetailList + "]";
	}

}
