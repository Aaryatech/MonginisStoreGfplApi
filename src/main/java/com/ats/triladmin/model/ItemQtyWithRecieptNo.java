package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemQtyWithRecieptNo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sr")
	private int sr;
	
	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private String date;
	
	@Column(name = "recept_no")
	private String receptNo;
	
	@Column(name = "qty")
	private float qty;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReceptNo() {
		return receptNo;
	}

	public void setReceptNo(String receptNo) {
		this.receptNo = receptNo;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	public int getSr() {
		return sr;
	}

	public void setSr(int sr) {
		this.sr = sr;
	}

	@Override
	public String toString() {
		return "ItemQtyWithRecieptNo [sr=" + sr + ", id=" + id + ", date=" + date + ", receptNo=" + receptNo + ", qty="
				+ qty + "]";
	}
	
	

	

}
