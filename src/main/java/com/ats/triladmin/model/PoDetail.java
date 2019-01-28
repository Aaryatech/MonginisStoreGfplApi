package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "po_detail")
public class PoDetail {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public int getPoDetailId() {
		return poDetailId;
	}

	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public int getIndId() {
		return indId;
	}

	public void setIndId(int indId) {
		this.indId = indId;
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

	public float getIndedQty() {
		return indedQty;
	}

	public void setIndedQty(float indedQty) {
		this.indedQty = indedQty;
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
		return "PoDetail [poDetailId=" + poDetailId + ", poId=" + poId + ", indId=" + indId + ", vendId=" + vendId
				+ ", itemId=" + itemId + ", itemDesc=" + itemDesc + ", itemUom=" + itemUom + ", itemQty=" + itemQty
				+ ", itemRate=" + itemRate + ", mrnQty=" + mrnQty + ", pendingQty=" + pendingQty + ", indedQty="
				+ indedQty + ", discPer=" + discPer + ", discValue=" + discValue + ", schDays=" + schDays + ", schDate="
				+ schDate + ", schRemark=" + schRemark + ", status=" + status + ", basicValue=" + basicValue
				+ ", packValue=" + packValue + ", insu=" + insu + ", otherChargesBefor=" + otherChargesBefor
				+ ", taxValue=" + taxValue + ", freightValue=" + freightValue + ", otherChargesAfter="
				+ otherChargesAfter + ", landingCost=" + landingCost + ", cgst=" + cgst + ", sgst=" + sgst + ", igst="
				+ igst + "]";
	}
	 
	

}
