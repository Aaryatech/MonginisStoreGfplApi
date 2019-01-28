package com.ats.triladmin.model.indent;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetIndentByStatus {
	
	@Id
	@Column(name = "ind_m_id")
	private int indMId;

	@Column(name = "ind_m_no")
	private String indMNo;
	
	@Column(name = "ind_m_date")
	private Date indMDate;
  
	@Column(name = "ind_m_status")
	private int indMStatus;
	
	@Column(name = "ind_remark")
	private String indRemark;

	public int getIndMId() {
		return indMId;
	}

	public void setIndMId(int indMId) {
		this.indMId = indMId;
	}

	public String getIndMNo() {
		return indMNo;
	}

	public void setIndMNo(String indMNo) {
		this.indMNo = indMNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIndMDate() {
		return indMDate;
	}

	public void setIndMDate(Date indMDate) {
		this.indMDate = indMDate;
	}

	public int getIndMStatus() {
		return indMStatus;
	}

	public void setIndMStatus(int indMStatus) {
		this.indMStatus = indMStatus;
	}

	public String getIndRemark() {
		return indRemark;
	}

	public void setIndRemark(String indRemark) {
		this.indRemark = indRemark;
	}

	@Override
	public String toString() {
		return "GetIndentByStatus [indMId=" + indMId + ", indMNo=" + indMNo + ", indMDate=" + indMDate + ", indMStatus="
				+ indMStatus + ", indRemark=" + indRemark + "]";
	}
	
	

}
