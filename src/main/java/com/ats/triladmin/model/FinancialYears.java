package com.ats.triladmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_financial_years")
public class FinancialYears {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fin_year_id")
	private int finYearId;

	private String finYear;

	private int isUsed;

	public int getFinYearId() {
		return finYearId;
	}

	public void setFinYearId(int finYearId) {
		this.finYearId = finYearId;
	}

	public String getFinYear() {
		return finYear;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "FinancialYears [finYearId=" + finYearId + ", finYear=" + finYear + ", isUsed=" + isUsed + "]";
	}

}
