package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.FinancialYears;

public interface FinancialYearsRepository extends JpaRepository<FinancialYears, Integer> {

	FinancialYears findFinancialYearsByFinYearId(int finYearId);

	List<FinancialYears> findAllByIsUsed(int i);

	@Transactional
	@Modifying
	@Query("UPDATE FinancialYears SET isUsed=0  WHERE fin_year_id=:finYearId")
	int deleteFinancialYears(@Param("finYearId") int finYearId);

}
