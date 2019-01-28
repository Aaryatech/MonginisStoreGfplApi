package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.PaymentTerms;

public interface PaymentTermsRepository extends JpaRepository<PaymentTerms, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE PaymentTerms SET isUsed=0 ,deleted_in=:deletedIn WHERE pymt_term_id=:pymtTermId")
	int deletePaymentTerms(@Param("pymtTermId") int pymtTermId, @Param("deletedIn") int deletedIn);

	List<PaymentTerms> findAllByIsUsed(int i);

	PaymentTerms findByPymtTermId(int pymtTermId);
	

}
