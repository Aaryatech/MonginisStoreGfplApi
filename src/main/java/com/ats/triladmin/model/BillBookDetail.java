package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_bill_book_detail")
public class BillBookDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_detail_id")
	private int billDetailId;
	private int billId;
	private int mrnDetailId;
	private int vendId;
	private int itemId;
	private String itemDesc;
	private String itemUom;
	private float itemQty;
	private float itemRate;
	private float mrnQty;
	private float pendingQty;
	private float poQty;
	private float discPer;
	private float discValue;
	private int schDays;
	private String schDate;
	private String schRemark;
	private int status;
	private float basicValue;
	private float packValue;
	private float insu;
	private float otherChargesBefor;
	private float taxValue;
	private String freightValue;
	private float otherChargesAfter;
	private float landingCost;
	private float cgst;
	private float sgst;
	private float igst;

	public int getBillDetailId() {
		return billDetailId;
	}

	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getMrnDetailId() {
		return mrnDetailId;
	}

	public void setMrnDetailId(int mrnDetailId) {
		this.mrnDetailId = mrnDetailId;
	}

	public int getVendId() {
		return vendId;
	}

	public void setVendId(int vendId) {
		this.vendId = vendId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}

	public float getItemQty() {
		return itemQty;
	}

	public void setItemQty(float itemQty) {
		this.itemQty = itemQty;
	}

	public float getItemRate() {
		return itemRate;
	}

	public void setItemRate(float itemRate) {
		this.itemRate = itemRate;
	}

	public float getMrnQty() {
		return mrnQty;
	}

	public void setMrnQty(float mrnQty) {
		this.mrnQty = mrnQty;
	}

	public float getPendingQty() {
		return pendingQty;
	}

	public void setPendingQty(float pendingQty) {
		this.pendingQty = pendingQty;
	}

	public float getPoQty() {
		return poQty;
	}

	public void setPoQty(float poQty) {
		this.poQty = poQty;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	public float getDiscValue() {
		return discValue;
	}

	public void setDiscValue(float discValue) {
		this.discValue = discValue;
	}

	public int getSchDays() {
		return schDays;
	}

	public void setSchDays(int schDays) {
		this.schDays = schDays;
	}

	public String getSchDate() {
		return schDate;
	}

	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}

	public String getSchRemark() {
		return schRemark;
	}

	public void setSchRemark(String schRemark) {
		this.schRemark = schRemark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getBasicValue() {
		return basicValue;
	}

	public void setBasicValue(float basicValue) {
		this.basicValue = basicValue;
	}

	public float getPackValue() {
		return packValue;
	}

	public void setPackValue(float packValue) {
		this.packValue = packValue;
	}

	public float getInsu() {
		return insu;
	}

	public void setInsu(float insu) {
		this.insu = insu;
	}

	public float getOtherChargesBefor() {
		return otherChargesBefor;
	}

	public void setOtherChargesBefor(float otherChargesBefor) {
		this.otherChargesBefor = otherChargesBefor;
	}

	public float getTaxValue() {
		return taxValue;
	}

	public void setTaxValue(float taxValue) {
		this.taxValue = taxValue;
	}

	public String getFreightValue() {
		return freightValue;
	}

	public void setFreightValue(String freightValue) {
		this.freightValue = freightValue;
	}

	public float getOtherChargesAfter() {
		return otherChargesAfter;
	}

	public void setOtherChargesAfter(float otherChargesAfter) {
		this.otherChargesAfter = otherChargesAfter;
	}

	public float getLandingCost() {
		return landingCost;
	}

	public void setLandingCost(float landingCost) {
		this.landingCost = landingCost;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	@Override
	public String toString() {
		return "BillBookDetail [billDetailId=" + billDetailId + ", billId=" + billId + ", mrnDetailId=" + mrnDetailId
				+ ", vendId=" + vendId + ", itemId=" + itemId + ", itemDesc=" + itemDesc + ", itemUom=" + itemUom
				+ ", itemQty=" + itemQty + ", itemRate=" + itemRate + ", mrnQty=" + mrnQty + ", pendingQty="
				+ pendingQty + ", poQty=" + poQty + ", discPer=" + discPer + ", discValue=" + discValue + ", schDays="
				+ schDays + ", schDate=" + schDate + ", schRemark=" + schRemark + ", status=" + status + ", basicValue="
				+ basicValue + ", packValue=" + packValue + ", insu=" + insu + ", otherChargesBefor="
				+ otherChargesBefor + ", taxValue=" + taxValue + ", freightValue=" + freightValue
				+ ", otherChargesAfter=" + otherChargesAfter + ", landingCost=" + landingCost + ", cgst=" + cgst
				+ ", sgst=" + sgst + ", igst=" + igst + "]";
	}

}
