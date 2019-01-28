package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_doc_type")
public class DocType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doc_id")
	private int docId;
	
	@Column(name = "doc_name")
	private String docName;

	@Column(name = "prifix")
	private String prifix;
	
	@Column(name = "suffix")
	private String suffix;
	
	@Column(name = "count_current")
	private String countCurrent;
	
	@Column(name = "back_date_open")
	private String backDateOpen;
	
	@Column(name = "iso_number")
	private String isoNumber;
	
	@Column(name = "doc_type")
	private int docType;
	
	@Column(name = "doc_year")
	private String docYear;

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getPrifix() {
		return prifix;
	}

	public void setPrifix(String prifix) {
		this.prifix = prifix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getCountCurrent() {
		return countCurrent;
	}

	public void setCountCurrent(String countCurrent) {
		this.countCurrent = countCurrent;
	}

	public String getBackDateOpen() {
		return backDateOpen;
	}

	public void setBackDateOpen(String backDateOpen) {
		this.backDateOpen = backDateOpen;
	}

	public String getIsoNumber() {
		return isoNumber;
	}

	public void setIsoNumber(String isoNumber) {
		this.isoNumber = isoNumber;
	}

	public int getDocType() {
		return docType;
	}

	public void setDocType(int docType) {
		this.docType = docType;
	}

	public String getDocYear() {
		return docYear;
	}

	public void setDocYear(String docYear) {
		this.docYear = docYear;
	}

	@Override
	public String toString() {
		return "DocType [docId=" + docId + ", docName=" + docName + ", prifix=" + prifix + ", suffix=" + suffix
				+ ", countCurrent=" + countCurrent + ", backDateOpen=" + backDateOpen + ", isoNumber=" + isoNumber
				+ ", docType=" + docType + ", docYear=" + docYear + "]";
	}
	
	
	 

}
