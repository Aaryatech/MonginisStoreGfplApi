package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MinAndRolLevelReport {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_code")
	private String itemCode;

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
	
	@Column(name = "return_issue_qty")
	private float returnIssueQty;
	
	@Column(name = "damage_qty")
	private float damageQty;
	
	@Column(name = "damage_value")
	private float damagValue;
	
	@Column(name = "gatepass_qty")
	private float gatepassQty;
	
	@Column(name = "gatepass_return_qty")
	private float gatepassReturnQty;
	
	@Column(name = "item_min_level")
	private float itemMinLevel;
	
	@Column(name = "item_rod_level")
	private float itemRodLevel;

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

	public float getReturnIssueQty() {
		return returnIssueQty;
	}

	public void setReturnIssueQty(float returnIssueQty) {
		this.returnIssueQty = returnIssueQty;
	}

	public float getDamageQty() {
		return damageQty;
	}

	public void setDamageQty(float damageQty) {
		this.damageQty = damageQty;
	}

	public float getDamagValue() {
		return damagValue;
	}

	public void setDamagValue(float damagValue) {
		this.damagValue = damagValue;
	}

	public float getGatepassQty() {
		return gatepassQty;
	}

	public void setGatepassQty(float gatepassQty) {
		this.gatepassQty = gatepassQty;
	}

	public float getGatepassReturnQty() {
		return gatepassReturnQty;
	}

	public void setGatepassReturnQty(float gatepassReturnQty) {
		this.gatepassReturnQty = gatepassReturnQty;
	}

	public float getItemMinLevel() {
		return itemMinLevel;
	}

	public void setItemMinLevel(float itemMinLevel) {
		this.itemMinLevel = itemMinLevel;
	}

	public float getItemRodLevel() {
		return itemRodLevel;
	}

	public void setItemRodLevel(float itemRodLevel) {
		this.itemRodLevel = itemRodLevel;
	}

	@Override
	public String toString() {
		return "MinAndRolLevelReport [itemId=" + itemId + ", itemCode=" + itemCode + ", openingStock=" + openingStock
				+ ", opStockValue=" + opStockValue + ", approveQty=" + approveQty + ", approvedQtyValue="
				+ approvedQtyValue + ", approvedLandingValue=" + approvedLandingValue + ", issueQty=" + issueQty
				+ ", issueQtyValue=" + issueQtyValue + ", issueLandingValue=" + issueLandingValue + ", returnIssueQty="
				+ returnIssueQty + ", damageQty=" + damageQty + ", damagValue=" + damagValue + ", gatepassQty="
				+ gatepassQty + ", gatepassReturnQty=" + gatepassReturnQty + ", itemMinLevel=" + itemMinLevel
				+ ", itemRodLevel=" + itemRodLevel + "]";
	}
	
	

}
