package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockValuationCategoryWise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private int catId;

	@Column(name = "cat_desc")
	private String catDesc;
 
	@Column(name = "opening_stock")
	private float openingStock;

	@Column(name = "op_stock_value")
	private float opStockValue;

	@Column(name = "approve_qty")
	private float approveQty;
	
	@Column(name = "approved_qty_value")
	private float approvedQtyValue;
	
	@Column(name = "approved_landing_value")
	private float approvedLandingValue;
	
	@Column(name = "issue_qty")
	private float issueQty;
	
	@Column(name = "issue_qty_value")
	private float issueQtyValue;
	
	@Column(name = "issue_landing_value")
	private float issueLandingValue;
	
	@Column(name = "damage_qty")
	private float damageQty;
	
	@Column(name = "damage_value")
	private float damageValue;
	
	@Column(name = "op_landing_value")
	private float opLandingValue; 
	
	@Column(name = "damage_landing_value")
	private float damageLandingValue;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public float getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(float openingStock) {
		this.openingStock = openingStock;
	}

	public float getOpStockValue() {
		return opStockValue;
	}

	public void setOpStockValue(float opStockValue) {
		this.opStockValue = opStockValue;
	}

	public float getApproveQty() {
		return approveQty;
	}

	public void setApproveQty(float approveQty) {
		this.approveQty = approveQty;
	}

	public float getApprovedQtyValue() {
		return approvedQtyValue;
	}

	public void setApprovedQtyValue(float approvedQtyValue) {
		this.approvedQtyValue = approvedQtyValue;
	}

	public float getApprovedLandingValue() {
		return approvedLandingValue;
	}

	public void setApprovedLandingValue(float approvedLandingValue) {
		this.approvedLandingValue = approvedLandingValue;
	}

	public float getIssueQty() {
		return issueQty;
	}

	public void setIssueQty(float issueQty) {
		this.issueQty = issueQty;
	}

	public float getIssueQtyValue() {
		return issueQtyValue;
	}

	public void setIssueQtyValue(float issueQtyValue) {
		this.issueQtyValue = issueQtyValue;
	}

	public float getIssueLandingValue() {
		return issueLandingValue;
	}

	public void setIssueLandingValue(float issueLandingValue) {
		this.issueLandingValue = issueLandingValue;
	}

	public float getDamageQty() {
		return damageQty;
	}

	public void setDamageQty(float damageQty) {
		this.damageQty = damageQty;
	}

	public float getDamageValue() {
		return damageValue;
	}

	public void setDamageValue(float damageValue) {
		this.damageValue = damageValue;
	}

	public float getOpLandingValue() {
		return opLandingValue;
	}

	public void setOpLandingValue(float opLandingValue) {
		this.opLandingValue = opLandingValue;
	}

	public float getDamageLandingValue() {
		return damageLandingValue;
	}

	public void setDamageLandingValue(float damageLandingValue) {
		this.damageLandingValue = damageLandingValue;
	}

	@Override
	public String toString() {
		return "StockValuationCategoryWise [catId=" + catId + ", catDesc=" + catDesc + ", openingStock=" + openingStock
				+ ", opStockValue=" + opStockValue + ", approveQty=" + approveQty + ", approvedQtyValue="
				+ approvedQtyValue + ", approvedLandingValue=" + approvedLandingValue + ", issueQty=" + issueQty
				+ ", issueQtyValue=" + issueQtyValue + ", issueLandingValue=" + issueLandingValue + ", damageQty="
				+ damageQty + ", damageValue=" + damageValue + ", opLandingValue=" + opLandingValue
				+ ", damageLandingValue=" + damageLandingValue + "]";
	}
	
	

}
