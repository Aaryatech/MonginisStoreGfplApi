package com.ats.triladmin.model.ownerapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PurchaseDetailDisplayForApp {

	@Id
	private int mrnDetailId;
	private int mrnId;
	private int poDetailId;
	private int itemId;
	private String itemDesc;
	private String itemUom;
	private int mrnQty;
	private float itemRate;
	private float cgst;
	private float sgst;
	private float igst;
	private float discValue;

	private float taxableAmt;
	private float taxAmt;
	private float grandTotal;
	private float cgstAmt;
	private float sgstAmt;
	private float otherChargesBefor;
	private float otherChargesAfter;

	public int getMrnDetailId() {
		return mrnDetailId;
	}

	public void setMrnDetailId(int mrnDetailId) {
		this.mrnDetailId = mrnDetailId;
	}

	public int getMrnId() {
		return mrnId;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public int getPoDetailId() {
		return poDetailId;
	}

	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
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

	public int getMrnQty() {
		return mrnQty;
	}

	public void setMrnQty(int mrnQty) {
		this.mrnQty = mrnQty;
	}

	public float getItemRate() {
		return itemRate;
	}

	public void setItemRate(float itemRate) {
		this.itemRate = itemRate;
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

	public float getDiscValue() {
		return discValue;
	}

	public void setDiscValue(float discValue) {
		this.discValue = discValue;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(float taxAmt) {
		this.taxAmt = taxAmt;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public float getCgstAmt() {
		return cgstAmt;
	}

	public void setCgstAmt(float cgstAmt) {
		this.cgstAmt = cgstAmt;
	}

	public float getSgstAmt() {
		return sgstAmt;
	}

	public void setSgstAmt(float sgstAmt) {
		this.sgstAmt = sgstAmt;
	}

	public float getOtherChargesBefor() {
		return otherChargesBefor;
	}

	public void setOtherChargesBefor(float otherChargesBefor) {
		this.otherChargesBefor = otherChargesBefor;
	}

	public float getOtherChargesAfter() {
		return otherChargesAfter;
	}

	public void setOtherChargesAfter(float otherChargesAfter) {
		this.otherChargesAfter = otherChargesAfter;
	}

	@Override
	public String toString() {
		return "PurchaseDetailDisplayForApp [mrnDetailId=" + mrnDetailId + ", mrnId=" + mrnId + ", poDetailId="
				+ poDetailId + ", itemId=" + itemId + ", itemDesc=" + itemDesc + ", itemUom=" + itemUom + ", mrnQty="
				+ mrnQty + ", itemRate=" + itemRate + ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst
				+ ", discValue=" + discValue + ", taxableAmt=" + taxableAmt + ", taxAmt=" + taxAmt + ", grandTotal="
				+ grandTotal + ", cgstAmt=" + cgstAmt + ", sgstAmt=" + sgstAmt + ", otherChargesBefor="
				+ otherChargesBefor + ", otherChargesAfter=" + otherChargesAfter + "]";
	}

}
