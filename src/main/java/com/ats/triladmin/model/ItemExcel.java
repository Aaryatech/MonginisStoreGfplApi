package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemExcel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "cat_id")
	private int catId;

	@Column(name = "grp_id")
	private int grpId;

	@Column(name = "cat_desc")
	private String catDesc;

	@Column(name = "grp_desc")
	private String grpDesc;

	@Column(name = "item_uom")
	private String itemUom;

	@Column(name = "item_uom2")
	private String itemUom2;

	@Column(name = "item_desc")
	private String itemDesc;

	@Column(name = "tax_per")
	private float taxPer;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public String getGrpDesc() {
		return grpDesc;
	}

	public void setGrpDesc(String grpDesc) {
		this.grpDesc = grpDesc;
	}

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}

	public String getItemUom2() {
		return itemUom2;
	}

	public void setItemUom2(String itemUom2) {
		this.itemUom2 = itemUom2;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public float getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(float taxPer) {
		this.taxPer = taxPer;
	}

	@Override
	public String toString() {
		return "ItemExcel [itemId=" + itemId + ", catId=" + catId + ", grpId=" + grpId + ", catDesc=" + catDesc
				+ ", grpDesc=" + grpDesc + ", itemUom=" + itemUom + ", itemUom2=" + itemUom2 + ", itemDesc=" + itemDesc
				+ ", taxPer=" + taxPer + "]";
	}

}
