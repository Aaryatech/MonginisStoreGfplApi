package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetPODetail {
	
	@Id
	@Column(name = "po_detail_id")
	private int poDetailId;
	
	@Column(name = "po_id")
	private int poId;
	
	@Column(name = "ind_id")
	private int indId;
	
	@Column(name = "vend_id")
	private int vendId;
  
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_desc")
	private String itemDesc; 
	
	@Column(name = "item_uom")
	private String itemUom;
	
	@Column(name = "item_qty")
	private float itemQty;
	
	@Column(name = "item_rate")
	private float itemRate;
	
	@Column(name = "mrn_qty")
	private float mrnQty;
	
	@Column(name = "pending_qty")
	private float pendingQty;
	
	@Column(name = "inded_qty")
	private float indedQty;
	
	@Column(name = "disc_per")
	private float discPer;
	
	@Column(name = "disc_value")
	private float discValue;
	
	@Column(name = "sch_days")
	private int schDays;
	
	@Column(name = "sch_date")
	private String schDate;
	
	@Column(name = "sch_remark")
	private String schRemark;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "basic_value")
	private float basicValue;
	
	@Column(name = "pack_value")
	private float packValue;
	
	@Column(name = "insu")
	private float insu;
	
	@Column(name = "other_charges_befor")
	private float otherChargesBefor;
	
	@Column(name = "tax_value")
	private float taxValue;
	
	@Column(name = "freight_value")
	private String freightValue;
	
	@Column(name = "other_charges_after")
	private float otherChargesAfter;
	
	@Column(name = "landing_cost")
	private float landingCost;
	
	@Column(name = "cgst")
	private float cgst;
	
	@Column(name = "sgst")
	private float sgst;
	
	@Column(name = "igst")
	private float igst;

	private String itemCode;
	private String itemName;
	private String uom;
	private String poNo;
	public int getPoDetailId() {
		return poDetailId;
	}
	public int getPoId() {
		return poId;
	}
	public int getIndId() {
		return indId;
	}
	public int getVendId() {
		return vendId;
	}
	public int getItemId() {
		return itemId;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public String getItemUom() {
		return itemUom;
	}
	public float getItemQty() {
		return itemQty;
	}
	public float getItemRate() {
		return itemRate;
	}
	public float getMrnQty() {
		return mrnQty;
	}
	public float getPendingQty() {
		return pendingQty;
	}
	public float getIndedQty() {
		return indedQty;
	}
	public float getDiscPer() {
		return discPer;
	}
	public float getDiscValue() {
		return discValue;
	}
	public int getSchDays() {
		return schDays;
	}
	public String getSchDate() {
		return schDate;
	}
	public String getSchRemark() {
		return schRemark;
	}
	public int getStatus() {
		return status;
	}
	public float getBasicValue() {
		return basicValue;
	}
	public float getPackValue() {
		return packValue;
	}
	public float getInsu() {
		return insu;
	}
	public float getOtherChargesBefor() {
		return otherChargesBefor;
	}
	public float getTaxValue() {
		return taxValue;
	}
	public String getFreightValue() {
		return freightValue;
	}
	public float getOtherChargesAfter() {
		return otherChargesAfter;
	}
	public float getLandingCost() {
		return landingCost;
	}
	public String getItemCode() {
		return itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public String getUom() {
		return uom;
	}
	public String getPoNo() {
		return poNo;
	}
	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public void setIndId(int indId) {
		this.indId = indId;
	}
	public void setVendId(int vendId) {
		this.vendId = vendId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}
	public void setItemQty(float itemQty) {
		this.itemQty = itemQty;
	}
	public void setItemRate(float itemRate) {
		this.itemRate = itemRate;
	}
	public void setMrnQty(float mrnQty) {
		this.mrnQty = mrnQty;
	}
	public void setPendingQty(float pendingQty) {
		this.pendingQty = pendingQty;
	}
	public void setIndedQty(float indedQty) {
		this.indedQty = indedQty;
	}
	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}
	public void setDiscValue(float discValue) {
		this.discValue = discValue;
	}
	public void setSchDays(int schDays) {
		this.schDays = schDays;
	}
	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}
	public void setSchRemark(String schRemark) {
		this.schRemark = schRemark;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setBasicValue(float basicValue) {
		this.basicValue = basicValue;
	}
	public void setPackValue(float packValue) {
		this.packValue = packValue;
	}
	public void setInsu(float insu) {
		this.insu = insu;
	}
	public void setOtherChargesBefor(float otherChargesBefor) {
		this.otherChargesBefor = otherChargesBefor;
	}
	public void setTaxValue(float taxValue) {
		this.taxValue = taxValue;
	}
	public void setFreightValue(String freightValue) {
		this.freightValue = freightValue;
	}
	public void setOtherChargesAfter(float otherChargesAfter) {
		this.otherChargesAfter = otherChargesAfter;
	}
	public void setLandingCost(float landingCost) {
		this.landingCost = landingCost;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
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
		return "GetPODetail [poDetailId=" + poDetailId + ", poId=" + poId + ", indId=" + indId + ", vendId=" + vendId
				+ ", itemId=" + itemId + ", itemDesc=" + itemDesc + ", itemUom=" + itemUom + ", itemQty=" + itemQty
				+ ", itemRate=" + itemRate + ", mrnQty=" + mrnQty + ", pendingQty=" + pendingQty + ", indedQty="
				+ indedQty + ", discPer=" + discPer + ", discValue=" + discValue + ", schDays=" + schDays + ", schDate="
				+ schDate + ", schRemark=" + schRemark + ", status=" + status + ", basicValue=" + basicValue
				+ ", packValue=" + packValue + ", insu=" + insu + ", otherChargesBefor=" + otherChargesBefor
				+ ", taxValue=" + taxValue + ", freightValue=" + freightValue + ", otherChargesAfter="
				+ otherChargesAfter + ", landingCost=" + landingCost + ", cgst=" + cgst + ", sgst=" + sgst + ", igst="
				+ igst + ", itemCode=" + itemCode + ", itemName=" + itemName + ", uom=" + uom + ", poNo=" + poNo + "]";
	}
	
}
