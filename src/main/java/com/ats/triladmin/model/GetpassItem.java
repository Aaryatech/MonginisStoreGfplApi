package com.ats.triladmin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_gatepass_item")
public class GetpassItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gp_item_id")
	private int gpItemId;

	private String itemName;

	private String itemDesc;

	private float itemCost;

	private String warrantyDate;

	private int isUsed;

	public int getGpItemId() {
		return gpItemId;
	}

	public void setGpItemId(int gpItemId) {
		this.gpItemId = gpItemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getItemCost() {
		return itemCost;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public void setItemCost(float itemCost) {
		this.itemCost = itemCost;
	}

	public String getWarrantyDate() {
		return warrantyDate;
	}

	public void setWarrantyDate(String warrantyDate) {
		this.warrantyDate = warrantyDate;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "GetpassItem [gpItemId=" + gpItemId + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", itemCost="
				+ itemCost + ", warrantyDate=" + warrantyDate + ", isUsed=" + isUsed + "]";
	}

}
