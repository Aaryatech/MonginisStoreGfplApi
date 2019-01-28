package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_stock_detail")
public class StockDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stock_detail_id")
	private int stockDetailId;
	
	@Column(name = "stock_header_id")
	private int stockHeaderId;
 
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "op_stock_qty")
	private float opStockQty;

	@Column(name = "approved_qty")
	private float approvedQty;
	
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
	
	@Column(name = "closing_qty")
	private float closingQty;
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "op_stock_value")
	private float opStockValue;

	@Column(name = "approved_qty_value")
	private float approvedQtyValue;
	
	@Column(name = "issue_qty_value")
	private float issueQtyValue;
	
	@Column(name = "return_issue_value")
	private float returnIssueValue;
	
	@Column(name = "damage_value")
	private float damageValue;
	
	@Column(name = "gatepass_value")
	private float gatepassValue;
	
	@Column(name = "gatepass_return_value")
	private float gatepassReturnValue;
	
	@Column(name = "cloasing_value")
	private float cloasingValue;

	public int getStockDetailId() {
		return stockDetailId;
	}

	public void setStockDetailId(int stockDetailId) {
		this.stockDetailId = stockDetailId;
	}

	public int getStockHeaderId() {
		return stockHeaderId;
	}

	public void setStockHeaderId(int stockHeaderId) {
		this.stockHeaderId = stockHeaderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getOpStockQty() {
		return opStockQty;
	}

	public void setOpStockQty(float opStockQty) {
		this.opStockQty = opStockQty;
	}

	public float getApprovedQty() {
		return approvedQty;
	}

	public void setApprovedQty(float approvedQty) {
		this.approvedQty = approvedQty;
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

	public float getClosingQty() {
		return closingQty;
	}

	public void setClosingQty(float closingQty) {
		this.closingQty = closingQty;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public float getOpStockValue() {
		return opStockValue;
	}

	public void setOpStockValue(float opStockValue) {
		this.opStockValue = opStockValue;
	}

	public float getApprovedQtyValue() {
		return approvedQtyValue;
	}

	public void setApprovedQtyValue(float approvedQtyValue) {
		this.approvedQtyValue = approvedQtyValue;
	}

	public float getIssueQtyValue() {
		return issueQtyValue;
	}

	public void setIssueQtyValue(float issueQtyValue) {
		this.issueQtyValue = issueQtyValue;
	}

	public float getReturnIssueValue() {
		return returnIssueValue;
	}

	public void setReturnIssueValue(float returnIssueValue) {
		this.returnIssueValue = returnIssueValue;
	}

	public float getDamageValue() {
		return damageValue;
	}

	public void setDamageValue(float damageValue) {
		this.damageValue = damageValue;
	}

	public float getGatepassValue() {
		return gatepassValue;
	}

	public void setGatepassValue(float gatepassValue) {
		this.gatepassValue = gatepassValue;
	}

	public float getGatepassReturnValue() {
		return gatepassReturnValue;
	}

	public void setGatepassReturnValue(float gatepassReturnValue) {
		this.gatepassReturnValue = gatepassReturnValue;
	}

	public float getCloasingValue() {
		return cloasingValue;
	}

	public void setCloasingValue(float cloasingValue) {
		this.cloasingValue = cloasingValue;
	}

	@Override
	public String toString() {
		return "StockDetail [stockDetailId=" + stockDetailId + ", stockHeaderId=" + stockHeaderId + ", itemId=" + itemId
				+ ", opStockQty=" + opStockQty + ", approvedQty=" + approvedQty + ", issueQty=" + issueQty
				+ ", returnIssueQty=" + returnIssueQty + ", damageQty=" + damageQty + ", gatepassQty=" + gatepassQty
				+ ", gatepassReturnQty=" + gatepassReturnQty + ", closingQty=" + closingQty + ", delStatus=" + delStatus
				+ ", opStockValue=" + opStockValue + ", approvedQtyValue=" + approvedQtyValue + ", issueQtyValue="
				+ issueQtyValue + ", returnIssueValue=" + returnIssueValue + ", damageValue=" + damageValue
				+ ", gatepassValue=" + gatepassValue + ", gatepassReturnValue=" + gatepassReturnValue
				+ ", cloasingValue=" + cloasingValue + "]";
	}
	
	

}
