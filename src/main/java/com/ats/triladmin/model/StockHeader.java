package com.ats.triladmin.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_stock_header")
public class StockHeader {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stock_header_id")
	private int stockHeaderId;

	@Column(name = "stock_category")
	private int stockCategory;

	@Column(name = "month")
	private int month;

	@Column(name = "year")
	private int year;

	@Column(name = "status")
	private int status;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "del_status")
	private int delStatus;
	 
	@Transient
	List<StockDetail> stockDetailList;

	public int getStockHeaderId() {
		return stockHeaderId;
	}

	public void setStockHeaderId(int stockHeaderId) {
		this.stockHeaderId = stockHeaderId;
	}

	public int getStockCategory() {
		return stockCategory;
	}

	public void setStockCategory(int stockCategory) {
		this.stockCategory = stockCategory;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
 
	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public List<StockDetail> getStockDetailList() {
		return stockDetailList;
	}

	public void setStockDetailList(List<StockDetail> stockDetailList) {
		this.stockDetailList = stockDetailList;
	}

	@Override
	public String toString() {
		return "StockHeader [stockHeaderId=" + stockHeaderId + ", stockCategory=" + stockCategory + ", month=" + month
				+ ", year=" + year + ", status=" + status + ", date=" + date + ", delStatus=" + delStatus
				+ ", stockDetailList=" + stockDetailList + "]";
	}
	
	

}
