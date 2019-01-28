package com.ats.triladmin.model.report;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class IndentReportDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ind_d_id")
	private int indDId;

	@Column(name = "ind_m_id")
	private int indMId;

	@Column(name = "ind_m_no")
	private String indMNo;

	@Column(name = "ind_m_date")
	private Date indMDate;

	private int itemId;

	private float indQty;

	private String indItemUom;

	private String indItemDesc;

	private int indItemCurstk;

	private int indItemSchd;

	private Date indItemSchddt;

	private String indRemark;
	@Column(name = "ind_d_status")
	private int indDStatus;

	private int delStatus;

	private int indFyr;

	private String itemCode;

	public int getIndDId() {
		return indDId;
	}

	public void setIndDId(int indDId) {
		this.indDId = indDId;
	}

	public int getIndMId() {
		return indMId;
	}

	public void setIndMId(int indMId) {
		this.indMId = indMId;
	}

	public String getIndMNo() {
		return indMNo;
	}

	public void setIndMNo(String indMNo) {
		this.indMNo = indMNo;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIndMDate() {
		return indMDate;
	}

	public void setIndMDate(Date indMDate) {
		this.indMDate = indMDate;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getIndQty() {
		return indQty;
	}

	public void setIndQty(float indQty) {
		this.indQty = indQty;
	}

	public String getIndItemUom() {
		return indItemUom;
	}

	public void setIndItemUom(String indItemUom) {
		this.indItemUom = indItemUom;
	}

	public String getIndItemDesc() {
		return indItemDesc;
	}

	public void setIndItemDesc(String indItemDesc) {
		this.indItemDesc = indItemDesc;
	}

	public int getIndItemCurstk() {
		return indItemCurstk;
	}

	public void setIndItemCurstk(int indItemCurstk) {
		this.indItemCurstk = indItemCurstk;
	}

	public int getIndItemSchd() {
		return indItemSchd;
	}

	public void setIndItemSchd(int indItemSchd) {
		this.indItemSchd = indItemSchd;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIndItemSchddt() {
		return indItemSchddt;
	}

	public void setIndItemSchddt(Date indItemSchddt) {
		this.indItemSchddt = indItemSchddt;
	}

	public String getIndRemark() {
		return indRemark;
	}

	public void setIndRemark(String indRemark) {
		this.indRemark = indRemark;
	}

	public int getIndDStatus() {
		return indDStatus;
	}

	public void setIndDStatus(int indDStatus) {
		this.indDStatus = indDStatus;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getIndFyr() {
		return indFyr;
	}

	public void setIndFyr(int indFyr) {
		this.indFyr = indFyr;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Override
	public String toString() {
		return "IndentReportDetail [indDId=" + indDId + ", indMId=" + indMId + ", indMNo=" + indMNo + ", indMDate="
				+ indMDate + ", itemId=" + itemId + ", indQty=" + indQty + ", indItemUom=" + indItemUom
				+ ", indItemDesc=" + indItemDesc + ", indItemCurstk=" + indItemCurstk + ", indItemSchd=" + indItemSchd
				+ ", indItemSchddt=" + indItemSchddt + ", indRemark=" + indRemark + ", indDStatus=" + indDStatus
				+ ", delStatus=" + delStatus + ", indFyr=" + indFyr + ", itemCode=" + itemCode + "]";
	}

}
