package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_item_group")
public class ItemGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grp_id")
	private int grpId;

	private int catId;

	private String grpCode;

	private String grpDesc;

	private String grpValueyn;

	private int isUsed;

	private int createdIn;

	private int deletedIn;

	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getGrpCode() {
		return grpCode;
	}

	public void setGrpCode(String grpCode) {
		this.grpCode = grpCode;
	}

	public String getGrpDesc() {
		return grpDesc;
	}

	public void setGrpDesc(String grpDesc) {
		this.grpDesc = grpDesc;
	}

	public String getGrpValueyn() {
		return grpValueyn;
	}

	public void setGrpValueyn(String grpValueyn) {
		this.grpValueyn = grpValueyn;
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
		return "ItemGroup [grpId=" + grpId + ", catId=" + catId + ", grpCode=" + grpCode + ", grpDesc=" + grpDesc
				+ ", grpValueyn=" + grpValueyn + ", isUsed=" + isUsed + ", createdIn=" + createdIn + ", deletedIn="
				+ deletedIn + "]";
	}

}
