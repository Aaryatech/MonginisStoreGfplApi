package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_item_subgroup")
public class ItemSubGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subgrp_id")
	private int subgrpId;

	private int grpId;

	private String subgrpDesc;

	private int isUsed;

	private int createdIn;

	private int deletedIn;

	public int getSubgrpId() {
		return subgrpId;
	}

	public void setSubgrpId(int subgrpId) {
		this.subgrpId = subgrpId;
	}

	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public String getSubgrpDesc() {
		return subgrpDesc;
	}

	public void setSubgrpDesc(String subgrpDesc) {
		this.subgrpDesc = subgrpDesc;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public int getCreatedIn() {
		return createdIn;
	}

	public void setCreatedIn(int createdIn) {
		this.createdIn = createdIn;
	}

	public int getDeletedIn() {
		return deletedIn;
	}

	public void setDeletedIn(int deletedIn) {
		this.deletedIn = deletedIn;
	}

	@Override
	public String toString() {
		return "ItemSubGroup [subgrpId=" + subgrpId + ", grpId=" + grpId + ", subgrpDesc=" + subgrpDesc + ", isUsed="
				+ isUsed + ", createdIn=" + createdIn + ", deletedIn=" + deletedIn + "]";
	}

}
