package com.ats.triladmin.model.doc;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="m_doc")
public class DocumentBean implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int docId;
	
	private String docName;
	
	private String docIsoSerialNumber;
	
	private String docPrefix;
	
	private String docPostfix;
	
	private String fyYear;
	
	private Date fromDate;
	
	private Date toDate;
	
	private int delStatus;
	
	@Transient
	private SubDocument subDocument;
	
	

	public SubDocument getSubDocument() {
		return subDocument;
	}

	public void setSubDocument(SubDocument subDocument) {
		this.subDocument = subDocument;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getDocIsoSerialNumber() {
		return docIsoSerialNumber;
	}

	public void setDocIsoSerialNumber(String docIsoSerialNumber) {
		this.docIsoSerialNumber = docIsoSerialNumber;
	}

	public String getDocPrefix() {
		return docPrefix;
	}

	public void setDocPrefix(String docPrefix) {
		this.docPrefix = docPrefix;
	}

	public String getDocPostfix() {
		return docPostfix;
	}

	public void setDocPostfix(String docPostfix) {
		this.docPostfix = docPostfix;
	}

	public String getFyYear() {
		return fyYear;
	}

	public void setFyYear(String fyYear) {
		this.fyYear = fyYear;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "yyyy-MM-dd")

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "DocumentBean [id=" + id + ", docId=" + docId + ", docName=" + docName + ", docIsoSerialNumber="
				+ docIsoSerialNumber + ", docPrefix=" + docPrefix + ", docPostfix=" + docPostfix + ", fyYear=" + fyYear
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", delStatus=" + delStatus + "]";
	}
	
}
