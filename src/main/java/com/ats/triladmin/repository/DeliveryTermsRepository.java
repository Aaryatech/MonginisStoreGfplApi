package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.DeliveryTerms;

public interface DeliveryTermsRepository extends JpaRepository<DeliveryTerms, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE DeliveryTerms SET isUsed=0 ,deleted_in=:deletedIn WHERE delivery_term_id=:deliveryTermId")
	int deleteDeliveryTerms(@Param("deliveryTermId") int deliveryTermId, @Param("deletedIn") int deletedIn);

	List<DeliveryTerms> findAllByIsUsed(int i);

	DeliveryTerms findDeliveryTermsByDeliveryTermId(int deliveryTermId);

}
