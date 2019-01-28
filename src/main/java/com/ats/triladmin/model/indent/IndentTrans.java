package com.ats.triladmin.model.indent;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "indtrans")
public class IndentTrans {
	
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
	
	private float	indFyr;
	
	//indentTrans new Field
	
	@Column(name = "ind_apr1_date")
	private Date indApr1Date;
	
	@Column(name = "ind_apr2_date")
	private Date indApr2Date;

	public int getIndDId() {
		return indDId;
	}

	public int getIndMId() {
		return indMId;
	}

	public String getIndMNo() {
		return indMNo;
	}

	public Date getIndMDate() {
		return indMDate;
	}

	public int getItemId() {
		return itemId;
	}

	public float getIndQty() {
		return indQty;
	}

	public String getIndItemUom() {
		return indItemUom;
	}

	public String getIndItemDesc() {
		return indItemDesc;
	}

	public int getIndItemCurstk() {
		return indItemCurstk;
	}

	public int getIndItemSchd() {
		return indItemSchd;
	}

	public Date getIndItemSchddt() {
		return indItemSchddt;
	}

	public String getIndRemark() {
		return indRemark;
	}

	public int getIndDStatus() {
		return indDStatus;
	}

	public float getIndFyr() {
		return indFyr;
	}

	public void setIndDId(int indDId) {
		this.indDId = indDId;
	}

	public void setIndMId(int indMId) {
		this.indMId = indMId;
	}

	public void setIndMNo(String indMNo) {
		this.indMNo = indMNo;
	}

	public void setIndMDate(Date indMDate) {
		this.indMDate = indMDate;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setIndQty(float indQty) {
		this.indQty = indQty;
	}

	public void setIndItemUom(String indItemUom) {
		this.indItemUom = indItemUom;
	}

	public void setIndItemDesc(String indItemDesc) {
		this.indItemDesc = indItemDesc;
	}

	public void setIndItemCurstk(int indItemCurstk) {
		this.indItemCurstk = indItemCurstk;
	}

	public void setIndItemSchd(int indItemSchd) {
		this.indItemSchd = indItemSchd;
	}

	public void setIndItemSchddt(Date indItemSchddt) {
		this.indItemSchddt = indItemSchddt;
	}

	public void setIndRemark(String indRemark) {
		this.indRemark = indRemark;
	}

	public void setIndDStatus(int indDStatus) {
		this.indDStatus = indDStatus;
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

	
	
	public Date getIndApr1Date() {
		return indApr1Date;
	}

	public Date getIndApr2Date() {
		return indApr2Date;
	}

	public void setIndApr1Date(Date indApr1Date) {
		this.indApr1Date = indApr1Date;
	}

	public void setIndApr2Date(Date indApr2Date) {
		this.indApr2Date = indApr2Date;
	}

	@Override
	public String toString() {
		return "IndentTrans [indDId=" + indDId + ", indMId=" + indMId + ", indMNo=" + indMNo + ", indMDate=" + indMDate
				+ ", itemId=" + itemId + ", indQty=" + indQty + ", indItemUom=" + indItemUom + ", indItemDesc="
				+ indItemDesc + ", indItemCurstk=" + indItemCurstk + ", indItemSchd=" + indItemSchd + ", indItemSchddt="
				+ indItemSchddt + ", indRemark=" + indRemark + ", indDStatus=" + indDStatus + ", delStatus=" + delStatus
				+ ", indFyr=" + indFyr + ", indApr1Date=" + indApr1Date + ", indApr2Date=" + indApr2Date + "]";
	}
	
	
}
