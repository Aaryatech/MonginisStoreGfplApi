package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_account_head")
public class AccountHead {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "acc_head_id")
	private int accHeadId;

	private String accHeadDesc;

	private int isUsed;

	private int createdIn;

	private int deletedIn;

	public int getAccHeadId() {
		return accHeadId;
	}

	public void setAccHeadId(int accHeadId) {
		this.accHeadId = accHeadId;
	}

	public String getAccHeadDesc() {
		return accHeadDesc;
	}

	public void setAccHeadDesc(String accHeadDesc) {
		this.accHeadDesc = accHeadDesc;
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
		return "AccountHead [accHeadId=" + accHeadId + ", accHeadDesc=" + accHeadDesc + ", isUsed=" + isUsed
				+ ", createdIn=" + createdIn + ", deletedIn=" + deletedIn + "]";
	}

}
