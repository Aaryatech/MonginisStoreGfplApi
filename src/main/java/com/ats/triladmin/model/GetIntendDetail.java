package com.ats.triladmin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetIntendDetail {
	
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
	
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_code")
	private String itemCode;
	
	@Column(name = "ind_qty")
	private float indQty;
	
	@Column(name = "ind_item_uom")
	private String indItemUom;
	
	@Column(name = "ind_item_desc")
	private String indItemDesc;
	
	@Column(name = "ind_item_curstk")
	private int indItemCurstk;
	
	@Column(name = "ind_item_schd")
	private int indItemSchd;
	
	@Column(name = "ind_item_schddt")
	private Date indItemSchddt;
	
	@Column(name = "ind_remark")
	private String indRemark;
	
	@Column(name = "ind_d_status")
	private int indDStatus;
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "ind_fyr")
	private float	indFyr;
	
	@Column(name = "ind_apr1_date")
	private String indApr1Date;
	
	@Column(name = "ind_apr2_date")
	private String indApr2Date;

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

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "yyyy-MM-dd")
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

	public float getIndFyr() {
		return indFyr;
	}

	public void setIndFyr(float indFyr) {
		this.indFyr = indFyr;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getIndApr1Date() {
		return indApr1Date;
	}

	public void setIndApr1Date(String indApr1Date) {
		this.indApr1Date = indApr1Date;
	}

	public String getIndApr2Date() {
		return indApr2Date;
	}

	public void setIndApr2Date(String indApr2Date) {
		this.indApr2Date = indApr2Date;
	}

	@Override
	public String toString() {
		return "GetIntendDetail [indDId=" + indDId + ", indMId=" + indMId + ", indMNo=" + indMNo + ", indMDate="
				+ indMDate + ", itemId=" + itemId + ", itemCode=" + itemCode + ", indQty=" + indQty + ", indItemUom="
				+ indItemUom + ", indItemDesc=" + indItemDesc + ", indItemCurstk=" + indItemCurstk + ", indItemSchd="
				+ indItemSchd + ", indItemSchddt=" + indItemSchddt + ", indRemark=" + indRemark + ", indDStatus="
				+ indDStatus + ", delStatus=" + delStatus + ", indFyr=" + indFyr + ", indApr1Date=" + indApr1Date
				+ ", indApr2Date=" + indApr2Date + "]";
	}
	
	
	
	

}
