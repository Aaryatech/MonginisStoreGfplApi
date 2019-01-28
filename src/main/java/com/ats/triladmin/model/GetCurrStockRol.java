package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetCurrStockRol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_code")
	private String itemCode;
	
	@Transient
	private String itemName;
	
	@Transient
	private String itemUom;
		
	@Transient
	private int catId;
	
	@Transient
	private float itemMaxLevel;
	
	@Transient
	private float itemMinLevel;
	
	@Column(name = "opening_stock")
	private float openingStock;

	@Column(name = "approve_qty")
	private float approveQty;

	@Column(name = "issue_qty")
	private float issueQty;
	
	@Column(name = "return_issue_qty")
	private float returnIssueQty;
	
	@Column(name = "damage_qty")
	private float damageQty;
	
	@Column(name = "gatepass_qty")
	private float gatepassQty;
	
	@Column(name = "gatepass_return_qty")
	private float gatepassReturnQty;
	
	@Transient
	private float rolLevel;

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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public float getItemMaxLevel() {
		return itemMaxLevel;
	}

	public void setItemMaxLevel(float itemMaxLevel) {
		this.itemMaxLevel = itemMaxLevel;
	}

	public float getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(float openingStock) {
		this.openingStock = openingStock;
	}

	public float getApproveQty() {
		return approveQty;
	}

	public void setApproveQty(float approveQty) {
		this.approveQty = approveQty;
	}

	public float getIssueQty() {
		return issueQty;
	}

	public void setIssueQty(float issueQty) {
		this.issueQty = issueQty;
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

	public float getRolLevel() {
		return rolLevel;
	}

	public void setRolLevel(float rolLevel) {
		this.rolLevel = rolLevel;
	}

	public float getItemMinLevel() {
		return itemMinLevel;
	}

	public void setItemMinLevel(float itemMinLevel) {
		this.itemMinLevel = itemMinLevel;
	}

	@Override
	public String toString() {
		return "GetCurrStockRol [itemId=" + itemId + ", itemCode=" + itemCode + ", itemName=" + itemName + ", itemUom="
				+ itemUom + ", catId=" + catId + ", itemMaxLevel=" + itemMaxLevel + ", itemMinLevel=" + itemMinLevel
				+ ", openingStock=" + openingStock + ", approveQty=" + approveQty + ", issueQty=" + issueQty
				+ ", returnIssueQty=" + returnIssueQty + ", damageQty=" + damageQty + ", gatepassQty=" + gatepassQty
				+ ", gatepassReturnQty=" + gatepassReturnQty + ", rolLevel=" + rolLevel + "]";
	}
	
	
 
	
}
