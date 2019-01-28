package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.TaxForm;

public interface TaxFormRepository extends JpaRepository<TaxForm, Integer> {

	TaxForm findByTaxId(int taxId);

	List<TaxForm> findAllByIsUsed(int i);

	@Transactional
	@Modifying
	@Query("UPDATE TaxForm SET isUsed=0 ,deleted_in=:deletedIn WHERE tax_id=:taxId")
	int deleteTaxForm(@Param("taxId") int taxId, @Param("deletedIn") int deletedIn);

}
