package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_delivery_terms")
public class DeliveryTerms {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "delivery_term_id")
	private int deliveryTermId;

	private String deliveryDesc;

	private int isUsed;

	private int createdIn;

	private int deletedIn;

	public int getDeliveryTermId() {
		return deliveryTermId;
	}

	public void setDeliveryTermId(int deliveryTermId) {
		this.deliveryTermId = deliveryTermId;
	}

	public String getDeliveryDesc() {
		return deliveryDesc;
	}

	public void setDeliveryDesc(String deliveryDesc) {
		this.deliveryDesc = deliveryDesc;
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
		return "DeliveryTerms [deliveryTermId=" + deliveryTermId + ", deliveryDesc=" + deliveryDesc + ", isUsed="
				+ isUsed + ", createdIn=" + createdIn + ", deletedIn=" + deletedIn + "]";
	}

}
