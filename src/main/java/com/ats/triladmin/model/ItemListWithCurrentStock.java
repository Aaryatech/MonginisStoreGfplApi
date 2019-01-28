package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ItemListWithCurrentStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_code") 
	private String itemCode; 
	
	@Column(name = "cat_id")
	private int catId;  
	
	@Column(name = "grp_id")
	private int grpId; 
	
	@Column(name = "item_uom")
	private String itemUom;   
	
	@Column(name = "item_desc")
	private String itemDesc;
	
	@Column(name = "min_level")
	private float minLevel; 
	
	@Column(name = "max_level")
	private float maxLevel; 
	
	@Column(name = "rol_level")
	private float rolLevel; 
	
	@Column(name = "opening_stock")
	private float openingStock; 
	
	@Column(name = "approve_qty")
	private float approveQty; 
	
	@Column(name = "issue_qty")
	private float issueQty;
	
	@Column(name = "issue_return_qty")
	private float issueReturnQty;
	
	@Column(name = "damage_qty")
	private float damageQty;
	
	@Column(name = "po_pending")
	private float poPending; 
	
	@Column(name = "item_op_qty")
	private float itemopQty; 
	
	@Column(name = "issue_qty_avg")
	private float issueQtyAvg;
	
	@Column(name = "active")
	private int active;
	
	@Transient
	private float avgIssueQty; 
	
	@Transient
	private float clsQty;

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

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
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

	public float getIssueReturnQty() {
		return issueReturnQty;
	}

	public void setIssueReturnQty(float issueReturnQty) {
		this.issueReturnQty = issueReturnQty;
	}

	public float getDamageQty() {
		return damageQty;
	}

	public void setDamageQty(float damageQty) {
		this.damageQty = damageQty;
	}

	public float getPoPending() {
		return poPending;
	}

	public void setPoPending(float poPending) {
		this.poPending = poPending;
	}

	public float getAvgIssueQty() {
		return avgIssueQty;
	}

	public void setAvgIssueQty(float avgIssueQty) {
		this.avgIssueQty = avgIssueQty;
	}

	public float getClsQty() {
		return clsQty;
	}

	public void setClsQty(float clsQty) {
		this.clsQty = clsQty;
	}

	public float getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(float minLevel) {
		this.minLevel = minLevel;
	}

	public float getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(float maxLevel) {
		this.maxLevel = maxLevel;
	}

	public float getRolLevel() {
		return rolLevel;
	}

	public void setRolLevel(float rolLevel) {
		this.rolLevel = rolLevel;
	}

	public float getItemopQty() {
		return itemopQty;
	}

	public void setItemopQty(float itemopQty) {
		this.itemopQty = itemopQty;
	}

	public float getIssueQtyAvg() {
		return issueQtyAvg;
	}

	public void setIssueQtyAvg(float issueQtyAvg) {
		this.issueQtyAvg = issueQtyAvg;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "ItemListWithCurrentStock [itemId=" + itemId + ", itemCode=" + itemCode + ", catId=" + catId + ", grpId="
				+ grpId + ", itemUom=" + itemUom + ", itemDesc=" + itemDesc + ", minLevel=" + minLevel + ", maxLevel="
				+ maxLevel + ", rolLevel=" + rolLevel + ", openingStock=" + openingStock + ", approveQty=" + approveQty
				+ ", issueQty=" + issueQty + ", issueReturnQty=" + issueReturnQty + ", damageQty=" + damageQty
				+ ", poPending=" + poPending + ", itemopQty=" + itemopQty + ", issueQtyAvg=" + issueQtyAvg + ", active="
				+ active + ", avgIssueQty=" + avgIssueQty + ", clsQty=" + clsQty + "]";
	}
 
	
	
}
