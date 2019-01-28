package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_dispatch_mode")
public class DispatchMode {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "disp_mode_id")
	private int dispModeId;

	private String dispModeDesc;

	private int isUsed;

	private int createdIn;

	private int deletedIn;

	public int getDispModeId() {
		return dispModeId;
	}

	public void setDispModeId(int dispModeId) {
		this.dispModeId = dispModeId;
	}

	public String getDispModeDesc() {
		return dispModeDesc;
	}

	public void setDispModeDesc(String dispModeDesc) {
		this.dispModeDesc = dispModeDesc;
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
		return "DispatchMode [dispModeId=" + dispModeId + ", dispModeDesc=" + dispModeDesc + ", isUsed=" + isUsed
				+ ", createdIn=" + createdIn + ", deletedIn=" + deletedIn + "]";
	}

}
