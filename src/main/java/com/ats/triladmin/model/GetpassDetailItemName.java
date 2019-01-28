package com.ats.triladmin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetpassDetailItemName {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gpDetailId;
	private int gpId;
	private int gpItemId;
	private float gpQty;
	private int gpNoDays;
	private Date gpReturnDate;
	private int gpStatus;
	private int isUsed;
	private float gpRemQty;
	private float gpRetQty;
	private String remark;
	private int uom;
	private String uomName;
	@Column(name = "cat_id")
	private int catId;
	@Column(name = "grp_id")
	private int grpId;
	
	private String itemCode;

	public int getGpDetailId() {
		return gpDetailId;
	}

	public void setGpDetailId(int gpDetailId) {
		this.gpDetailId = gpDetailId;
	}

	public int getGpId() {
		return gpId;
	}

	public void setGpId(int gpId) {
		this.gpId = gpId;
	}

	public int getGpItemId() {
		return gpItemId;
	}

	public void setGpItemId(int gpItemId) {
		this.gpItemId = gpItemId;
	}

	public float getGpQty() {
		return gpQty;
	}

	public void setGpQty(float gpQty) {
		this.gpQty = gpQty;
	}

	public int getGpNoDays() {
		return gpNoDays;
	}

	public void setGpNoDays(int gpNoDays) {
		this.gpNoDays = gpNoDays;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGpReturnDate() {
		return gpReturnDate;
	}

	public void setGpReturnDate(Date gpReturnDate) {
		this.gpReturnDate = gpReturnDate;
	}

	public int getGpStatus() {
		return gpStatus;
	}

	public void setGpStatus(int gpStatus) {
		this.gpStatus = gpStatus;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public float getGpRemQty() {
		return gpRemQty;
	}

	public void setGpRemQty(float gpRemQty) {
		this.gpRemQty = gpRemQty;
	}

	public float getGpRetQty() {
		return gpRetQty;
	}

	public void setGpRetQty(float gpRetQty) {
		this.gpRetQty = gpRetQty;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getUom() {
		return uom;
	}

	public void setUom(int uom) {
		this.uom = uom;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	@Override
	public String toString() {
		return "GetpassDetailItemName [gpDetailId=" + gpDetailId + ", gpId=" + gpId + ", gpItemId=" + gpItemId
				+ ", gpQty=" + gpQty + ", gpNoDays=" + gpNoDays + ", gpReturnDate=" + gpReturnDate + ", gpStatus="
				+ gpStatus + ", isUsed=" + isUsed + ", gpRemQty=" + gpRemQty + ", gpRetQty=" + gpRetQty + ", remark="
				+ remark + ", uom=" + uom + ", uomName=" + uomName + ", catId=" + catId + ", grpId=" + grpId
				+ ", itemCode=" + itemCode + "]";
	}

}
